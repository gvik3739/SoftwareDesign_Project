package randoop;

import command.*;
import data.*;
import factory.UserFactory;
import model.*;
import service.*;
import strategy.*;
import util.SystemClock;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Supplemental Randoop-style tests targeting the coverage gaps left by
 * the auto-generated RegressionTest0/ErrorTest0 files.
 *
 * Root cause of low coverage in data/command/service packages:
 *   Randoop passed bare filenames (no parent directory) to update(path),
 *   causing getParentFile() == null → NPE before any real logic ran.
 *
 * Fix here: all file paths use a temp subdirectory so getParentFile()
 * always returns a valid, existing directory.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RandoopSupplementalTest {

    // ---------------------------------------------------------------
    // Each Maven run gets its own unique temp directory (using the JVM
    // start time as a suffix) so stale CSV files from a previous run
    // never cause "already booked" overlaps in MakeReservationCommand.
    // ---------------------------------------------------------------
    private static final String RUN_DIR =
        System.getProperty("java.io.tmpdir")
        + File.separator + "randoop-supp-"
        + ProcessHandle.current().pid();

    private static String tmpPath(String filename) {
        new File(RUN_DIR).mkdirs();
        return RUN_DIR + File.separator + filename;
    }

    // ================================================================
    // data.MaintainPayment  (was 21%)
    // ================================================================

    @Test
    public void test_001_MaintainPayment_loadNonExistentFile() throws Exception {
        MaintainPayment mp = new MaintainPayment();
        mp.load(tmpPath("no_such_payment.csv"));
        assertEquals(0, mp.payments.size());
    }

    @Test
    public void test_002_MaintainPayment_nextIdWhenEmpty() {
        MaintainPayment mp = new MaintainPayment();
        assertEquals("P001", mp.nextId());
    }

    @Test
    public void test_003_MaintainPayment_nextIdAfterOneEntry() {
        MaintainPayment mp = new MaintainPayment();
        mp.payments.add(new Payment("P001", "R001", "S001",
                10.0, "Credit Card", "COMPLETED", "2026-04-01 10:00", "DEPOSIT"));
        assertEquals("P002", mp.nextId());
    }

    @Test
    public void test_004_MaintainPayment_updateCreatesFile() throws Exception {
        String path = tmpPath("payment_write.csv");
        MaintainPayment mp = new MaintainPayment();
        mp.payments.add(new Payment("P001", "R001", "S001",
                50.0, "Credit Card", "COMPLETED", "2026-04-01 09:00", "DEPOSIT"));
        mp.update(path);
        assertTrue(new File(path).exists());
    }

    @Test
    public void test_005_MaintainPayment_roundTrip() throws Exception {
        String path = tmpPath("payment_roundtrip.csv");
        MaintainPayment mp = new MaintainPayment();
        mp.payments.add(new Payment("P001", "R001", "S001",
                75.0, "Debit", "COMPLETED", "2026-04-01 08:00", "DEPOSIT"));
        mp.payments.add(new Payment("P002", "R002", "F001",
                30.0, "Research Grant", "COMPLETED", "2026-04-01 09:00", "FINAL"));
        mp.update(path);

        MaintainPayment mp2 = new MaintainPayment();
        mp2.load(path);
        assertEquals(2, mp2.payments.size());
        assertEquals("P001", mp2.payments.get(0).getPaymentId());
        assertEquals(75.0, mp2.payments.get(0).getAmount(), 0.01);
        assertEquals("P002", mp2.payments.get(1).getPaymentId());
    }

    @Test
    public void test_006_MaintainPayment_updateEmptyListCreatesHeaderOnly() throws Exception {
        String path = tmpPath("payment_empty.csv");
        MaintainPayment mp = new MaintainPayment();
        mp.update(path);

        MaintainPayment mp2 = new MaintainPayment();
        mp2.load(path);
        assertEquals(0, mp2.payments.size());
    }

    // ================================================================
    // data.MaintainEquipment  (was 21%)
    // ================================================================

    @Test
    public void test_010_MaintainEquipment_loadNonExistentFile() throws Exception {
        MaintainEquipment me = new MaintainEquipment();
        me.load(tmpPath("no_such_equip.csv"));
        assertEquals(0, me.equipmentList.size());
    }

    @Test
    public void test_011_MaintainEquipment_updateAndLoad() throws Exception {
        String path = tmpPath("equip_roundtrip.csv");
        MaintainEquipment me = new MaintainEquipment();
        me.equipmentList.add(new Equipment("EQ001", "Oscilloscope", "Lab A"));
        me.equipmentList.add(new Equipment("EQ002", "Spectrum Analyzer", "Lab B"));
        me.update(path);

        MaintainEquipment me2 = new MaintainEquipment();
        me2.load(path);
        assertEquals(2, me2.equipmentList.size());
        assertEquals("EQ001", me2.equipmentList.get(0).getEquipmentId());
        assertEquals("Oscilloscope", me2.equipmentList.get(0).getDescription());
    }

    @Test
    public void test_012_MaintainEquipment_findByIdFound() {
        MaintainEquipment me = new MaintainEquipment();
        Equipment eq = new Equipment("EQ001", "Oscilloscope", "Lab A");
        me.equipmentList.add(eq);
        assertNotNull(me.findById("EQ001"));
        assertEquals("EQ001", me.findById("EQ001").getEquipmentId());
    }

    @Test
    public void test_013_MaintainEquipment_findByIdNotFound() {
        MaintainEquipment me = new MaintainEquipment();
        me.equipmentList.add(new Equipment("EQ001", "Oscilloscope", "Lab A"));
        assertNull(me.findById("EQ999"));
    }

    @Test
    public void test_014_MaintainEquipment_getAvailableEquipmentFiltersCorrectly() {
        MaintainEquipment me = new MaintainEquipment();
        Equipment eq1 = new Equipment("EQ001", "Oscilloscope", "Lab A"); // AVAILABLE
        Equipment eq2 = new Equipment("EQ002", "Laser", "Lab B");
        eq2.disable(); // DISABLED
        Equipment eq3 = new Equipment("EQ003", "Spectrometer", "Lab C");
        eq3.markUnderMaintenance(); // MAINTENANCE
        me.equipmentList.add(eq1);
        me.equipmentList.add(eq2);
        me.equipmentList.add(eq3);

        List<Equipment> available = me.getAvailableEquipment();
        assertEquals(1, available.size());
        assertEquals("EQ001", available.get(0).getEquipmentId());
    }

    @Test
    public void test_015_MaintainEquipment_persistsDisabledState() throws Exception {
        String path = tmpPath("equip_disabled.csv");
        MaintainEquipment me = new MaintainEquipment();
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        eq.disable();
        me.equipmentList.add(eq);
        me.update(path);

        MaintainEquipment me2 = new MaintainEquipment();
        me2.load(path);
        assertEquals("DISABLED", me2.equipmentList.get(0).getStatus());
        assertFalse(me2.equipmentList.get(0).canReserve());
    }

    @Test
    public void test_016_MaintainEquipment_persistsMaintenanceState() throws Exception {
        String path = tmpPath("equip_maint.csv");
        MaintainEquipment me = new MaintainEquipment();
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        eq.markUnderMaintenance();
        me.equipmentList.add(eq);
        me.update(path);

        MaintainEquipment me2 = new MaintainEquipment();
        me2.load(path);
        assertEquals("MAINTENANCE", me2.equipmentList.get(0).getStatus());
    }

    // ================================================================
    // data.MaintainReservation  (was 21%)
    // ================================================================

    @Test
    public void test_020_MaintainReservation_loadNonExistentFile() throws Exception {
        MaintainReservation mr = new MaintainReservation();
        mr.load(tmpPath("no_such_res.csv"));
        assertEquals(0, mr.reservations.size());
    }

    @Test
    public void test_021_MaintainReservation_nextIdWhenEmpty() {
        MaintainReservation mr = new MaintainReservation();
        assertEquals("R001", mr.nextId());
    }

    @Test
    public void test_022_MaintainReservation_nextIdAfterOneEntry() {
        MaintainReservation mr = new MaintainReservation();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        mr.reservations.add(new Reservation("R001", s, eq,
                LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4), 10.0));
        assertEquals("R002", mr.nextId());
    }

    @Test
    public void test_023_MaintainReservation_updateAndLoad() throws Exception {
        String path = tmpPath("res_roundtrip.csv");
        MaintainReservation mr = new MaintainReservation();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        LocalDateTime start = LocalDateTime.of(2026, 6, 1, 10, 0);
        LocalDateTime end   = LocalDateTime.of(2026, 6, 1, 12, 0);
        Reservation res = new Reservation("R001", s, eq, start, end, 20.0);
        mr.reservations.add(res);
        mr.update(path);

        MaintainReservation mr2 = new MaintainReservation();
        mr2.load(path);
        assertEquals(1, mr2.reservations.size());
        assertEquals("R001", mr2.reservations.get(0).getReservationId());
        assertEquals("ACTIVE", mr2.reservations.get(0).getStatus());
    }

    @Test
    public void test_024_MaintainReservation_hasOverlapTrueCase() {
        MaintainReservation mr = new MaintainReservation();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        LocalDateTime start = LocalDateTime.of(2026, 6, 1, 10, 0);
        LocalDateTime end   = LocalDateTime.of(2026, 6, 1, 12, 0);
        mr.reservations.add(new Reservation("R001", s, eq, start, end, 10.0));

        // Overlapping window
        assertTrue(mr.hasOverlap("EQ001",
                LocalDateTime.of(2026, 6, 1, 11, 0),
                LocalDateTime.of(2026, 6, 1, 13, 0), null));
    }

    @Test
    public void test_025_MaintainReservation_hasOverlapFalseCase() {
        MaintainReservation mr = new MaintainReservation();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        LocalDateTime start = LocalDateTime.of(2026, 6, 1, 10, 0);
        LocalDateTime end   = LocalDateTime.of(2026, 6, 1, 12, 0);
        mr.reservations.add(new Reservation("R001", s, eq, start, end, 10.0));

        // Non-overlapping (touching at end boundary)
        assertFalse(mr.hasOverlap("EQ001",
                LocalDateTime.of(2026, 6, 1, 12, 0),
                LocalDateTime.of(2026, 6, 1, 14, 0), null));
    }

    @Test
    public void test_026_MaintainReservation_hasOverlapExcludesById() {
        MaintainReservation mr = new MaintainReservation();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        LocalDateTime start = LocalDateTime.of(2026, 6, 1, 10, 0);
        LocalDateTime end   = LocalDateTime.of(2026, 6, 1, 12, 0);
        mr.reservations.add(new Reservation("R001", s, eq, start, end, 10.0));

        // Same window but the reservation is excluded by ID — no overlap
        assertFalse(mr.hasOverlap("EQ001",
                LocalDateTime.of(2026, 6, 1, 11, 0),
                LocalDateTime.of(2026, 6, 1, 13, 0), "R001"));
    }

    @Test
    public void test_027_MaintainReservation_hasOverlapSkipsCancelled() {
        MaintainReservation mr = new MaintainReservation();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        LocalDateTime start = LocalDateTime.of(2026, 6, 1, 10, 0);
        LocalDateTime end   = LocalDateTime.of(2026, 6, 1, 12, 0);
        Reservation res = new Reservation("R001", s, eq, start, end, 10.0);
        res.setStatus("CANCELLED");
        mr.reservations.add(res);

        // CANCELLED reservations don't block overlap check
        assertFalse(mr.hasOverlap("EQ001",
                LocalDateTime.of(2026, 6, 1, 11, 0),
                LocalDateTime.of(2026, 6, 1, 13, 0), null));
    }

    @Test
    public void test_028_MaintainReservation_hasOverlapStringVersion() {
        MaintainReservation mr = new MaintainReservation();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        LocalDateTime start = LocalDateTime.of(2026, 6, 1, 10, 0);
        LocalDateTime end   = LocalDateTime.of(2026, 6, 1, 12, 0);
        mr.reservations.add(new Reservation("R001", s, eq, start, end, 10.0));

        assertTrue(mr.hasOverlap("EQ001",
                "2026-06-01 11:00", "2026-06-01 13:00", null));
    }

    @Test
    public void test_029_MaintainReservation_forfeitedDepositRoundTrip() throws Exception {
        String path = tmpPath("res_forfeited.csv");
        MaintainReservation mr = new MaintainReservation();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Reservation res = new Reservation("R001", s, eq,
                LocalDateTime.of(2026, 6, 1, 10, 0),
                LocalDateTime.of(2026, 6, 1, 12, 0), 20.0);
        res.forfeitDeposit();
        mr.reservations.add(res);
        mr.update(path);

        MaintainReservation mr2 = new MaintainReservation();
        mr2.load(path);
        assertTrue(mr2.reservations.get(0).isDepositForfeited());
    }

    // ================================================================
    // data.MaintainUser  (was 21%)
    // ================================================================

    @Test
    public void test_030_MaintainUser_loadNonExistentFile() throws Exception {
        MaintainUser mu = new MaintainUser();
        mu.load(tmpPath("no_such_users.csv"));
        assertEquals(0, mu.users.size());
    }

    @Test
    public void test_031_MaintainUser_updateAndLoad_Student() throws Exception {
        String path = tmpPath("users_student.csv");
        MaintainUser mu = new MaintainUser();
        mu.users.add(new Student("Alice", "alice@test.com", "Pass1!", "S001"));
        mu.update(path);

        MaintainUser mu2 = new MaintainUser();
        mu2.load(path);
        assertEquals(1, mu2.users.size());
        assertEquals("alice@test.com", mu2.users.get(0).getEmail());
        assertEquals("student", mu2.users.get(0).getUserType().toLowerCase());
    }

    @Test
    public void test_032_MaintainUser_loadMultipleUserTypes() throws Exception {
        String path = tmpPath("users_multi.csv");
        MaintainUser mu = new MaintainUser();
        mu.users.add(new Student("Alice", "alice@test.com", "Pass1!", "S001"));
        mu.users.add(new Faculty("Bob", "bob@test.com", "Pass1!", "F001", true));
        mu.users.add(new Researcher("Carol", "carol@test.com", "Pass1!", "R001", true));
        mu.users.add(new Guest("Dave", "dave@test.com", "Pass1!", "G001"));
        mu.users.add(new LabManager("Eve", "eve@test.com", "Pass1!", "L001"));
        mu.update(path);

        MaintainUser mu2 = new MaintainUser();
        mu2.load(path);
        assertEquals(5, mu2.users.size());
    }

    @Test
    public void test_033_MaintainUser_findByEmailFound() {
        MaintainUser mu = new MaintainUser();
        mu.users.add(new Student("Alice", "alice@test.com", "Pass1!", "S001"));
        User found = mu.findByEmail("alice@test.com");
        assertNotNull(found);
        assertEquals("S001", found.getIdNumber());
    }

    @Test
    public void test_034_MaintainUser_findByEmailNotFound() {
        MaintainUser mu = new MaintainUser();
        mu.users.add(new Student("Alice", "alice@test.com", "Pass1!", "S001"));
        assertNull(mu.findByEmail("nobody@test.com"));
    }

    @Test
    public void test_035_MaintainUser_findByIdFound() {
        MaintainUser mu = new MaintainUser();
        mu.users.add(new Student("Alice", "alice@test.com", "Pass1!", "S001"));
        assertNotNull(mu.findById("S001"));
    }

    @Test
    public void test_036_MaintainUser_findByIdNotFound() {
        MaintainUser mu = new MaintainUser();
        mu.users.add(new Student("Alice", "alice@test.com", "Pass1!", "S001"));
        assertNull(mu.findById("X999"));
    }

    // ================================================================
    // command.CommandManager  (was 38%)
    // ================================================================

    @Test
    public void test_040_CommandManager_executeSuccess_addsToHistory() {
        CommandManager cm = new CommandManager();
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);

        boolean result = cm.execute(new MakeReservationCommand(
                s, eq, start, end,
                tmpPath("cm_res.csv"), tmpPath("cm_pay.csv"),
                new ResearchGrantPaymentStrategy()));
        assertTrue(result);
        assertEquals(1, cm.getHistory().size());
    }

    @Test
    public void test_041_CommandManager_executeFailedPrecondition_notAddedToHistory() {
        CommandManager cm = new CommandManager();
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        eq.disable(); // cannot reserve disabled equipment
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);

        boolean result = cm.execute(new MakeReservationCommand(
                s, eq, start, end,
                tmpPath("cm_fail_res.csv"), tmpPath("cm_fail_pay.csv"),
                new ResearchGrantPaymentStrategy()));
        assertFalse(result);
        assertEquals(0, cm.getHistory().size());
    }

    @Test
    public void test_042_CommandManager_getHistoryReturnsAll() {
        CommandManager cm = new CommandManager();
        assertEquals(0, cm.getHistory().size());
    }

    @Test
    public void test_043_CommandManager_printHistoryEmpty() {
        CommandManager cm = new CommandManager();
        cm.printHistory(); // Should not throw
    }

    @Test
    public void test_044_CommandManager_printHistoryWithEntries() {
        CommandManager cm = new CommandManager();
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        cm.execute(new MakeReservationCommand(s, eq, start, end,
                tmpPath("cm_hist_res.csv"), tmpPath("cm_hist_pay.csv"),
                new ResearchGrantPaymentStrategy()));
        cm.printHistory(); // Should print without throwing
        assertEquals(1, cm.getHistory().size());
    }

    // ================================================================
    // command.MakeReservationCommand  (was 38%)
    // ================================================================

    @Test
    public void test_050_MakeReservation_canExecute_equipmentNotAvailable() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        eq.disable();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);

        MakeReservationCommand cmd = new MakeReservationCommand(s, eq, start, end,
                tmpPath("make_na_res.csv"), tmpPath("make_na_pay.csv"),
                new ResearchGrantPaymentStrategy());
        assertFalse(cmd.canExecute());
        assertTrue(cmd.getErrorMessage().contains("not available"));
    }

    @Test
    public void test_051_MakeReservation_canExecute_startInPast() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime pastStart = SystemClock.getInstance().now().minusHours(1);
        LocalDateTime end       = SystemClock.getInstance().now().plusHours(1);

        MakeReservationCommand cmd = new MakeReservationCommand(s, eq, pastStart, end,
                tmpPath("make_past_res.csv"), tmpPath("make_past_pay.csv"),
                new ResearchGrantPaymentStrategy());
        assertFalse(cmd.canExecute());
        assertEquals("Start time must be in the future.", cmd.getErrorMessage());
    }

    @Test
    public void test_052_MakeReservation_executeSuccessfully() throws Exception {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        String resPath = tmpPath("make_ok_res.csv");
        String payPath = tmpPath("make_ok_pay.csv");

        MakeReservationCommand cmd = new MakeReservationCommand(s, eq, start, end,
                resPath, payPath, new CreditCardPaymentStrategy());
        assertTrue(cmd.canExecute());
        cmd.execute();

        // Verify reservation was persisted
        MaintainReservation mr = new MaintainReservation();
        mr.load(resPath);
        assertEquals(1, mr.reservations.size());
        assertEquals("R001", mr.reservations.get(0).getReservationId());

        // Verify description
        assertTrue(cmd.getDescription().contains("EQ001")
                || cmd.getDescription().contains("Scope"));
    }

    // ================================================================
    // command.CancelReservationCommand  (was 38%)
    // ================================================================

    @Test
    public void test_060_CancelReservation_canExecute_alreadyStarted() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime past = SystemClock.getInstance().now().minusHours(1);
        LocalDateTime end  = SystemClock.getInstance().now().plusHours(1);
        Reservation res = new Reservation("R001", s, eq, past, end, 20.0);

        CancelReservationCommand cmd = new CancelReservationCommand(res, tmpPath("cancel_na.csv"));
        assertFalse(cmd.canExecute());
        assertEquals("Cannot cancel a reservation after it has started.", cmd.getErrorMessage());
    }

    @Test
    public void test_061_CancelReservation_canExecute_alreadyCancelled() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        Reservation res = new Reservation("R001", s, eq, start, end, 20.0);
        res.setStatus("CANCELLED");

        CancelReservationCommand cmd = new CancelReservationCommand(res, tmpPath("cancel_already.csv"));
        assertFalse(cmd.canExecute());
        assertEquals("Reservation is already cancelled.", cmd.getErrorMessage());
    }

    @Test
    public void test_062_CancelReservation_executeSuccess() throws Exception {
        String resPath = tmpPath("cancel_ok_res.csv");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        Reservation res = new Reservation("R001", s, eq, start, end, 20.0);

        // Persist the reservation so execute() can load and modify it
        MaintainReservation mr = new MaintainReservation();
        mr.reservations.add(res);
        mr.update(resPath);

        CancelReservationCommand cmd = new CancelReservationCommand(res, resPath);
        assertTrue(cmd.canExecute());
        cmd.execute();
        assertEquals("Cancel reservation R001", cmd.getDescription());
    }

    @Test
    public void test_063_CancelReservation_descriptionFormat() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        Reservation res = new Reservation("R005", s, eq, start, end, 20.0);

        CancelReservationCommand cmd = new CancelReservationCommand(res, tmpPath("cancel_desc.csv"));
        assertEquals("Cancel reservation R005", cmd.getDescription());
    }

    // ================================================================
    // command.ModifyReservationCommand  (was 38%)
    // ================================================================

    @Test
    public void test_070_ModifyReservation_canExecute_alreadyStarted() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime past = SystemClock.getInstance().now().minusHours(1);
        LocalDateTime end  = SystemClock.getInstance().now().plusHours(1);
        Reservation res = new Reservation("R001", s, eq, past, end, 20.0);

        ModifyReservationCommand cmd = new ModifyReservationCommand(res,
                SystemClock.getInstance().now().plusHours(3),
                SystemClock.getInstance().now().plusHours(5),
                tmpPath("modify_na.csv"));
        assertFalse(cmd.canExecute());
        assertEquals("Cannot modify a reservation after it has started.", cmd.getErrorMessage());
    }

    @Test
    public void test_071_ModifyReservation_executeSuccess() throws Exception {
        String resPath = tmpPath("modify_ok_res.csv");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        Reservation res = new Reservation("R001", s, eq, start, end, 20.0);

        MaintainReservation mr = new MaintainReservation();
        mr.reservations.add(res);
        mr.update(resPath);

        LocalDateTime newStart = SystemClock.getInstance().now().plusHours(6);
        LocalDateTime newEnd   = SystemClock.getInstance().now().plusHours(8);
        ModifyReservationCommand cmd = new ModifyReservationCommand(res, newStart, newEnd, resPath);
        assertTrue(cmd.canExecute());
        cmd.execute();

        assertTrue(cmd.getDescription().contains("Modify reservation R001"));
    }

    // ================================================================
    // command.ExtendReservationCommand  (was 38%)
    // ================================================================

    @Test
    public void test_080_ExtendReservation_canExecute_newEndBeforeCurrent() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        Reservation res = new Reservation("R001", s, eq, start, end, 20.0);

        // newEnd is before current end — should fail
        ExtendReservationCommand cmd = new ExtendReservationCommand(res,
                SystemClock.getInstance().now().plusHours(3),
                tmpPath("extend_na.csv"));
        assertFalse(cmd.canExecute());
        assertEquals("New end time must be after the current end time.", cmd.getErrorMessage());
    }

    @Test
    public void test_081_ExtendReservation_executeSuccess() throws Exception {
        String resPath = tmpPath("extend_ok_res.csv");
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        Reservation res = new Reservation("R001", s, eq, start, end, 20.0);

        MaintainReservation mr = new MaintainReservation();
        mr.reservations.add(res);
        mr.update(resPath);

        LocalDateTime newEnd = SystemClock.getInstance().now().plusHours(6);
        ExtendReservationCommand cmd = new ExtendReservationCommand(res, newEnd, resPath);
        assertTrue(cmd.canExecute());
        cmd.execute();
        assertTrue(cmd.getDescription().contains("Extend reservation R001"));
    }

    // ================================================================
    // service.BillingService  (was 60%)
    // ================================================================

    @Test
    public void test_090_BillingService_calculateFeeWithDepositNotForfeited() {
        BillingService bs = new BillingService();
        bs.setPricingStrategy(new StudentPricingStrategy()); // rate = 10.0
        // 3 hours × 10.0 = 30.0, minus 1 hour deposit = 20.0
        assertEquals(20.0, bs.calculateFeeWithDeposit(3.0, false), 0.01);
    }

    @Test
    public void test_091_BillingService_calculateFeeWithDepositForfeited() {
        BillingService bs = new BillingService();
        bs.setPricingStrategy(new StudentPricingStrategy()); // rate = 10.0
        // Forfeited: no deduction
        assertEquals(30.0, bs.calculateFeeWithDeposit(3.0, true), 0.01);
    }

    @Test
    public void test_092_BillingService_getDeposit() {
        BillingService bs = new BillingService();
        bs.setPricingStrategy(new FacultyPricingStrategy());
        assertTrue(bs.getDeposit() > 0);
    }

    @Test
    public void test_093_BillingService_getHourlyRate() {
        BillingService bs = new BillingService();
        bs.setPricingStrategy(new StudentPricingStrategy());
        assertEquals(10.0, bs.getHourlyRate(), 0.01);
    }

    @Test
    public void test_094_BillingService_getPaymentMethodName() {
        BillingService bs = new BillingService();
        bs.setPaymentStrategy(new CreditCardPaymentStrategy());
        assertEquals("Credit Card", bs.getPaymentMethodName());
    }

    @Test
    public void test_095_BillingService_processPaymentDebit() {
        BillingService bs = new BillingService();
        bs.setPaymentStrategy(new DebitPaymentStrategy());
        assertTrue(bs.processPayment(25.0));
    }

    @Test(expected = IllegalStateException.class)
    public void test_096_BillingService_calculateFee_nullPricing_throws() {
        BillingService bs = new BillingService();
        bs.calculateFee(1.0); // no pricing set
    }

    @Test(expected = IllegalStateException.class)
    public void test_097_BillingService_processPayment_nullPayment_throws() {
        BillingService bs = new BillingService();
        bs.processPayment(10.0); // no payment strategy set
    }

    @Test(expected = IllegalStateException.class)
    public void test_098_BillingService_getPaymentMethodName_nullPayment_throws() {
        BillingService bs = new BillingService();
        bs.getPaymentMethodName(); // no payment strategy set
    }

    @Test(expected = IllegalStateException.class)
    public void test_099_BillingService_getHourlyRate_nullPricing_throws() {
        BillingService bs = new BillingService();
        bs.getHourlyRate(); // no pricing strategy set
    }

    // ================================================================
    // service.ReservationService  (was 60%)
    // ================================================================

    @Test
    public void test_100_ReservationService_getAllReservations_emptyWhenNoFile() {
        ReservationService rs = new ReservationService(
                tmpPath("rs_nonexist_res.csv"), tmpPath("rs_nonexist_pay.csv"));
        List<Reservation> all = rs.getAllReservations();
        assertNotNull(all);
        assertEquals(0, all.size());
    }

    @Test
    public void test_101_ReservationService_makeReservation_success() {
        ReservationService rs = new ReservationService(
                tmpPath("rs_make_res.csv"), tmpPath("rs_make_pay.csv"));
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);

        boolean result = rs.makeReservation(s, eq, start, end, new ResearchGrantPaymentStrategy());
        assertTrue(result);
    }

    @Test
    public void test_102_ReservationService_makeReservation_equipmentUnavailable() {
        ReservationService rs = new ReservationService(
                tmpPath("rs_unavail_res.csv"), tmpPath("rs_unavail_pay.csv"));
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        eq.disable();
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);

        boolean result = rs.makeReservation(s, eq, start, end, new ResearchGrantPaymentStrategy());
        assertFalse(result);
    }

    @Test
    public void test_103_ReservationService_cancelReservation() {
        String resPath = tmpPath("rs_cancel_res.csv");
        ReservationService rs = new ReservationService(resPath, tmpPath("rs_cancel_pay.csv"));
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        rs.makeReservation(s, eq, start, end, new ResearchGrantPaymentStrategy());

        Reservation res = rs.getAllReservations().get(0);
        boolean result = rs.cancelReservation(res);
        assertTrue(result);
    }

    @Test
    public void test_104_ReservationService_modifyReservation() {
        String resPath = tmpPath("rs_modify_res.csv");
        ReservationService rs = new ReservationService(resPath, tmpPath("rs_modify_pay.csv"));
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        rs.makeReservation(s, eq, start, end, new ResearchGrantPaymentStrategy());

        Reservation res = rs.getAllReservations().get(0);
        LocalDateTime newStart = SystemClock.getInstance().now().plusHours(6);
        LocalDateTime newEnd   = SystemClock.getInstance().now().plusHours(8);
        boolean result = rs.modifyReservation(res, newStart, newEnd);
        assertTrue(result);
    }

    @Test
    public void test_105_ReservationService_extendReservation() {
        String resPath = tmpPath("rs_extend_res.csv");
        ReservationService rs = new ReservationService(resPath, tmpPath("rs_extend_pay.csv"));
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        rs.makeReservation(s, eq, start, end, new ResearchGrantPaymentStrategy());

        Reservation res = rs.getAllReservations().get(0);
        LocalDateTime newEnd = SystemClock.getInstance().now().plusHours(6);
        boolean result = rs.extendReservation(res, newEnd);
        assertTrue(result);
    }

    @Test
    public void test_106_ReservationService_getReservationsForUser() {
        String resPath = tmpPath("rs_byuser_res.csv");
        ReservationService rs = new ReservationService(resPath, tmpPath("rs_byuser_pay.csv"));
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        rs.makeReservation(s, eq, start, end, new ResearchGrantPaymentStrategy());

        List<Reservation> userRes = rs.getReservationsForUser("S001");
        assertEquals(1, userRes.size());

        List<Reservation> noRes = rs.getReservationsForUser("S999");
        assertEquals(0, noRes.size());
    }

    @Test
    public void test_107_ReservationService_getReservationsForEquipment() {
        String resPath = tmpPath("rs_byeq_res.csv");
        ReservationService rs = new ReservationService(resPath, tmpPath("rs_byeq_pay.csv"));
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = SystemClock.getInstance().now().plusHours(2);
        LocalDateTime end   = SystemClock.getInstance().now().plusHours(4);
        rs.makeReservation(s, eq, start, end, new ResearchGrantPaymentStrategy());

        List<Reservation> eqRes = rs.getReservationsForEquipment("EQ001");
        assertEquals(1, eqRes.size());
    }

    @Test
    public void test_108_ReservationService_printCommandHistoryNoThrow() {
        ReservationService rs = new ReservationService(
                tmpPath("rs_hist_res.csv"), tmpPath("rs_hist_pay.csv"));
        rs.printCommandHistory(); // should not throw
    }

    @Test
    public void test_109_ReservationService_getLastError_returnsString() {
        ReservationService rs = new ReservationService(
                tmpPath("rs_err_res.csv"), tmpPath("rs_err_pay.csv"));
        assertNotNull(rs.getLastError());
    }

    // ================================================================
    // service.RegistrationService  (was 60%)
    // ================================================================

    @Test
    public void test_110_RegistrationService_registerUserValidPassword() {
        RegistrationService reg = new RegistrationService();
        User u = reg.registerUser("Student", "Alice", "alice@test.com", "Pass1!", "S001", true);
        assertNotNull(u);
        assertEquals("alice@test.com", u.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_111_RegistrationService_registerUserInvalidPassword_throws() {
        RegistrationService reg = new RegistrationService();
        reg.registerUser("Student", "Alice", "alice@test.com", "weakpass", "S001", true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_112_RegistrationService_registerUserNoUppercase_throws() {
        RegistrationService reg = new RegistrationService();
        reg.registerUser("Student", "Alice", "alice@test.com", "pass1!", "S001", true);
    }

    // ================================================================
    // service.LateArrivalObserver  (was 60%)
    // ================================================================

    @Test
    public void test_120_LateArrivalObserver_forfeitsDepositWhenLate() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = LocalDateTime.now().minusMinutes(30);
        LocalDateTime end   = LocalDateTime.now().plusHours(1);
        Reservation res = new Reservation("R001", s, eq, start, end, 20.0);
        assertFalse(res.isDepositForfeited());

        LateArrivalObserver obs = new LateArrivalObserver(List.of(res));
        obs.update(LocalDateTime.now()); // past 20-min grace period
        assertTrue(res.isDepositForfeited());
    }

    @Test
    public void test_121_LateArrivalObserver_doesNotForfeitIfArrived() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = LocalDateTime.now().minusMinutes(30);
        LocalDateTime end   = LocalDateTime.now().plusHours(1);
        Reservation res = new Reservation("R001", s, eq, start, end, 20.0);
        res.markArrived();

        LateArrivalObserver obs = new LateArrivalObserver(List.of(res));
        obs.update(LocalDateTime.now());
        assertFalse(res.isDepositForfeited()); // arrived, so no forfeiture
    }

    @Test
    public void test_122_LateArrivalObserver_ignoresNonDateTimeEvent() {
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        Student s = new Student("Alice", "alice@test.com", "Pass1!", "S001");
        LocalDateTime start = LocalDateTime.now().minusMinutes(30);
        Reservation res = new Reservation("R001", s, eq, start, start.plusHours(2), 20.0);

        LateArrivalObserver obs = new LateArrivalObserver(List.of(res));
        obs.update("not a date"); // non-LocalDateTime event — should be ignored
        assertFalse(res.isDepositForfeited());
    }

    // ================================================================
    // service.SensorUpdateObserver  (was 60%)
    // ================================================================

    @Test
    public void test_130_SensorUpdateObserver_handlesEquipmentEvent() {
        SensorUpdateObserver obs = new SensorUpdateObserver();
        Equipment eq = new Equipment("EQ001", "Scope", "Lab A");
        obs.update(eq); // should not throw
    }

    @Test
    public void test_131_SensorUpdateObserver_handlesUsageRecordEvent() {
        SensorUpdateObserver obs = new SensorUpdateObserver();
        UsageRecord record = new UsageRecord("UR001", "EQ001", "S001", 45, "COMPLETED");
        obs.update(record); // should not throw
    }

    @Test
    public void test_132_SensorUpdateObserver_ignoresUnknownEvent() {
        SensorUpdateObserver obs = new SensorUpdateObserver();
        obs.update("unknown event type"); // should not throw
    }

    // ================================================================
    // factory.UserFactory  (was 50%)
    // ================================================================

    @Test
    public void test_140_UserFactory_createStudent() {
        UserFactory uf = new UserFactory();
        User u = uf.createUser("student", "Alice", "a@test.com", "Pass1!", "S001", true);
        assertNotNull(u);
        assertEquals("student", u.getUserType().toLowerCase());
    }

    @Test
    public void test_141_UserFactory_createFaculty() {
        UserFactory uf = new UserFactory();
        User u = uf.createUser("faculty", "Bob", "b@test.com", "Pass1!", "F001", true);
        assertNotNull(u);
        assertEquals("faculty", u.getUserType().toLowerCase());
    }

    @Test
    public void test_142_UserFactory_createResearcher() {
        UserFactory uf = new UserFactory();
        User u = uf.createUser("researcher", "Carol", "c@test.com", "Pass1!", "R001", true);
        assertNotNull(u);
        assertEquals("researcher", u.getUserType().toLowerCase());
    }

    @Test
    public void test_143_UserFactory_createGuest() {
        UserFactory uf = new UserFactory();
        User u = uf.createUser("guest", "Dave", "d@test.com", "Pass1!", "G001", false);
        assertNotNull(u);
        assertEquals("guest", u.getUserType().toLowerCase());
    }

    @Test
    public void test_144_UserFactory_createLabManager() {
        UserFactory uf = new UserFactory();
        User u = uf.createUser("labmanager", "Eve", "e@test.com", "Pass1!", "L001", true);
        assertNotNull(u);
        assertEquals("labmanager", u.getUserType().toLowerCase());
    }

    @Test
    public void test_145_UserFactory_createLabManagerDirectMethod() {
        UserFactory uf = new UserFactory();
        LabManager lm = uf.createLabManager("Eve", "e@test.com", "Pass1!", "L001");
        assertNotNull(lm);
        assertEquals("L001", lm.getIdNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_146_UserFactory_createUser_invalidType_throws() {
        UserFactory uf = new UserFactory();
        uf.createUser("alien", "X", "x@test.com", "Pass1!", "X001", true);
    }
}

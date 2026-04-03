package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.ModifyReservationCommand;
import model.*;
import util.SystemClock;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Tests for ModifyReservationCommand.
 * Preconditions: (1) current time < start time, (2) no overlap in new slot.
 * Real data: James Carter (123456789), EQ001.
 */
public class ModifyReservationCommandTest {

    private File tempCsv;
    private Student student;
    private Equipment microscope;
    private LocalDateTime futureStart;
    private LocalDateTime futureEnd;
    private Reservation futureReservation;
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @BeforeEach
    public void setUp() throws Exception {
        tempCsv   = File.createTempFile("res_modify", ".csv");
        tempCsv.deleteOnExit();
        student   = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        microscope = new Equipment("EQ001", "Digital Microscope", "Lab A");
        futureStart = SystemClock.getInstance().now().plusDays(1);
        futureEnd   = futureStart.plusHours(2);
        futureReservation = new Reservation("R001", student, microscope, futureStart, futureEnd, 10.0);

        // Write the reservation to temp CSV
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv))) {
            pw.println("reservationId,userId,equipmentId,startTime,endTime,status,depositAmount,depositForfeited");
            pw.println("R001,123456789,EQ001," + futureStart.format(FMT) + "," + futureEnd.format(FMT) + ",ACTIVE,10.00,false");
        }
    }

    @AfterEach
    public void tearDown() {
        if (tempCsv != null) tempCsv.delete();
    }

    @Test
    public void testCanExecute_futureReservationNoConflict_returnsTrue() {
        LocalDateTime newStart = futureStart.plusDays(2);
        LocalDateTime newEnd   = newStart.plusHours(2);
        ModifyReservationCommand cmd = new ModifyReservationCommand(futureReservation, newStart, newEnd, tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testCanExecute_reservationAlreadyStarted_returnsFalse() {
        LocalDateTime pastStart = SystemClock.getInstance().now().minusHours(1);
        LocalDateTime pastEnd   = pastStart.plusHours(2);
        Reservation past = new Reservation("R002", student, microscope, pastStart, pastEnd, 10.0);
        ModifyReservationCommand cmd = new ModifyReservationCommand(past,
            futureStart.plusDays(1), futureEnd.plusDays(1), tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute(),
            "Cannot modify a reservation that has already started");
    }

    @Test
    public void testGetErrorMessage_pastReservation_containsError() {
        LocalDateTime pastStart = SystemClock.getInstance().now().minusHours(1);
        LocalDateTime pastEnd   = pastStart.plusHours(2);
        Reservation past = new Reservation("R002", student, microscope, pastStart, pastEnd, 10.0);
        ModifyReservationCommand cmd = new ModifyReservationCommand(past,
            futureStart, futureEnd, tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertFalse(cmd.getErrorMessage().isEmpty());
    }

    @Test
    public void testGetErrorMessage_validModification_isEmpty() {
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            futureReservation,
            futureStart.plusDays(2), futureEnd.plusDays(2),
            tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertEquals("", cmd.getErrorMessage());
    }

    @Test
    public void testGetDescription_containsReservationId() {
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            futureReservation, futureStart.plusDays(2), futureEnd.plusDays(2), tempCsv.getAbsolutePath());
        assertTrue(cmd.getDescription().contains("R001"));
    }

    @Test
    public void testExecute_updatesStartAndEndTime() throws Exception {
        LocalDateTime newStart = futureStart.plusDays(2);
        LocalDateTime newEnd   = newStart.plusHours(3);
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            futureReservation, newStart, newEnd, tempCsv.getAbsolutePath());
        cmd.execute();

        // CSV stores only minute precision (yyyy-MM-dd HH:mm), so truncate before comparing
        LocalDateTime expectedStart = newStart.truncatedTo(java.time.temporal.ChronoUnit.MINUTES);
        LocalDateTime expectedEnd   = newEnd.truncatedTo(java.time.temporal.ChronoUnit.MINUTES);
        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals(expectedStart, mr.reservations.get(0).getStartTime());
        assertEquals(expectedEnd,   mr.reservations.get(0).getEndTime());
    }

    @Test
    public void testExecute_setsStatusToModified() throws Exception {
        LocalDateTime newStart = futureStart.plusDays(2);
        LocalDateTime newEnd   = newStart.plusHours(2);
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            futureReservation, newStart, newEnd, tempCsv.getAbsolutePath());
        cmd.execute();

        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals("MODIFIED", mr.reservations.get(0).getStatus());
    }

    @Test
    public void testCanExecute_overlappingSlot_returnsFalse() throws Exception {
        // Add a second reservation that occupies the new slot we want to move to
        LocalDateTime conflictStart = futureStart.plusDays(2);
        LocalDateTime conflictEnd   = conflictStart.plusHours(2);
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv, true))) {
            pw.println("R099,987654321,EQ001," + conflictStart.format(FMT) + "," + conflictEnd.format(FMT) + ",ACTIVE,15.00,false");
        }
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            futureReservation, conflictStart, conflictEnd, tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute(),
            "Should not modify if the new slot is already taken");
    }

    @Test
    public void testGetDescription_containsNewTimes() {
        LocalDateTime ns = futureStart.plusDays(3);
        LocalDateTime ne = ns.plusHours(2);
        ModifyReservationCommand cmd = new ModifyReservationCommand(futureReservation, ns, ne, tempCsv.getAbsolutePath());
        String desc = cmd.getDescription();
        assertTrue(desc.contains(ns.format(FMT)) || desc.contains(ne.format(FMT)));
    }

    @Test
    public void testCanExecute_modifiedStatusReservation_returnsTrue() {
        futureReservation.setStatus("MODIFIED");
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            futureReservation, futureStart.plusDays(2), futureEnd.plusDays(2), tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute(),
            "A MODIFIED reservation can be re-modified as long as it hasn't started");
    }
}

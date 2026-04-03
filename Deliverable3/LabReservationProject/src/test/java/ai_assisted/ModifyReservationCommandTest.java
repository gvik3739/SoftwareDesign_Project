package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.ModifyReservationCommand;
import data.MaintainReservation;
import model.*;
import util.SystemClock;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// AI-generated test file for ModifyReservationCommand class
public class ModifyReservationCommandTest {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private File tempCsv;
    private Reservation reservation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @BeforeEach
    public void setUp() throws Exception {
        tempCsv = File.createTempFile("modify_test", ".csv");
        tempCsv.deleteOnExit();
        Student student     = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        Equipment equipment = new Equipment("EQ001", "Microscope", "Lab A");
        // Use a future start time so canExecute() precondition (before start) passes
        startTime = SystemClock.getInstance().now().plusDays(5);
        endTime   = startTime.plusHours(2);
        reservation = new Reservation("R001", student, equipment, startTime, endTime, 10.0);
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv))) {
            pw.println("reservationId,userId,equipmentId,startTime,endTime,status,depositAmount,depositForfeited");
            pw.println("R001,123456789,EQ001," + startTime.format(FMT) + "," + endTime.format(FMT) + ",ACTIVE,10.00,false");
        }
    }

    @AfterEach
    public void tearDown() {
        if (tempCsv != null) tempCsv.delete();
    }

    @Test
    public void testCanExecute_futureReservation_noConflict_returnsTrue() {
        LocalDateTime newStart = startTime.plusDays(1);
        LocalDateTime newEnd   = newStart.plusHours(2);
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, newStart, newEnd, tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testGetErrorMessage_validModify_isEmpty() {
        LocalDateTime newStart = startTime.plusDays(1);
        LocalDateTime newEnd   = newStart.plusHours(2);
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, newStart, newEnd, tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertEquals("", cmd.getErrorMessage());
    }

    @Test
    public void testGetDescription_containsReservationId() {
        LocalDateTime newStart = startTime.plusDays(1);
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, newStart, newStart.plusHours(2), tempCsv.getAbsolutePath());
        assertTrue(cmd.getDescription().contains("R001"));
    }

    @Test
    public void testGetDescription_notEmpty() {
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, startTime.plusDays(1), endTime.plusDays(1), tempCsv.getAbsolutePath());
        assertFalse(cmd.getDescription().isEmpty());
    }

    @Test
    public void testExecute_updatesStartTimeInCsv() throws Exception {
        LocalDateTime newStart = startTime.plusDays(1);
        LocalDateTime newEnd   = newStart.plusHours(2);
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, newStart, newEnd, tempCsv.getAbsolutePath());
        cmd.execute();
        MaintainReservation mr = new MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals(newStart.truncatedTo(java.time.temporal.ChronoUnit.MINUTES),
            mr.reservations.get(0).getStartTime());
    }

    @Test
    public void testExecute_updatesEndTimeInCsv() throws Exception {
        LocalDateTime newStart = startTime.plusDays(1);
        LocalDateTime newEnd   = newStart.plusHours(3);
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, newStart, newEnd, tempCsv.getAbsolutePath());
        cmd.execute();
        MaintainReservation mr = new MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals(newEnd.truncatedTo(java.time.temporal.ChronoUnit.MINUTES),
            mr.reservations.get(0).getEndTime());
    }

    @Test
    public void testExecute_setsStatusToModified() throws Exception {
        LocalDateTime newStart = startTime.plusDays(1);
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, newStart, newStart.plusHours(2), tempCsv.getAbsolutePath());
        cmd.execute();
        MaintainReservation mr = new MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals("MODIFIED", mr.reservations.get(0).getStatus());
    }

    @Test
    public void testGetErrorMessage_afterCanExecute_noConflict_empty() {
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, startTime.plusDays(2), endTime.plusDays(2), tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertEquals("", cmd.getErrorMessage());
    }

    @Test
    public void testCanExecute_overlappingExistingSlot_returnsFalse() throws Exception {
        // Add a second reservation that overlaps the new desired slot
        LocalDateTime conflict = startTime.plusDays(1);
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv, true))) {
            pw.println("R002,987654321,EQ001," + conflict.format(FMT) + "," + conflict.plusHours(2).format(FMT) + ",ACTIVE,15.00,false");
        }
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, conflict, conflict.plusHours(1), tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute());
    }

    @Test
    public void testGetErrorMessage_overlap_notEmpty() throws Exception {
        LocalDateTime conflict = startTime.plusDays(1);
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv, true))) {
            pw.println("R002,987654321,EQ001," + conflict.format(FMT) + "," + conflict.plusHours(2).format(FMT) + ",ACTIVE,15.00,false");
        }
        ModifyReservationCommand cmd = new ModifyReservationCommand(
            reservation, conflict, conflict.plusHours(1), tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertFalse(cmd.getErrorMessage().isEmpty());
    }
}

package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.CancelReservationCommand;
import model.*;
import util.SystemClock;
import java.io.*;
import java.time.LocalDateTime;

/**
 * Tests for CancelReservationCommand.
 * Preconditions: (1) current time < reservation start time, (2) not already CANCELLED.
 * Real user data: James Carter (123456789), EQ001.
 */
public class CancelReservationCommandTest {

    private File tempCsv;
    private Student student;
    private Equipment microscope;

    @BeforeEach
    public void setUp() throws Exception {
        tempCsv  = File.createTempFile("reservations_cancel", ".csv");
        tempCsv.deleteOnExit();
        student   = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        microscope = new Equipment("EQ001", "Digital Microscope", "Lab A");
        // Write empty reservations CSV
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv))) {
            pw.println("reservationId,userId,equipmentId,startTime,endTime,status,depositAmount,depositForfeited");
        }
    }

    @AfterEach
    public void tearDown() {
        if (tempCsv != null) tempCsv.delete();
    }

    private Reservation futureReservation() {
        // Start time 1 year from now — safely in the future
        LocalDateTime start = SystemClock.getInstance().now().plusYears(1);
        LocalDateTime end   = start.plusHours(2);
        return new Reservation("R001", student, microscope, start, end, 10.0);
    }

    private Reservation pastReservation() {
        // Start time 1 year in the past — already started
        LocalDateTime start = SystemClock.getInstance().now().minusYears(1);
        LocalDateTime end   = start.plusHours(2);
        return new Reservation("R001", student, microscope, start, end, 10.0);
    }

    @Test
    public void testCanExecute_futureReservation_returnsTrue() {
        CancelReservationCommand cmd = new CancelReservationCommand(futureReservation(), tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute(),
            "Should be able to cancel a reservation that hasn't started yet");
    }

    @Test
    public void testCanExecute_pastReservation_returnsFalse() {
        CancelReservationCommand cmd = new CancelReservationCommand(pastReservation(), tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute(),
            "Cannot cancel a reservation that has already started");
    }

    @Test
    public void testCanExecute_alreadyCancelled_returnsFalse() {
        Reservation r = futureReservation();
        r.setStatus("CANCELLED");
        CancelReservationCommand cmd = new CancelReservationCommand(r, tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute(),
            "Cannot cancel a reservation that is already CANCELLED");
    }

    @Test
    public void testGetErrorMessage_pastReservation_containsErrorText() {
        CancelReservationCommand cmd = new CancelReservationCommand(pastReservation(), tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertFalse(cmd.getErrorMessage().isEmpty(),
            "Error message should be populated when canExecute() returns false");
    }

    @Test
    public void testGetErrorMessage_alreadyCancelled_containsError() {
        Reservation r = futureReservation();
        r.setStatus("CANCELLED");
        CancelReservationCommand cmd = new CancelReservationCommand(r, tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertFalse(cmd.getErrorMessage().isEmpty());
    }

    @Test
    public void testGetErrorMessage_validCommand_isEmpty() {
        CancelReservationCommand cmd = new CancelReservationCommand(futureReservation(), tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertEquals("", cmd.getErrorMessage());
    }

    @Test
    public void testGetDescription_containsReservationId() {
        Reservation r   = futureReservation();
        CancelReservationCommand cmd = new CancelReservationCommand(r, tempCsv.getAbsolutePath());
        assertTrue(cmd.getDescription().contains(r.getReservationId()),
            "Command description must mention the reservation ID");
    }

    @Test
    public void testExecute_futureReservation_statusBecomesCANCELLED() throws Exception {
        Reservation r = futureReservation();
        // Add the reservation to the CSV so execute() can find it
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv))) {
            pw.println("reservationId,userId,equipmentId,startTime,endTime,status,depositAmount,depositForfeited");
            pw.println(r.getReservationId() + "," + r.getUserId() + "," + r.getEquipmentId() + ","
                + r.getStartTime().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + ","
                + r.getEndTime().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                + ",ACTIVE,10.00,false");
        }
        CancelReservationCommand cmd = new CancelReservationCommand(r, tempCsv.getAbsolutePath());
        cmd.execute();

        // Reload and verify
        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals("CANCELLED", mr.reservations.get(0).getStatus());
    }

    @Test
    public void testCanExecute_activeStatus_returnsTrue() {
        Reservation r = futureReservation();
        r.setStatus("ACTIVE");
        CancelReservationCommand cmd = new CancelReservationCommand(r, tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testCanExecute_modifiedStatus_returnsTrue() {
        // A MODIFIED reservation can still be cancelled before it starts
        Reservation r = futureReservation();
        r.setStatus("MODIFIED");
        CancelReservationCommand cmd = new CancelReservationCommand(r, tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testGetDescription_notEmpty() {
        CancelReservationCommand cmd = new CancelReservationCommand(futureReservation(), tempCsv.getAbsolutePath());
        assertFalse(cmd.getDescription().isEmpty());
    }
}

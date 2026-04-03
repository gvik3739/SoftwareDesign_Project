package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.ExtendReservationCommand;
import model.*;
import util.SystemClock;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Tests for ExtendReservationCommand.
 * Preconditions: (1) new end time > current end time, (2) no overlap in extension window.
 * Real data: James Carter (123456789), EQ001.
 */
public class ExtendReservationCommandTest {

    private File tempCsv;
    private Student student;
    private Equipment microscope;
    private Reservation reservation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @BeforeEach
    public void setUp() throws Exception {
        tempCsv   = File.createTempFile("res_extend", ".csv");
        tempCsv.deleteOnExit();
        student   = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        microscope = new Equipment("EQ001", "Digital Microscope", "Lab A");
        startTime  = SystemClock.getInstance().now().plusDays(1);
        endTime    = startTime.plusHours(2);
        reservation = new Reservation("R001", student, microscope, startTime, endTime, 10.0);

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
    public void testCanExecute_laterEndTime_noConflict_returnsTrue() {
        LocalDateTime newEnd = endTime.plusHours(1);
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, newEnd, tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testCanExecute_earlierEndTime_returnsFalse() {
        // Cannot extend to an earlier time
        LocalDateTime earlierEnd = endTime.minusHours(1);
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, earlierEnd, tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute(),
            "New end time must be strictly after current end time");
    }

    @Test
    public void testCanExecute_sameEndTime_returnsFalse() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, endTime, tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute(),
            "New end time must be strictly after current end time, not equal");
    }

    @Test
    public void testGetErrorMessage_earlierEndTime_containsError() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, endTime.minusMinutes(30), tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertFalse(cmd.getErrorMessage().isEmpty());
    }

    @Test
    public void testGetErrorMessage_validExtension_isEmpty() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, endTime.plusHours(1), tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertEquals("", cmd.getErrorMessage());
    }

    @Test
    public void testGetDescription_containsReservationId() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, endTime.plusHours(1), tempCsv.getAbsolutePath());
        assertTrue(cmd.getDescription().contains("R001"));
    }

    @Test
    public void testGetDescription_containsNewEndTime() {
        LocalDateTime newEnd = endTime.plusHours(2);
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, newEnd, tempCsv.getAbsolutePath());
        assertTrue(cmd.getDescription().contains(newEnd.format(FMT)));
    }

    @Test
    public void testExecute_updatesEndTimeInCsv() throws Exception {
        LocalDateTime newEnd = endTime.plusHours(3);
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, newEnd, tempCsv.getAbsolutePath());
        cmd.execute();

        // CSV uses minute precision; truncate both sides before comparing
        LocalDateTime expected = newEnd.truncatedTo(java.time.temporal.ChronoUnit.MINUTES);
        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals(expected, mr.reservations.get(0).getEndTime(),
            "After execute(), end time should be updated to the new value");
    }

    @Test
    public void testCanExecute_overlappingReservationInExtensionWindow_returnsFalse() throws Exception {
        // Another reservation starts right after our current end
        LocalDateTime conflictStart = endTime.plusMinutes(30);
        LocalDateTime conflictEnd   = conflictStart.plusHours(1);
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv, true))) {
            pw.println("R002,987654321,EQ001," + conflictStart.format(FMT) + "," + conflictEnd.format(FMT) + ",ACTIVE,15.00,false");
        }
        // We want to extend to conflictEnd — which conflicts with R002
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, conflictEnd, tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute(),
            "Cannot extend if another reservation occupies the extension window");
    }

    @Test
    public void testCanExecute_extensionBy5Hours_noConflict_returnsTrue() {
        LocalDateTime bigExtend = endTime.plusHours(5);
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, bigExtend, tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testExecute_startTimeUnchanged() throws Exception {
        LocalDateTime newEnd = endTime.plusHours(1);
        ExtendReservationCommand cmd = new ExtendReservationCommand(reservation, newEnd, tempCsv.getAbsolutePath());
        cmd.execute();

        // CSV stores minute precision; compare at minute granularity
        LocalDateTime expectedStart = startTime.truncatedTo(java.time.temporal.ChronoUnit.MINUTES);
        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals(expectedStart, mr.reservations.get(0).getStartTime(),
            "Extending must not change the start time");
    }
}

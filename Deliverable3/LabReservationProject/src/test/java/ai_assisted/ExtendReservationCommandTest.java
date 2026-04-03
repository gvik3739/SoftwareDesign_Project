package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.ExtendReservationCommand;
import data.MaintainReservation;
import model.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// AI-generated test file for ExtendReservationCommand class
public class ExtendReservationCommandTest {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private File tempCsv;
    private Reservation reservation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @BeforeEach
    public void setUp() throws Exception {
        tempCsv = File.createTempFile("extend_test", ".csv");
        tempCsv.deleteOnExit();
        Student student     = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        Equipment equipment = new Equipment("EQ001", "Microscope", "Lab A");
        startTime = LocalDateTime.of(2027, 6, 1, 10, 0);
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
    public void testCanExecute_laterEndTime_returnsTrue() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, endTime.plusHours(1), tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testCanExecute_sameEndTime_returnsFalse() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, endTime, tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute());
    }

    @Test
    public void testCanExecute_earlierEndTime_returnsFalse() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, endTime.minusHours(1), tempCsv.getAbsolutePath());
        assertFalse(cmd.canExecute());
    }

    @Test
    public void testGetErrorMessage_invalidExtension_notEmpty() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, endTime.minusMinutes(30), tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertFalse(cmd.getErrorMessage().isEmpty());
    }

    @Test
    public void testGetErrorMessage_validExtension_isEmpty() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, endTime.plusHours(1), tempCsv.getAbsolutePath());
        cmd.canExecute();
        assertEquals("", cmd.getErrorMessage());
    }

    @Test
    public void testGetDescription_containsReservationId() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, endTime.plusHours(1), tempCsv.getAbsolutePath());
        assertTrue(cmd.getDescription().contains("R001"));
    }

    @Test
    public void testGetDescription_notEmpty() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, endTime.plusHours(1), tempCsv.getAbsolutePath());
        assertFalse(cmd.getDescription().isEmpty());
    }

    @Test
    public void testExecute_updatesEndTimeInCsv() throws Exception {
        LocalDateTime newEnd = endTime.plusHours(2);
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, newEnd, tempCsv.getAbsolutePath());
        cmd.execute();
        MaintainReservation mr = new MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals(newEnd.truncatedTo(java.time.temporal.ChronoUnit.MINUTES),
            mr.reservations.get(0).getEndTime());
    }

    @Test
    public void testExecute_startTimeUnchanged() throws Exception {
        LocalDateTime newEnd = endTime.plusHours(1);
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, newEnd, tempCsv.getAbsolutePath());
        cmd.execute();
        MaintainReservation mr = new MaintainReservation();
        mr.load(tempCsv.getAbsolutePath());
        assertEquals(startTime.truncatedTo(java.time.temporal.ChronoUnit.MINUTES),
            mr.reservations.get(0).getStartTime());
    }

    @Test
    public void testCanExecute_extensionBy5Hours_returnsTrue() {
        ExtendReservationCommand cmd = new ExtendReservationCommand(
            reservation, endTime.plusHours(5), tempCsv.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }
}

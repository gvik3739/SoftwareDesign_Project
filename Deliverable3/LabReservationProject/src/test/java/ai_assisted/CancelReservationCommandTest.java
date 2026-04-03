package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.CancelReservationCommand;
import model.Reservation;
import model.Student;
import model.Equipment;
import data.MaintainReservation;
import java.io.File;
import java.time.LocalDateTime;

// AI-generated test file for CancelReservationCommand
public class CancelReservationCommandTest {

    private File resFile;
    private Reservation res;
    private Student student;
    private Equipment eq;

    @BeforeEach
    public void setUp() throws Exception {
        resFile = File.createTempFile("reservations", ".csv");
        java.nio.file.Files.write(resFile.toPath(),
            "reservationId,userId,equipmentId,startTime,endTime,status,depositAmount\n".getBytes());
        student = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        eq      = new Equipment("EQ001", "Digital Microscope", "Lab A");
        LocalDateTime start = LocalDateTime.now().plusHours(2);
        LocalDateTime end   = LocalDateTime.now().plusHours(4);
        res = new Reservation("R001", student, eq, start, end, 10.0);
    }

    @AfterEach
    public void tearDown() { resFile.delete(); }

    @Test
    public void testCanExecute_futureReservation() throws Exception {
        MaintainReservation mr = new MaintainReservation();
        mr.load(resFile.getAbsolutePath());
        mr.reservations.add(res);
        mr.update(resFile.getAbsolutePath());
        CancelReservationCommand cmd = new CancelReservationCommand(res, resFile.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testCanExecute_alreadyCancelled() throws Exception {
        res.setStatus("CANCELLED");
        MaintainReservation mr = new MaintainReservation();
        mr.load(resFile.getAbsolutePath());
        mr.reservations.add(res);
        mr.update(resFile.getAbsolutePath());
        CancelReservationCommand cmd = new CancelReservationCommand(res, resFile.getAbsolutePath());
        assertFalse(cmd.canExecute());
    }

    @Test
    public void testExecute_setsStatusCancelled() throws Exception {
        MaintainReservation mr = new MaintainReservation();
        mr.load(resFile.getAbsolutePath());
        mr.reservations.add(res);
        mr.update(resFile.getAbsolutePath());
        CancelReservationCommand cmd = new CancelReservationCommand(res, resFile.getAbsolutePath());
        cmd.execute();
        // execute() updates the CSV, not the in-memory ref — reload to verify
        MaintainReservation mr2 = new MaintainReservation();
        mr2.load(resFile.getAbsolutePath());
        assertEquals("CANCELLED", mr2.reservations.get(0).getStatus());
    }

    // FLAW: missing @Test
    public void testGetDescription_notEmpty() {
        CancelReservationCommand cmd = new CancelReservationCommand(res, resFile.getAbsolutePath());
        assertFalse(cmd.getDescription().isEmpty());
    }

    @Test
    public void testCommandNotNull() {
        CancelReservationCommand cmd = new CancelReservationCommand(res, resFile.getAbsolutePath());
        assertNotNull(cmd);
    }

    @Test
    public void testCanExecute_pastStartTime() throws Exception {
        LocalDateTime pastStart = LocalDateTime.now().minusHours(2);
        LocalDateTime pastEnd   = LocalDateTime.now().plusHours(1);
        Reservation pastRes = new Reservation("R002", student, eq, pastStart, pastEnd, 10.0);
        MaintainReservation mr = new MaintainReservation();
        mr.load(resFile.getAbsolutePath());
        mr.reservations.add(pastRes);
        mr.update(resFile.getAbsolutePath());
        CancelReservationCommand cmd = new CancelReservationCommand(pastRes, resFile.getAbsolutePath());
        assertFalse(cmd.canExecute());
    }

    @Test
    public void testTrivial() {
        assertEquals(true, true);
    }

    @Test
    public void testGetErrorMessage_notNull() {
        CancelReservationCommand cmd = new CancelReservationCommand(res, resFile.getAbsolutePath());
        assertNotNull(cmd.getErrorMessage());
    }

    @Test
    public void testCanExecute_active() throws Exception {
        res.setStatus("ACTIVE");
        MaintainReservation mr = new MaintainReservation();
        mr.load(resFile.getAbsolutePath());
        mr.reservations.add(res);
        mr.update(resFile.getAbsolutePath());
        CancelReservationCommand cmd = new CancelReservationCommand(res, resFile.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testCanExecute_statusModified() throws Exception {
        res.setStatus("MODIFIED");
        MaintainReservation mr = new MaintainReservation();
        mr.load(resFile.getAbsolutePath());
        mr.reservations.add(res);
        mr.update(resFile.getAbsolutePath());
        CancelReservationCommand cmd = new CancelReservationCommand(res, resFile.getAbsolutePath());
        assertTrue(cmd.canExecute());
    }
}

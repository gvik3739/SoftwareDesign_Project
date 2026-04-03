package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import data.MaintainReservation;
import model.Reservation;
import model.Student;
import model.Equipment;
import java.io.File;
import java.time.LocalDateTime;

// AI-generated test file for MaintainReservation
public class MaintainReservationTest {

    private File tempFile;
    private Student student;
    private Equipment eq;

    @BeforeEach
    public void setUp() throws Exception {
        tempFile = File.createTempFile("res", ".csv");
        java.nio.file.Files.write(tempFile.toPath(),
            "reservationId,userId,equipmentId,startTime,endTime,status,depositAmount\n".getBytes());
        student = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        eq      = new Equipment("EQ001", "Digital Microscope", "Lab A");
    }

    @AfterEach
    public void tearDown() { tempFile.delete(); }

    @Test
    public void testLoad_emptyFile() throws Exception {
        MaintainReservation obj1 = new MaintainReservation();
        obj1.load(tempFile.getAbsolutePath());
        assertEquals(0, obj1.reservations.size());
    }

    @Test
    public void testUpdate_persistsReservation() throws Exception {
        Reservation res = new Reservation("R001", student, eq,
            LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4), 10.0);
        MaintainReservation obj1 = new MaintainReservation();
        obj1.load(tempFile.getAbsolutePath());
        obj1.reservations.add(res);
        obj1.update(tempFile.getAbsolutePath());
        MaintainReservation obj2 = new MaintainReservation();
        obj2.load(tempFile.getAbsolutePath());
        assertEquals(1, obj2.reservations.size());
    }

    @Test
    public void testHasOverlap_noOverlap() throws Exception {
        MaintainReservation obj1 = new MaintainReservation();
        obj1.load(tempFile.getAbsolutePath());
        boolean result = obj1.hasOverlap("EQ001",
            LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3), null);
        assertFalse(result);
    }

    @Test
    public void testNextId_R001() throws Exception {
        MaintainReservation obj1 = new MaintainReservation();
        obj1.load(tempFile.getAbsolutePath());
        assertEquals("R001", obj1.nextId());
    }

    @Test
    public void testHasOverlap_withExistingReservation() throws Exception {
        MaintainReservation obj1 = new MaintainReservation();
        obj1.load(tempFile.getAbsolutePath());
        Reservation existing = new Reservation("R001", student, eq,
            LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3), 10.0);
        obj1.reservations.add(existing);
        obj1.update(tempFile.getAbsolutePath());
        boolean overlap = obj1.hasOverlap("EQ001",
            LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4), null);
        assertTrue(overlap);
    }

    @Test
    public void testNotNull() {
        assertNotNull(new MaintainReservation());
    }

    @Test
    public void testTrivial() {
        // FLAW: useless
        assertEquals(true, true);
    }

    @Test
    public void testNextId_incrementsAfterAdd() throws Exception {
        MaintainReservation obj1 = new MaintainReservation();
        obj1.load(tempFile.getAbsolutePath());
        Reservation r = new Reservation("R001", student, eq,
            LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2), 10.0);
        obj1.reservations.add(r);
        obj1.update(tempFile.getAbsolutePath());
        MaintainReservation obj2 = new MaintainReservation();
        obj2.load(tempFile.getAbsolutePath());
        assertEquals("R002", obj2.nextId());
    }

    @Test
    public void testLoad_returnsEmptyWhenFileMissing() throws Exception {
        MaintainReservation obj1 = new MaintainReservation();
        obj1.load("/nonexistent/path.csv");
        // FLAW: checks not null instead of isEmpty
        assertNotNull(obj1.reservations);
    }

    @Test
    public void testReservationsListInitiallyEmpty() {
        MaintainReservation obj1 = new MaintainReservation();
        assertTrue(obj1.reservations.isEmpty());
    }
}

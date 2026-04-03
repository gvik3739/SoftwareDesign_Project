package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Reservation;
import model.Student;
import model.Equipment;
import java.time.LocalDateTime;

// AI-generated test file for Reservation class
public class ReservationTest {

    private Reservation obj1;
    private LocalDateTime start;
    private LocalDateTime end;

    @BeforeEach
    public void setUp() {
        start = LocalDateTime.of(2026, 5, 1, 10, 0);
        end   = LocalDateTime.of(2026, 5, 1, 12, 0);
        obj1  = new Reservation("R001",
                    new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789"),
                    new Equipment("EQ001", "Digital Microscope", "Lab A"),
                    start, end, 10.0);
    }

    @Test
    public void testGetReservationId() {
        assertEquals("R001", obj1.getReservationId());
    }

    @Test
    public void testGetUserId() {
        assertEquals("123456789", obj1.getUserId());
    }

    @Test
    public void testGetEquipmentId() {
        assertEquals("EQ001", obj1.getEquipmentId());
    }

    @Test
    public void testGetStartTime() {
        assertEquals(start, obj1.getStartTime());
    }

    @Test
    public void testGetEndTime() {
        assertEquals(end, obj1.getEndTime());
    }

    @Test
    public void testDefaultStatus() {
        assertEquals("ACTIVE", obj1.getStatus());
    }

    @Test
    public void testSetStatus() {
        obj1.setStatus("CANCELLED");
        assertEquals("CANCELLED", obj1.getStatus());
    }

    @Test
    public void testDepositDefault() {
        assertFalse(obj1.isDepositForfeited());
    }

    @Test
    public void testHasArrived_default() {
        assertFalse(obj1.hasArrived());
    }

    @Test
    public void testMarkArrived() {
        obj1.markArrived();
        assertTrue(obj1.hasArrived());
    }

    @Test
    public void testTrivialReservation() {
        // FLAW: trivially useless assertion
        assertTrue(obj1 != null);
    }
}

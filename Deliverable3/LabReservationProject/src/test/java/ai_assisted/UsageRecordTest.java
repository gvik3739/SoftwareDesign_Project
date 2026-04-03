package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.UsageRecord;
import java.time.LocalDateTime;

// AI-generated test file for UsageRecord class
// Note: AI assumed fields equippmentId/userId but actual class uses recordId/operationStatus
public class UsageRecordTest {

    private UsageRecord obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new UsageRecord("REC001",
                               LocalDateTime.of(2026, 5, 1, 10, 0),
                               LocalDateTime.of(2026, 5, 1, 12, 0),
                               "COMPLETED");
    }

    @Test
    public void testGetRecordId() {
        assertEquals("REC001", obj1.getRecordId());
    }

    @Test
    public void testGetStartTime() {
        assertEquals(LocalDateTime.of(2026, 5, 1, 10, 0), obj1.getStartTime());
    }

    @Test
    public void testGetEndTime() {
        assertEquals(LocalDateTime.of(2026, 5, 1, 12, 0), obj1.getEndTime());
    }

    @Test
    public void testGetDurationMinutes() {
        assertEquals(120, obj1.getDurationMinutes());
    }

    @Test
    public void testGetOperationStatus() {
        assertEquals("COMPLETED", obj1.getOperationStatus());
    }

    @Test
    public void testGetDurationMinutes_zeroIfSameTime() {
        UsageRecord ur = new UsageRecord("REC002",
                                         LocalDateTime.of(2026, 5, 1, 10, 0),
                                         LocalDateTime.of(2026, 5, 1, 10, 0),
                                         "CANCELLED");
        assertEquals(0, ur.getDurationMinutes());
    }

    @Test
    public void testUsageRecordNotNull() {
        assertNotNull(obj1);
    }

    @Test
    public void testDurationIsPositive() {
        assertTrue(obj1.getDurationMinutes() > 0);
    }

    @Test
    public void testTrivial() {
        // FLAW: useless
        assertEquals(true, true);
    }

    @Test
    public void testRecordIdNotNull() {
        assertNotNull(obj1.getRecordId());
    }

    @Test
    public void testStartBeforeEnd() {
        assertTrue(obj1.getStartTime().isBefore(obj1.getEndTime()));
    }
}

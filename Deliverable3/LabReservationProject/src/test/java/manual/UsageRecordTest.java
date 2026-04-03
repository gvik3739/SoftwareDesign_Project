package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.UsageRecord;
import java.time.LocalDateTime;

/**
 * Tests for UsageRecord — records how long equipment was actually used.
 */
public class UsageRecordTest {

    private UsageRecord record;
    private LocalDateTime start;
    private LocalDateTime end;

    @BeforeEach
    public void setUp() {
        start  = LocalDateTime.of(2026, 4, 1, 9, 0);
        end    = LocalDateTime.of(2026, 4, 1, 11, 30); // 150 minutes
        record = new UsageRecord("UR001", start, end, "SUCCESS");
    }

    @Test
    public void testGetRecordId_ur001_returnsId() {
        assertEquals("UR001", record.getRecordId());
    }

    @Test
    public void testGetStartTime_nineAm_returnsStartTime() {
        assertEquals(start, record.getStartTime());
    }

    @Test
    public void testGetEndTime_elevenThirty_returnsEndTime() {
        assertEquals(end, record.getEndTime());
    }

    @Test
    public void testGetDurationMinutes_150Minutes_calculatedCorrectly() {
        // Duration is automatically calculated from start/end in the constructor
        assertEquals(150, record.getDurationMinutes());
    }

    @Test
    public void testGetOperationStatus_success_returnsSuccess() {
        assertEquals("SUCCESS", record.getOperationStatus());
    }

    @Test
    public void testGetDurationMinutes_oneHour_returns60() {
        LocalDateTime s = LocalDateTime.of(2026, 4, 1, 10, 0);
        LocalDateTime e = LocalDateTime.of(2026, 4, 1, 11, 0);
        UsageRecord r   = new UsageRecord("UR002", s, e, "SUCCESS");
        assertEquals(60, r.getDurationMinutes());
    }

    @Test
    public void testGetDurationMinutes_30Minutes_returns30() {
        LocalDateTime s = LocalDateTime.of(2026, 4, 1, 14, 15);
        LocalDateTime e = LocalDateTime.of(2026, 4, 1, 14, 45);
        UsageRecord r   = new UsageRecord("UR003", s, e, "SUCCESS");
        assertEquals(30, r.getDurationMinutes());
    }

    @Test
    public void testGetOperationStatus_failure_returnsFailure() {
        UsageRecord failed = new UsageRecord("UR099", start, end, "FAILURE");
        assertEquals("FAILURE", failed.getOperationStatus());
    }

    @Test
    public void testGetDurationMinutes_sameDaySessionCrossesNoon() {
        LocalDateTime s = LocalDateTime.of(2026, 4, 1, 11, 0);
        LocalDateTime e = LocalDateTime.of(2026, 4, 1, 13, 0);
        UsageRecord r   = new UsageRecord("UR004", s, e, "SUCCESS");
        assertEquals(120, r.getDurationMinutes());
    }

    @Test
    public void testGetDurationMinutes_minimumUsage_1minute() {
        LocalDateTime s = LocalDateTime.of(2026, 4, 1, 9, 0);
        LocalDateTime e = LocalDateTime.of(2026, 4, 1, 9, 1);
        UsageRecord r   = new UsageRecord("UR005", s, e, "SUCCESS");
        assertEquals(1, r.getDurationMinutes());
    }

    @Test
    public void testGetRecordId_differentIds_independentRecords() {
        UsageRecord r2 = new UsageRecord("UR002", start, end, "SUCCESS");
        assertNotEquals(record.getRecordId(), r2.getRecordId());
    }

    @Test
    public void testUsageRecord_consecutiveSessions_independentDurations() {
        UsageRecord session1 = new UsageRecord("UR010", 
            LocalDateTime.of(2026, 4, 1, 9, 0),
            LocalDateTime.of(2026, 4, 1, 10, 0), "SUCCESS");
        UsageRecord session2 = new UsageRecord("UR011", 
            LocalDateTime.of(2026, 4, 1, 11, 0),
            LocalDateTime.of(2026, 4, 1, 13, 0), "SUCCESS");
        assertEquals(60,  session1.getDurationMinutes());
        assertEquals(120, session2.getDurationMinutes());
    }
}

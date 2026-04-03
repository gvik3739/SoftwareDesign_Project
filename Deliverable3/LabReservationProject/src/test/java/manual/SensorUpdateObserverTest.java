package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.SensorUpdateObserver;
import model.Equipment;
import model.UsageRecord;
import java.time.LocalDateTime;

/**
 * Tests for SensorUpdateObserver — prints equipment status and usage events.
 * Primarily tests that the observer handles both event types without errors.
 */
public class SensorUpdateObserverTest {

    private SensorUpdateObserver observer;
    private Equipment microscope;

    @BeforeEach
    public void setUp() {
        observer  = new SensorUpdateObserver();
        microscope = new Equipment("EQ001", "Digital Microscope", "Lab A");
    }

    @Test
    public void testUpdate_equipmentObject_doesNotThrow() {
        assertDoesNotThrow(() -> observer.update(microscope));
    }

    @Test
    public void testUpdate_usageRecord_doesNotThrow() {
        UsageRecord record = new UsageRecord("UR001",
            LocalDateTime.of(2026, 4, 1, 9, 0),
            LocalDateTime.of(2026, 4, 1, 10, 0),
            "SUCCESS");
        assertDoesNotThrow(() -> observer.update(record));
    }

    @Test
    public void testUpdate_nullEvent_doesNotThrow() {
        assertDoesNotThrow(() -> observer.update(null));
    }

    @Test
    public void testUpdate_stringEvent_doesNotThrow() {
        // Unexpected event types should be silently ignored
        assertDoesNotThrow(() -> observer.update("UNEXPECTED_EVENT"));
    }

    @Test
    public void testUpdate_integerEvent_doesNotThrow() {
        assertDoesNotThrow(() -> observer.update(42));
    }

    @Test
    public void testUpdate_equipmentWithAvailableStatus_noException() {
        microscope.setStatus("AVAILABLE");
        assertDoesNotThrow(() -> observer.update(microscope));
    }

    @Test
    public void testUpdate_equipmentWithMaintenanceStatus_noException() {
        microscope.setStatus("MAINTENANCE");
        assertDoesNotThrow(() -> observer.update(microscope));
    }

    @Test
    public void testUpdate_usageRecordWithFailure_noException() {
        UsageRecord record = new UsageRecord("UR002",
            LocalDateTime.of(2026, 4, 1, 14, 0),
            LocalDateTime.of(2026, 4, 1, 14, 30),
            "FAILURE");
        assertDoesNotThrow(() -> observer.update(record));
    }

    @Test
    public void testUpdate_calledMultipleTimes_noException() {
        // Observer should handle repeated calls without issue
        for (int i = 0; i < 5; i++) {
            assertDoesNotThrow(() -> observer.update(microscope));
        }
    }

    @Test
    public void testUpdate_differentEquipmentObjects_noException() {
        Equipment eq2 = new Equipment("EQ002", "Centrifuge", "Lab A");
        Equipment eq3 = new Equipment("EQ003", "PCR Machine", "Lab B");
        assertDoesNotThrow(() -> observer.update(eq2));
        assertDoesNotThrow(() -> observer.update(eq3));
    }

    @Test
    public void testImplementsObserver_isObserver() {
        assertTrue(observer instanceof util.Observer);
    }
}

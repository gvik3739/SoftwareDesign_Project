package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.SensorUpdateObserver;
import model.Equipment;
import model.UsageRecord;

// AI-generated test file for SensorUpdateObserver class
public class SensorUpdateObserverTest {

    private SensorUpdateObserver observer;
    private Equipment equipment;

    @BeforeEach
    public void setUp() {
        observer  = new SensorUpdateObserver();
        equipment = new Equipment("EQ060", "Flow Meter", "Lab F");
    }

    @Test
    public void testUpdate_equipmentEvent_noException() {
        assertDoesNotThrow(() -> observer.update(equipment));
    }

    @Test
    public void testUpdate_usageRecordEvent_noException() {
        UsageRecord record = new UsageRecord("UR010", "R010", "EQ060", 90, "completed");
        assertDoesNotThrow(() -> observer.update(record));
    }

    @Test
    public void testUpdate_unrecognizedEventType_noException() {
        assertDoesNotThrow(() -> observer.update("unrecognized string event"));
    }

    @Test
    public void testUpdate_nullEvent_noException() {
        assertDoesNotThrow(() -> observer.update(null));
    }

    @Test
    public void testUpdate_equipmentWithStatus_noException() {
        equipment.setStatus("UNDER_REPAIR");
        assertDoesNotThrow(() -> observer.update(equipment));
    }

    @Test
    public void testUpdate_multipleEquipmentEvents_noException() {
        Equipment eq2 = new Equipment("EQ061", "Pump", "Lab F");
        assertDoesNotThrow(() -> {
            observer.update(equipment);
            observer.update(eq2);
        });
    }

    @Test
    public void testUpdate_usageRecord_correctDuration_noException() {
        UsageRecord record = new UsageRecord("UR011", "R011", "EQ060", 30, "in-progress");
        assertDoesNotThrow(() -> observer.update(record));
    }

    @Test
    public void testUpdate_integerEvent_noException() {
        assertDoesNotThrow(() -> observer.update(42));
    }

    @Test
    public void testInstantiation_notNull() {
        assertNotNull(observer);
    }

    @Test
    public void testUpdate_equipmentAfterDisable_noException() {
        equipment.disable();
        assertDoesNotThrow(() -> observer.update(equipment));
    }
}

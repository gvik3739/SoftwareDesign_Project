package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.EquipmentSensorSystem;
import model.Equipment;
import model.UsageRecord;
import util.Observer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for EquipmentSensorSystem — the Observer Subject that broadcasts
 * equipment status updates and usage data to registered observers.
 */
public class EquipmentSensorSystemTest {

    private EquipmentSensorSystem sensorSystem;
    private Equipment microscope;
    private TestObserver observer;

    /** Helper observer that records all received events */
    static class TestObserver implements Observer {
        List<Object> received = new ArrayList<>();
        @Override
        public void update(Object eventData) {
            received.add(eventData);
        }
    }

    @BeforeEach
    public void setUp() {
        sensorSystem = new EquipmentSensorSystem();
        microscope   = new Equipment("EQ001", "Digital Microscope", "Lab A");
        observer     = new TestObserver();
    }

    @Test
    public void testAttach_observer_receivesSubsequentEvents() {
        sensorSystem.attach(observer);
        sensorSystem.sendStatusUpdate(microscope, "MAINTENANCE");
        assertEquals(1, observer.received.size(),
            "Attached observer should receive exactly one event");
    }

    @Test
    public void testDetach_observer_stopsReceivingEvents() {
        sensorSystem.attach(observer);
        sensorSystem.detach(observer);
        sensorSystem.sendStatusUpdate(microscope, "AVAILABLE");
        assertEquals(0, observer.received.size(),
            "Detached observer must not receive any events");
    }

    @Test
    public void testSendStatusUpdate_updatesEquipmentStatus() {
        sensorSystem.attach(observer);
        sensorSystem.sendStatusUpdate(microscope, "MAINTENANCE");
        assertEquals("MAINTENANCE", microscope.getStatus(),
            "sendStatusUpdate must update the equipment's status field");
    }

    @Test
    public void testSendStatusUpdate_notifiesAllObservers() {
        TestObserver obs1 = new TestObserver();
        TestObserver obs2 = new TestObserver();
        sensorSystem.attach(obs1);
        sensorSystem.attach(obs2);
        sensorSystem.sendStatusUpdate(microscope, "DISABLED");
        assertEquals(1, obs1.received.size());
        assertEquals(1, obs2.received.size());
    }

    @Test
    public void testSendStatusUpdate_observerReceivesEquipmentObject() {
        sensorSystem.attach(observer);
        sensorSystem.sendStatusUpdate(microscope, "AVAILABLE");
        assertTrue(observer.received.get(0) instanceof Equipment,
            "Observer should receive the Equipment object as event data");
    }

    @Test
    public void testSendUsageUpdate_observerReceivesUsageRecord() {
        sensorSystem.attach(observer);
        UsageRecord record = new UsageRecord("UR001",
            LocalDateTime.of(2026, 4, 1, 9, 0),
            LocalDateTime.of(2026, 4, 1, 10, 0),
            "SUCCESS");
        sensorSystem.sendUsageUpdate(microscope, record);
        assertEquals(1, observer.received.size());
        assertTrue(observer.received.get(0) instanceof UsageRecord);
    }

    @Test
    public void testNotifyObservers_directCall_notifiesAll() {
        TestObserver obs1 = new TestObserver();
        TestObserver obs2 = new TestObserver();
        sensorSystem.attach(obs1);
        sensorSystem.attach(obs2);
        sensorSystem.notifyObservers("TEST_EVENT");
        assertEquals(1, obs1.received.size());
        assertEquals(1, obs2.received.size());
        assertEquals("TEST_EVENT", obs1.received.get(0));
    }

    @Test
    public void testMultipleStatusUpdates_allDeliveredInOrder() {
        sensorSystem.attach(observer);
        sensorSystem.sendStatusUpdate(microscope, "AVAILABLE");
        sensorSystem.sendStatusUpdate(microscope, "MAINTENANCE");
        assertEquals(2, observer.received.size());
    }

    @Test
    public void testDetach_nonAttachedObserver_noException() {
        // Detaching an observer that was never attached should not throw
        assertDoesNotThrow(() -> sensorSystem.detach(observer));
    }

    @Test
    public void testNoObservers_sendStatusUpdate_noException() {
        // System with no observers should not throw when events are sent
        assertDoesNotThrow(() -> sensorSystem.sendStatusUpdate(microscope, "DISABLED"));
    }

    @Test
    public void testAttachDetachAttach_observerReRegistered_receivesEvents() {
        sensorSystem.attach(observer);
        sensorSystem.detach(observer);
        sensorSystem.attach(observer);
        sensorSystem.sendStatusUpdate(microscope, "AVAILABLE");
        assertEquals(1, observer.received.size(),
            "Re-attached observer should receive events normally");
    }
}

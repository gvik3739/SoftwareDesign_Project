package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Equipment;
import model.EquipmentSensorSystem;
import model.UsageRecord;
import util.Observer;
import java.util.ArrayList;
import java.util.List;

// AI-generated test file for EquipmentSensorSystem class
public class EquipmentSensorSystemTest {

    private EquipmentSensorSystem system;
    private Equipment equipment;

    /** Simple observer that records how many times it was called and what data it got */
    static class TestObserver implements Observer {
        List<Object> received = new ArrayList<>();
        @Override
        public void update(Object eventData) { received.add(eventData); }
    }

    @BeforeEach
    public void setUp() {
        system    = new EquipmentSensorSystem();
        equipment = new Equipment("EQ050", "3D Printer", "Lab E");
    }

    @Test
    public void testAttach_observerReceivesUpdate() {
        TestObserver obs = new TestObserver();
        system.attach(obs);
        system.notifyObservers("test-event");
        assertEquals(1, obs.received.size());
    }

    @Test
    public void testDetach_observerNoLongerReceivesUpdate() {
        TestObserver obs = new TestObserver();
        system.attach(obs);
        system.detach(obs);
        system.notifyObservers("test-event");
        assertEquals(0, obs.received.size());
    }

    @Test
    public void testNotifyObservers_multipleObservers_allNotified() {
        TestObserver obs1 = new TestObserver();
        TestObserver obs2 = new TestObserver();
        system.attach(obs1);
        system.attach(obs2);
        system.notifyObservers("ping");
        assertEquals(1, obs1.received.size());
        assertEquals(1, obs2.received.size());
    }

    @Test
    public void testSendStatusUpdate_changesEquipmentStatus() {
        system.sendStatusUpdate(equipment, "UNDER_REPAIR");
        assertEquals("UNDER_REPAIR", equipment.getStatus());
    }

    @Test
    public void testSendStatusUpdate_notifiesAttachedObserver() {
        TestObserver obs = new TestObserver();
        system.attach(obs);
        system.sendStatusUpdate(equipment, "AVAILABLE");
        assertEquals(1, obs.received.size());
    }

    @Test
    public void testSendStatusUpdate_observerReceivesEquipment() {
        TestObserver obs = new TestObserver();
        system.attach(obs);
        system.sendStatusUpdate(equipment, "DISABLED");
        assertTrue(obs.received.get(0) instanceof Equipment);
    }

    @Test
    public void testSendUsageUpdate_notifiesAttachedObserver() {
        TestObserver obs = new TestObserver();
        system.attach(obs);
        UsageRecord record = new UsageRecord("UR001", "R001", "EQ050", 60, "completed");
        system.sendUsageUpdate(equipment, record);
        assertEquals(1, obs.received.size());
    }

    @Test
    public void testSendUsageUpdate_observerReceivesUsageRecord() {
        TestObserver obs = new TestObserver();
        system.attach(obs);
        UsageRecord record = new UsageRecord("UR002", "R002", "EQ050", 45, "completed");
        system.sendUsageUpdate(equipment, record);
        assertTrue(obs.received.get(0) instanceof UsageRecord);
    }

    @Test
    public void testNotifyObservers_noObservers_noException() {
        assertDoesNotThrow(() -> system.notifyObservers("safe"));
    }

    @Test
    public void testAttachDetachAttach_observerReceivesUpdateAfterReattach() {
        TestObserver obs = new TestObserver();
        system.attach(obs);
        system.detach(obs);
        system.attach(obs);
        system.notifyObservers("reattach");
        assertEquals(1, obs.received.size());
    }
}

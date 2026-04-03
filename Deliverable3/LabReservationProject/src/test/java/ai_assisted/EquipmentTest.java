package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Equipment;

// AI-generated test file for Equipment class
public class EquipmentTest {

    private Equipment obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new Equipment("EQ001", "Digital Microscope", "Lab A");
    }

    @Test
    public void testGetEquipmentId() {
        assertEquals("EQ001", obj1.getEquipmentId());
    }

    @Test
    public void testGetName() {
        assertEquals("Digital Microscope", obj1.getName());
    }

    @Test
    public void testGetLabLocation() {
        assertEquals("Lab A", obj1.getLabLocation());
    }

    @Test
    public void testCanReserve_defaultTrue() {
        assertTrue(obj1.canReserve());
    }

    @Test
    public void testDisable_canReserveFalse() {
        obj1.disable();
        assertFalse(obj1.canReserve());
    }

    @Test
    public void testEnable_afterDisable() {
        obj1.disable();
        obj1.enable();
        assertTrue(obj1.canReserve());
    }

    @Test
    public void testMarkMaintenance_canReserveFalse() {
        obj1.markUnderMaintenance();
        assertFalse(obj1.canReserve());
    }

    @Test
    public void testGetCurrentStateName_available() {
        assertEquals("Available", obj1.getCurrentStateName());
    }

    @Test
    public void testDefaultStateName() {
        assertEquals("Available", obj1.getCurrentStateName());
    }

    @Test
    public void testSetStatus() {
        obj1.disable();
        assertFalse(obj1.canReserve());
    }

    @Test
    public void testEquipmentNotNull() {
        assertNotNull(obj1);
    }
}

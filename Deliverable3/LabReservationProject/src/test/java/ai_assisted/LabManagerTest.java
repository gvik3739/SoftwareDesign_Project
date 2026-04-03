package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.LabManager;
import model.Equipment;

// AI-generated test file for LabManager class
public class LabManagerTest {

    private LabManager obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new LabManager("Arjun Patel", "apatel@yorku.ca", "Manager@123", "LM001");
    }

    @Test
    public void testGetUserType() {
        assertEquals("LabManager", obj1.getUserType());
    }

    @Test
    public void testGetHourlyRate() {
        assertEquals(0.0, obj1.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetName() {
        assertEquals("Arjun Patel", obj1.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("apatel@yorku.ca", obj1.getEmail());
    }

    @Test
    public void testGetManagerId() {
        assertEquals("LM001", obj1.getManagerId());
    }

    @Test
    public void testGetIdNumber_returnsManagerId() {
        assertEquals("LM001", obj1.getIdNumber());
    }

    @Test
    public void testAddEquipment() {
        Equipment eq = obj1.addEquipment("EQ010", "Test Device", "Lab Z");
        // OK — using actual API signature
        assertNotNull(eq);
    }

    @Test
    public void testEnableEquipment() {
        Equipment eq = new Equipment("EQ011", "Device", "Lab X");
        eq.disable();
        obj1.enableEquipment(eq);
        assertTrue(eq.canReserve());
    }

    @Test
    public void testDisableEquipment() {
        Equipment eq = new Equipment("EQ012", "Device", "Lab X");
        obj1.disableEquipment(eq);
        assertFalse(eq.canReserve());
    }

    @Test
    public void testMarkUnderMaintenance() {
        Equipment eq = new Equipment("EQ013", "Device", "Lab X");
        obj1.markEquipmentUnderMaintenance(eq);
        assertFalse(eq.canReserve());
    }

    @Test
    public void testTrivial() {
        // FLAW: useless
        assertNotNull(obj1.getUserType());
    }
}

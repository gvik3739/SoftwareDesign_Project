package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import data.MaintainEquipment;
import model.Equipment;
import java.util.List;

// AI-generated test file for MaintainEquipment
public class MaintainEquipmentTest {

    @Test
    public void testLoad_equipmentFile() throws Exception {
        MaintainEquipment obj1 = new MaintainEquipment();
        obj1.load("data/equipment.csv");
        assertNotNull(obj1.equipmentList);
    }

    @Test
    public void testLoad_sixItems() throws Exception {
        MaintainEquipment obj1 = new MaintainEquipment();
        obj1.load("data/equipment.csv");
        assertEquals(6, obj1.equipmentList.size());
    }

    @Test
    public void testGetAvailableEquipment_countFour() throws Exception {
        MaintainEquipment obj1 = new MaintainEquipment();
        obj1.load("data/equipment.csv");
        List<Equipment> available = obj1.getAvailableEquipment();
        assertEquals(4, available.size());
    }

    @Test
    public void testFindById_EQ001() throws Exception {
        MaintainEquipment obj1 = new MaintainEquipment();
        obj1.load("data/equipment.csv");
        Equipment result = obj1.findById("EQ001");
        assertNotNull(result);
    }

    @Test
    public void testFindById_notFound() throws Exception {
        MaintainEquipment obj1 = new MaintainEquipment();
        obj1.load("data/equipment.csv");
        assertNull(obj1.findById("EQ999"));
    }

    @Test
    public void testEQ005_isDisabled() throws Exception {
        MaintainEquipment obj1 = new MaintainEquipment();
        obj1.load("data/equipment.csv");
        Equipment eq = obj1.findById("EQ005");
        assertFalse(eq.canReserve());
    }

    @Test
    public void testEQ006_isMaintenance() throws Exception {
        MaintainEquipment obj1 = new MaintainEquipment();
        obj1.load("data/equipment.csv");
        Equipment eq = obj1.findById("EQ006");
        assertFalse(eq.canReserve());
    }

    // FLAW: missing @Test
    public void testMaintainEquipmentNotNull() {
        assertNotNull(new MaintainEquipment());
    }

    @Test
    public void testEquipmentListInitiallyEmpty() {
        MaintainEquipment obj1 = new MaintainEquipment();
        // FLAW: doesn't load — checks empty list is not null
        assertNotNull(obj1.equipmentList);
    }

    @Test
    public void testTrivial() {
        // FLAW: useless
        assertTrue(true);
    }

    @Test
    public void testFindById_EQ001_hasCorrectName() throws Exception {
        MaintainEquipment obj1 = new MaintainEquipment();
        obj1.load("data/equipment.csv");
        Equipment result = obj1.findById("EQ001");
        assertEquals("Digital Microscope", result.getName());
    }
}

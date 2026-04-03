package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.LabManager;
import model.Equipment;

/**
 * Tests for the LabManager user model.
 * Lab managers administer equipment — they do not make reservations.
 * Real data from users.csv: Arjun Patel, apatel@yorku.ca, LM001
 */
public class LabManagerTest {

    private LabManager manager;
    private Equipment equipment;

    @BeforeEach
    public void setUp() {
        manager   = new LabManager("Arjun Patel", "apatel@yorku.ca", "Manager@123", "LM001");
        equipment = new Equipment("EQ001", "Digital Microscope", "Lab A");
    }

    @Test
    public void testGetUserType_labManager_returnsLabManagerString() {
        assertEquals("LabManager", manager.getUserType());
    }

    @Test
    public void testGetHourlyRate_labManager_returnsZero() {
        // Lab managers do not pay to use equipment — they manage it
        assertEquals(0.0, manager.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetManagerId_lm001_returnsManagerId() {
        assertEquals("LM001", manager.getManagerId());
    }

    @Test
    public void testGetName_arjunPatel_returnsFullName() {
        assertEquals("Arjun Patel", manager.getName());
    }

    @Test
    public void testGetEmail_apatel_returnsYorkEmail() {
        assertEquals("apatel@yorku.ca", manager.getEmail());
    }

    @Test
    public void testGetIdNumber_lm001_returnsSameAsManagerId() {
        // For LabManager, idNumber == managerId by construction
        assertEquals(manager.getManagerId(), manager.getIdNumber());
    }

    @Test
    public void testAddEquipment_validParams_returnsAvailableEquipment() {
        // Lab managers can register new equipment in the system
        Equipment eq = manager.addEquipment("EQ007", "Gas Chromatograph", "Lab D");
        assertNotNull(eq);
        assertEquals("EQ007", eq.getEquipmentId());
        assertEquals("Gas Chromatograph", eq.getDescription());
        assertEquals("Lab D", eq.getLabLocation());
        assertTrue(eq.canReserve(), "Newly added equipment should be AVAILABLE by default");
    }

    @Test
    public void testDisableEquipment_availableEquipment_becomesDisabled() {
        // Disabling removes the equipment from reservation availability
        assertTrue(equipment.canReserve(), "Equipment should start as AVAILABLE");
        manager.disableEquipment(equipment);
        assertFalse(equipment.canReserve(),
            "Equipment must not be reservable after lab manager disables it");
    }

    @Test
    public void testEnableEquipment_disabledEquipment_becomesAvailable() {
        // Re-enabling should restore full reservation capability
        manager.disableEquipment(equipment);
        assertFalse(equipment.canReserve());
        manager.enableEquipment(equipment);
        assertTrue(equipment.canReserve(),
            "Equipment should be reservable again after lab manager enables it");
    }

    @Test
    public void testMarkEquipmentUnderMaintenance_availableEquipment_blockReservations() {
        // Maintenance mode prevents reservations just like disabled mode
        manager.markEquipmentUnderMaintenance(equipment);
        assertFalse(equipment.canReserve(),
            "Equipment under maintenance must not accept new reservations");
        assertEquals("Maintenance", equipment.getCurrentStateName());
    }

    @Test
    public void testEnableEquipment_maintenanceEquipment_becomesAvailable() {
        // Completing maintenance restores availability
        manager.markEquipmentUnderMaintenance(equipment);
        manager.enableEquipment(equipment);
        assertTrue(equipment.canReserve());
        assertEquals("Available", equipment.getCurrentStateName());
    }

    @Test
    public void testGetPassword_manager_returnsStoredPassword() {
        assertEquals("Manager@123", manager.getPassword());
    }
}

package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Equipment;
import model.AvailableState;
import model.DisabledState;
import model.MaintenanceState;

// AI-generated test file for MaintenanceState class
public class MaintenanceStateTest {

    private Equipment equipment;
    private MaintenanceState state;

    @BeforeEach
    public void setUp() {
        equipment = new Equipment("EQ030", "Laser Cutter", "Lab D");
        state = new MaintenanceState();
        equipment.setState(state);
    }

    @Test
    public void testIsAvailable_returnsFalse() {
        assertFalse(state.isAvailable());
    }

    @Test
    public void testGetStateName_returnsMaintenance() {
        assertEquals("Maintenance", state.getStateName());
    }

    @Test
    public void testCanReserve_underMaintenance_returnsFalse() {
        assertFalse(equipment.canReserve());
    }

    @Test
    public void testEnable_transitionsToAvailableState() {
        state.enable(equipment);
        assertTrue(equipment.getState() instanceof AvailableState);
    }

    @Test
    public void testEnable_equipmentCanReserveAfterEnable() {
        state.enable(equipment);
        assertTrue(equipment.canReserve());
    }

    @Test
    public void testDisable_underMaintenance_staysInMaintenanceState() {
        // Disabling during maintenance is a no-op — stays in Maintenance
        state.disable(equipment);
        assertTrue(equipment.getState() instanceof MaintenanceState);
    }

    @Test
    public void testMarkUnderMaintenance_alreadyInMaintenance_noStateChange() {
        state.markUnderMaintenance(equipment);
        assertTrue(equipment.getState() instanceof MaintenanceState);
    }

    @Test
    public void testGetStateName_notAvailable() {
        assertNotEquals("Available", state.getStateName());
    }

    @Test
    public void testGetStateName_notDisabled() {
        assertNotEquals("Disabled", state.getStateName());
    }

    @Test
    public void testMaintenanceToAvailableToDisabled_correctSequence() {
        state.enable(equipment);
        assertEquals("Available", equipment.getCurrentStateName());
        equipment.disable();
        assertEquals("Disabled", equipment.getCurrentStateName());
    }

    @Test
    public void testCurrentStateName_maintenance() {
        assertEquals("Maintenance", equipment.getCurrentStateName());
    }
}

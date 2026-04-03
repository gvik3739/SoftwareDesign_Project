package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Equipment;
import model.AvailableState;
import model.DisabledState;
import model.MaintenanceState;

// AI-generated test file for DisabledState class
public class DisabledStateTest {

    private Equipment equipment;
    private DisabledState state;

    @BeforeEach
    public void setUp() {
        equipment = new Equipment("EQ020", "Oscilloscope", "Lab C");
        state = new DisabledState();
        equipment.setState(state);
    }

    @Test
    public void testIsAvailable_returnsFalse() {
        assertFalse(state.isAvailable());
    }

    @Test
    public void testGetStateName_returnsDisabled() {
        assertEquals("Disabled", state.getStateName());
    }

    @Test
    public void testCanReserve_disabledEquipment_returnsFalse() {
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
    public void testDisable_alreadyDisabled_staysDisabled() {
        state.disable(equipment);
        assertTrue(equipment.getState() instanceof DisabledState);
        assertFalse(equipment.canReserve());
    }

    @Test
    public void testMarkUnderMaintenance_transitionsToMaintenanceState() {
        state.markUnderMaintenance(equipment);
        assertTrue(equipment.getState() instanceof MaintenanceState);
    }

    @Test
    public void testMarkUnderMaintenance_equipmentStillNotAvailable() {
        state.markUnderMaintenance(equipment);
        assertFalse(equipment.canReserve());
    }

    @Test
    public void testGetStateName_notAvailable() {
        assertNotEquals("Available", state.getStateName());
    }

    @Test
    public void testGetStateName_notMaintenance() {
        assertNotEquals("Maintenance", state.getStateName());
    }

    @Test
    public void testEnableThenDisable_cyclesCorrectly() {
        state.enable(equipment);
        equipment.disable();
        assertFalse(equipment.canReserve());
        assertEquals("Disabled", equipment.getCurrentStateName());
    }
}

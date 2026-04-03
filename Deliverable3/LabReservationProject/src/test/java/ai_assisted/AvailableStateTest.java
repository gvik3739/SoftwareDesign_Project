package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Equipment;
import model.AvailableState;
import model.DisabledState;
import model.MaintenanceState;

// AI-generated test file for AvailableState class
public class AvailableStateTest {

    private Equipment equipment;
    private AvailableState state;

    @BeforeEach
    public void setUp() {
        equipment = new Equipment("EQ010", "Spectrometer", "Lab B");
        state = new AvailableState();
    }

    @Test
    public void testIsAvailable_returnsTrue() {
        assertTrue(state.isAvailable());
    }

    @Test
    public void testGetStateName_returnsAvailable() {
        assertEquals("Available", state.getStateName());
    }

    @Test
    public void testDisable_transitionsToDisabledState() {
        state.disable(equipment);
        assertFalse(equipment.canReserve());
    }

    @Test
    public void testDisable_newStateIsDisabledState() {
        state.disable(equipment);
        assertTrue(equipment.getState() instanceof DisabledState);
    }

    @Test
    public void testMarkUnderMaintenance_transitionsToMaintenanceState() {
        state.markUnderMaintenance(equipment);
        assertTrue(equipment.getState() instanceof MaintenanceState);
    }

    @Test
    public void testMarkUnderMaintenance_equipmentCannotReserve() {
        state.markUnderMaintenance(equipment);
        assertFalse(equipment.canReserve());
    }

    @Test
    public void testEnable_alreadyAvailable_staysAvailable() {
        state.enable(equipment);
        assertTrue(equipment.canReserve());
        assertEquals("Available", equipment.getCurrentStateName());
    }

    @Test
    public void testEnable_noStateChange() {
        state.enable(equipment);
        assertTrue(equipment.getState() instanceof AvailableState);
    }

    @Test
    public void testStateIndependence_twoEquipments() {
        Equipment eq2 = new Equipment("EQ011", "Centrifuge", "Lab A");
        equipment.disable();
        assertTrue(eq2.canReserve());
    }

    @Test
    public void testGetStateName_notDisabled() {
        assertNotEquals("Disabled", state.getStateName());
    }

    @Test
    public void testGetStateName_notMaintenance() {
        assertNotEquals("Maintenance", state.getStateName());
    }
}

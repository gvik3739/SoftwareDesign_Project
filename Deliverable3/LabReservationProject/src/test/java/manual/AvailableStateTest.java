package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Equipment;
import model.AvailableState;
import model.DisabledState;
import model.MaintenanceState;

/**
 * Tests for AvailableState — the default state of equipment.
 * Verifies all state transitions originating from Available.
 */
public class AvailableStateTest {

    private Equipment equipment;
    private AvailableState state;

    @BeforeEach
    public void setUp() {
        equipment = new Equipment("EQ001", "Digital Microscope", "Lab A");
        state     = new AvailableState();
    }

    @Test
    public void testIsAvailable_availableState_returnsTrue() {
        assertTrue(state.isAvailable(),
            "An AvailableState should always report itself as available");
    }

    @Test
    public void testGetStateName_availableState_returnsAvailable() {
        assertEquals("Available", state.getStateName());
    }

    @Test
    public void testDisable_availableEquipment_transitionsToDisabled() {
        // Available → Disabled: equipment should no longer accept reservations
        state.disable(equipment);
        assertEquals("Disabled", equipment.getCurrentStateName());
        assertFalse(equipment.canReserve());
    }

    @Test
    public void testMarkUnderMaintenance_availableEquipment_transitionsToMaintenance() {
        // Available → Maintenance: equipment goes offline for repairs
        state.markUnderMaintenance(equipment);
        assertEquals("Maintenance", equipment.getCurrentStateName());
        assertFalse(equipment.canReserve());
    }

    @Test
    public void testEnable_alreadyAvailable_staysAvailable() {
        // Enabling an already-available piece of equipment is a no-op
        state.enable(equipment);
        assertEquals("Available", equipment.getCurrentStateName());
        assertTrue(equipment.canReserve());
    }

    @Test
    public void testDisable_availableState_newStateIsDisabledState() {
        state.disable(equipment);
        assertTrue(equipment.getState() instanceof DisabledState);
    }

    @Test
    public void testMarkUnderMaintenance_availableState_newStateIsMaintenanceState() {
        state.markUnderMaintenance(equipment);
        assertTrue(equipment.getState() instanceof MaintenanceState);
    }

    @Test
    public void testStateAfterDoubleDisable_idempotent() {
        // Disabling via state then calling disable on the new state should not crash
        state.disable(equipment);
        equipment.disable(); // now in DisabledState — no-op
        assertEquals("Disabled", equipment.getCurrentStateName());
    }

    @Test
    public void testCanReserve_newEquipmentWithAvailableState_returnsTrue() {
        // Any equipment in AvailableState can be booked
        Equipment eq2 = new Equipment("EQ002", "Centrifuge", "Lab A");
        assertTrue(eq2.canReserve());
    }

    @Test
    public void testAvailableStateSingleton_twoTransitions_independentObjects() {
        // Each transition creates a new state object — equipment state should be independent
        Equipment eq1 = new Equipment("EQ001", "Microscope", "Lab A");
        Equipment eq2 = new Equipment("EQ002", "Centrifuge", "Lab A");
        eq1.disable();
        // eq2 should remain available
        assertTrue(eq2.canReserve(), "eq2 state should not be affected by eq1 transition");
    }

    @Test
    public void testStateChain_availableDisabledMaintenance_correctSequence() {
        // Walk the state machine: Available → Disabled → Maintenance
        assertEquals("Available", equipment.getCurrentStateName());
        equipment.disable();
        assertEquals("Disabled", equipment.getCurrentStateName());
        equipment.markUnderMaintenance();
        assertEquals("Maintenance", equipment.getCurrentStateName());
    }

    @Test
    public void testStateChain_availableMaintenanceAvailable_roundTrip() {
        // Walk the state machine: Available → Maintenance → Available
        equipment.markUnderMaintenance();
        equipment.enable();
        assertEquals("Available", equipment.getCurrentStateName());
        assertTrue(equipment.canReserve());
    }
}

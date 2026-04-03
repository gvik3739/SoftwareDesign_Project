package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Equipment;
import model.AvailableState;
import model.DisabledState;
import model.MaintenanceState;

/**
 * Tests for DisabledState — the state representing equipment taken offline.
 * Corresponds to EQ005 (Oscilloscope, Lab C, DISABLED) in equipment.csv.
 */
public class DisabledStateTest {

    private Equipment oscilloscope;
    private DisabledState state;

    @BeforeEach
    public void setUp() {
        oscilloscope = new Equipment("EQ005", "Oscilloscope", "Lab C");
        oscilloscope.disable(); // mirror equipment.csv state
        state = new DisabledState();
    }

    @Test
    public void testIsAvailable_disabledState_returnsFalse() {
        // Disabled equipment must not show up in availability searches
        assertFalse(state.isAvailable());
    }

    @Test
    public void testGetStateName_disabledState_returnsDisabled() {
        assertEquals("Disabled", state.getStateName());
    }

    @Test
    public void testEnable_disabledEquipment_transitionsToAvailable() {
        // Re-enabling should make the oscilloscope reservable again
        assertFalse(oscilloscope.canReserve());
        oscilloscope.enable();
        assertEquals("Available", oscilloscope.getCurrentStateName());
        assertTrue(oscilloscope.canReserve());
    }

    @Test
    public void testDisable_alreadyDisabled_noStateChange() {
        // Calling disable on already-disabled equipment is a no-op
        oscilloscope.disable();
        assertEquals("Disabled", oscilloscope.getCurrentStateName());
    }

    @Test
    public void testMarkUnderMaintenance_disabledEquipment_transitionsToMaintenance() {
        // Disabled → Maintenance is a valid transition (e.g., equipment needs repair)
        oscilloscope.markUnderMaintenance();
        assertEquals("Maintenance", oscilloscope.getCurrentStateName());
        assertFalse(oscilloscope.canReserve());
    }

    @Test
    public void testCanReserve_disabledEquipment_returnsFalse() {
        assertFalse(oscilloscope.canReserve(),
            "Disabled equipment (EQ005) must not be reservable");
    }

    @Test
    public void testEnable_disabledState_newStateIsAvailableState() {
        state.enable(oscilloscope);
        assertTrue(oscilloscope.getState() instanceof AvailableState);
    }

    @Test
    public void testMarkUnderMaintenance_disabledState_newStateIsMaintenanceState() {
        state.markUnderMaintenance(oscilloscope);
        assertTrue(oscilloscope.getState() instanceof MaintenanceState);
    }

    @Test
    public void testStateTransitionChain_disabledAvailableDisabled_correctCycle() {
        // Disable → Enable → Disable should work correctly
        assertEquals("Disabled", oscilloscope.getCurrentStateName());
        oscilloscope.enable();
        assertEquals("Available", oscilloscope.getCurrentStateName());
        oscilloscope.disable();
        assertEquals("Disabled", oscilloscope.getCurrentStateName());
    }

    @Test
    public void testStateDoesNotAffectId_equipmentIdUnchanged() {
        // State transitions must never corrupt equipment identity
        String originalId = oscilloscope.getEquipmentId();
        oscilloscope.enable();
        oscilloscope.disable();
        assertEquals(originalId, oscilloscope.getEquipmentId());
    }

    @Test
    public void testDisabledEquipment_getCurrentStateName_returnsDisabled() {
        assertEquals("Disabled", oscilloscope.getCurrentStateName());
    }
}

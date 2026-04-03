package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Equipment;
import model.AvailableState;
import model.DisabledState;
import model.MaintenanceState;

/**
 * Tests for MaintenanceState — represents equipment offline for repairs.
 * Corresponds to EQ006 (3D Printer, Lab C, MAINTENANCE) in equipment.csv.
 */
public class MaintenanceStateTest {

    private Equipment printer;
    private MaintenanceState state;

    @BeforeEach
    public void setUp() {
        printer = new Equipment("EQ006", "3D Printer", "Lab C");
        printer.markUnderMaintenance(); // mirror equipment.csv state
        state   = new MaintenanceState();
    }

    @Test
    public void testIsAvailable_maintenanceState_returnsFalse() {
        assertFalse(state.isAvailable(),
            "Equipment under maintenance must not be available for reservations");
    }

    @Test
    public void testGetStateName_maintenanceState_returnsMaintenance() {
        assertEquals("Maintenance", state.getStateName());
    }

    @Test
    public void testCanReserve_maintenanceEquipment_returnsFalse() {
        assertFalse(printer.canReserve(),
            "EQ006 (3D Printer) is under maintenance and must not accept reservations");
    }

    @Test
    public void testEnable_maintenanceEquipment_transitionsToAvailable() {
        // When repairs are complete, the lab manager enables the equipment
        printer.enable();
        assertEquals("Available", printer.getCurrentStateName());
        assertTrue(printer.canReserve());
    }

    @Test
    public void testDisable_maintenanceEquipment_noStateChange() {
        // Cannot disable equipment that is already under maintenance
        printer.disable(); // should be a no-op per MaintenanceState logic
        assertEquals("Maintenance", printer.getCurrentStateName());
    }

    @Test
    public void testMarkUnderMaintenance_alreadyInMaintenance_noStateChange() {
        // Re-triggering maintenance on already-in-maintenance equipment is a no-op
        printer.markUnderMaintenance();
        assertEquals("Maintenance", printer.getCurrentStateName());
    }

    @Test
    public void testEnable_maintenanceState_newStateIsAvailableState() {
        state.enable(printer);
        assertTrue(printer.getState() instanceof AvailableState);
    }

    @Test
    public void testGetCurrentStateName_printerUnderMaintenance_returnsMaintenance() {
        assertEquals("Maintenance", printer.getCurrentStateName());
    }

    @Test
    public void testStateTransition_maintenanceAvailableDisabledMaintenance() {
        // Full cycle: Maintenance → Available → Disabled → Maintenance
        printer.enable();
        assertEquals("Available", printer.getCurrentStateName());
        printer.disable();
        assertEquals("Disabled", printer.getCurrentStateName());
        printer.markUnderMaintenance();
        assertEquals("Maintenance", printer.getCurrentStateName());
    }

    @Test
    public void testEquipmentData_notCorruptedByStateTransitions() {
        // State changes must not alter equipment identity data
        String origId   = printer.getEquipmentId();
        String origDesc = printer.getDescription();
        printer.enable();
        printer.disable();
        printer.markUnderMaintenance();
        assertEquals(origId,   printer.getEquipmentId());
        assertEquals(origDesc, printer.getDescription());
    }

    @Test
    public void testIsAvailable_allThreeStates_onlyAvailableReturnsTrue() {
        Equipment eq = new Equipment("EQ001", "Microscope", "Lab A");
        assertTrue(eq.isAvailable());
        eq.disable();
        assertFalse(eq.isAvailable());
        eq.markUnderMaintenance();
        assertFalse(eq.isAvailable());
        eq.enable();
        assertTrue(eq.isAvailable());
    }
}

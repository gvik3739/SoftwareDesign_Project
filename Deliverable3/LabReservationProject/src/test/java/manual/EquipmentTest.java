package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Equipment;
import model.AvailableState;
import model.DisabledState;
import model.MaintenanceState;

/**
 * Tests for the Equipment model and its state management.
 * Real data from equipment.csv:
 *   EQ001 - Digital Microscope, Lab A, AVAILABLE
 *   EQ005 - Oscilloscope, Lab C, DISABLED
 *   EQ006 - 3D Printer, Lab C, MAINTENANCE
 */
public class EquipmentTest {

    private Equipment microscope;
    private Equipment oscilloscope;

    @BeforeEach
    public void setUp() {
        microscope   = new Equipment("EQ001", "Digital Microscope", "Lab A");
        oscilloscope = new Equipment("EQ005", "Oscilloscope", "Lab C");
        oscilloscope.disable(); // mirrors CSV state
    }

    @Test
    public void testGetEquipmentId_eq001_returnsCorrectId() {
        assertEquals("EQ001", microscope.getEquipmentId());
    }

    @Test
    public void testGetDescription_microscope_returnsDescription() {
        assertEquals("Digital Microscope", microscope.getDescription());
    }

    @Test
    public void testGetName_microscope_returnsSameAsDescription() {
        // getName() is an alias for getDescription() used by the command layer
        assertEquals(microscope.getDescription(), microscope.getName());
    }

    @Test
    public void testGetLabLocation_labA_returnsLocation() {
        assertEquals("Lab A", microscope.getLabLocation());
    }

    @Test
    public void testCanReserve_newEquipment_defaultsToAvailable() {
        Equipment eq = new Equipment("EQ099", "Test Device", "Lab X");
        assertTrue(eq.canReserve(), "New equipment should default to AVAILABLE");
    }

    @Test
    public void testGetCurrentStateName_newEquipment_returnsAvailable() {
        assertEquals("Available", microscope.getCurrentStateName());
    }

    @Test
    public void testDisable_availableEquipment_preventsReservations() {
        assertTrue(microscope.canReserve());
        microscope.disable();
        assertFalse(microscope.canReserve());
        assertEquals("Disabled", microscope.getCurrentStateName());
    }

    @Test
    public void testEnable_disabledEquipment_restoresAvailability() {
        assertFalse(oscilloscope.canReserve());
        oscilloscope.enable();
        assertTrue(oscilloscope.canReserve());
        assertEquals("Available", oscilloscope.getCurrentStateName());
    }

    @Test
    public void testMarkUnderMaintenance_available_blocksReservations() {
        microscope.markUnderMaintenance();
        assertFalse(microscope.canReserve());
        assertEquals("Maintenance", microscope.getCurrentStateName());
    }

    @Test
    public void testMarkUnderMaintenance_disabled_transitionsToMaintenance() {
        oscilloscope.markUnderMaintenance();
        assertEquals("Maintenance", oscilloscope.getCurrentStateName());
        assertFalse(oscilloscope.canReserve());
    }

    @Test
    public void testEnable_maintenanceEquipment_becomesAvailable() {
        microscope.markUnderMaintenance();
        microscope.enable();
        assertEquals("Available", microscope.getCurrentStateName());
        assertTrue(microscope.canReserve());
    }

    @Test
    public void testSetState_explicitAvailableState_marksAvailable() {
        microscope.disable();
        microscope.setState(new AvailableState());
        assertTrue(microscope.isAvailable());
    }

    @Test
    public void testIsAvailable_disabledEquipment_returnsFalse() {
        microscope.disable();
        assertFalse(microscope.isAvailable());
    }

    @Test
    public void testSetStatus_customStatus_storedCorrectly() {
        microscope.setStatus("CUSTOM_STATUS");
        assertEquals("CUSTOM_STATUS", microscope.getStatus());
    }

    @Test
    public void testGetStatus_defaultStatus_returnsAvailable() {
        assertEquals("AVAILABLE", microscope.getStatus());
    }
}

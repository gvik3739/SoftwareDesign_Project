package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import data.MaintainEquipment;
import model.Equipment;
import java.io.*;

/**
 * Tests for MaintainEquipment — the data-access layer for Equipment objects.
 * Uses temp files to avoid modifying the real equipment.csv.
 * Real data from equipment.csv:
 *   EQ001,Digital Microscope,Lab A,AVAILABLE
 *   EQ005,Oscilloscope,Lab C,DISABLED
 *   EQ006,3D Printer,Lab C,MAINTENANCE
 */
public class MaintainEquipmentTest {

    private File tempCsv;
    private MaintainEquipment maintainEquipment;

    @BeforeEach
    public void setUp() throws Exception {
        tempCsv = File.createTempFile("equipment_test", ".csv");
        tempCsv.deleteOnExit();
        writeCsv(
            "equipmentId,description,labLocation,status",
            "EQ001,Digital Microscope,Lab A,AVAILABLE",
            "EQ002,Centrifuge,Lab A,AVAILABLE",
            "EQ003,PCR Machine,Lab B,AVAILABLE",
            "EQ004,Spectrophotometer,Lab B,AVAILABLE",
            "EQ005,Oscilloscope,Lab C,DISABLED",
            "EQ006,3D Printer,Lab C,MAINTENANCE"
        );
        maintainEquipment = new MaintainEquipment();
    }

    @AfterEach
    public void tearDown() {
        if (tempCsv != null) tempCsv.delete();
    }

    private void writeCsv(String... lines) throws Exception {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv))) {
            for (String line : lines) pw.println(line);
        }
    }

    @Test
    public void testLoad_validCsvFile_loadsAllSixEquipment() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        assertEquals(6, maintainEquipment.equipmentList.size());
    }

    @Test
    public void testLoad_eq001_parsedCorrectly() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        Equipment eq = maintainEquipment.equipmentList.get(0);
        assertEquals("EQ001", eq.getEquipmentId());
        assertEquals("Digital Microscope", eq.getDescription());
        assertEquals("Lab A", eq.getLabLocation());
    }

    @Test
    public void testLoad_eq001_isAvailable() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        Equipment eq = maintainEquipment.findById("EQ001");
        assertTrue(eq.canReserve(), "EQ001 is AVAILABLE in CSV and should be reservable");
    }

    @Test
    public void testLoad_eq005_isDisabled() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        Equipment eq = maintainEquipment.findById("EQ005");
        assertFalse(eq.canReserve(), "EQ005 is DISABLED in CSV and must not be reservable");
        assertEquals("Disabled", eq.getCurrentStateName());
    }

    @Test
    public void testLoad_eq006_isUnderMaintenance() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        Equipment eq = maintainEquipment.findById("EQ006");
        assertFalse(eq.canReserve(), "EQ006 is MAINTENANCE in CSV");
        assertEquals("Maintenance", eq.getCurrentStateName());
    }

    @Test
    public void testFindById_existingId_returnsEquipment() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        Equipment eq = maintainEquipment.findById("EQ002");
        assertNotNull(eq);
        assertEquals("Centrifuge", eq.getDescription());
    }

    @Test
    public void testFindById_nonExistentId_returnsNull() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        assertNull(maintainEquipment.findById("EQ999"),
            "Lookup for unknown equipment ID should return null");
    }

    @Test
    public void testGetAvailableEquipment_returnsFourItems() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        // EQ001-EQ004 are AVAILABLE; EQ005 DISABLED; EQ006 MAINTENANCE
        assertEquals(4, maintainEquipment.getAvailableEquipment().size());
    }

    @Test
    public void testGetAvailableEquipment_doesNotIncludeDisabled() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        boolean found = maintainEquipment.getAvailableEquipment().stream()
            .anyMatch(e -> e.getEquipmentId().equals("EQ005"));
        assertFalse(found, "Disabled EQ005 must not appear in available list");
    }

    @Test
    public void testGetAvailableEquipment_doesNotIncludeMaintenance() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        boolean found = maintainEquipment.getAvailableEquipment().stream()
            .anyMatch(e -> e.getEquipmentId().equals("EQ006"));
        assertFalse(found, "Maintenance EQ006 must not appear in available list");
    }

    @Test
    public void testUpdate_persistsChanges_reloadShowsUpdatedState() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        Equipment eq1 = maintainEquipment.findById("EQ001");
        eq1.disable();
        maintainEquipment.update(tempCsv.getAbsolutePath());

        MaintainEquipment reloaded = new MaintainEquipment();
        reloaded.load(tempCsv.getAbsolutePath());
        Equipment reloadedEq = reloaded.findById("EQ001");
        assertEquals("Disabled", reloadedEq.getCurrentStateName(),
            "After disabling and saving, EQ001 should reload as DISABLED");
    }

    @Test
    public void testLoad_missingFile_loadsEmptyList() throws Exception {
        maintainEquipment.load("/tmp/nonexistent_equipment.csv");
        assertEquals(0, maintainEquipment.equipmentList.size());
    }

    @Test
    public void testLoad_calledTwice_noDuplication() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        maintainEquipment.load(tempCsv.getAbsolutePath());
        assertEquals(6, maintainEquipment.equipmentList.size(),
            "Second load must reset the list, not append to it");
    }

    @Test
    public void testLoad_allFourAvailableFound_inAvailableList() throws Exception {
        maintainEquipment.load(tempCsv.getAbsolutePath());
        java.util.List<Equipment> available = maintainEquipment.getAvailableEquipment();
        assertTrue(available.stream().anyMatch(e -> e.getEquipmentId().equals("EQ001")));
        assertTrue(available.stream().anyMatch(e -> e.getEquipmentId().equals("EQ002")));
        assertTrue(available.stream().anyMatch(e -> e.getEquipmentId().equals("EQ003")));
        assertTrue(available.stream().anyMatch(e -> e.getEquipmentId().equals("EQ004")));
    }
}

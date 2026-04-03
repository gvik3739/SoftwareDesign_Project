package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import data.MaintainReservation;
import model.Reservation;
import java.io.*;
import java.time.LocalDateTime;

/**
 * Tests for MaintainReservation — persistence and overlap detection.
 * Uses temp CSV files to avoid touching the real reservations.csv.
 */
public class MaintainReservationTest {

    private File tempCsv;
    private MaintainReservation mr;

    private static final String HEADER =
        "reservationId,userId,equipmentId,startTime,endTime,status,depositAmount,depositForfeited";

    // Two non-overlapping reservations for EQ001
    private static final String R001 =
        "R001,123456789,EQ001,2026-04-01 10:00,2026-04-01 12:00,ACTIVE,10.00,false";
    private static final String R002 =
        "R002,987654321,EQ001,2026-04-01 14:00,2026-04-01 16:00,ACTIVE,15.00,false";
    private static final String R003_CANCELLED =
        "R003,111222333,EQ001,2026-04-01 10:00,2026-04-01 12:00,CANCELLED,20.00,false";

    @BeforeEach
    public void setUp() throws Exception {
        tempCsv = File.createTempFile("reservations_test", ".csv");
        tempCsv.deleteOnExit();
        writeCsv(HEADER, R001, R002, R003_CANCELLED);
        mr = new MaintainReservation();
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
    public void testLoad_validCsvFile_loadsAllReservations() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        assertEquals(3, mr.reservations.size());
    }

    @Test
    public void testLoad_r001_equipmentIdParsedCorrectly() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        assertEquals("EQ001", mr.reservations.get(0).getEquipmentId());
    }

    @Test
    public void testLoad_r001_statusIsActive() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        assertEquals("ACTIVE", mr.reservations.get(0).getStatus());
    }

    @Test
    public void testLoad_r003_statusIsCancelled() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        assertEquals("CANCELLED", mr.reservations.get(2).getStatus());
    }

    @Test
    public void testLoad_r001_startTimeParsedCorrectly() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        LocalDateTime expected = LocalDateTime.of(2026, 4, 1, 10, 0);
        assertEquals(expected, mr.reservations.get(0).getStartTime());
    }

    @Test
    public void testLoad_r001_depositAmountParsedCorrectly() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        assertEquals(10.00, mr.reservations.get(0).getDepositAmount(), 0.001);
    }

    @Test
    public void testNextId_emptyList_returnsR001() {
        assertEquals("R001", mr.nextId());
    }

    @Test
    public void testNextId_afterLoading3Reservations_returnsR004() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        assertEquals("R004", mr.nextId());
    }

    @Test
    public void testHasOverlap_exactSameSlot_returnsTrue() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        // R001 occupies EQ001 10:00-12:00 — trying to book the same slot
        boolean overlap = mr.hasOverlap("EQ001",
            LocalDateTime.of(2026, 4, 1, 10, 0),
            LocalDateTime.of(2026, 4, 1, 12, 0),
            null);
        assertTrue(overlap, "Exact same time slot must be detected as overlap");
    }

    @Test
    public void testHasOverlap_partialOverlapBeginning_returnsTrue() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        boolean overlap = mr.hasOverlap("EQ001",
            LocalDateTime.of(2026, 4, 1, 9, 0),
            LocalDateTime.of(2026, 4, 1, 11, 0),
            null);
        assertTrue(overlap);
    }

    @Test
    public void testHasOverlap_nonOverlappingSlot_returnsFalse() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        // 12:00-13:00 is between R001 (ends 12:00) and R002 (starts 14:00) — no overlap
        boolean overlap = mr.hasOverlap("EQ001",
            LocalDateTime.of(2026, 4, 1, 12, 30),
            LocalDateTime.of(2026, 4, 1, 13, 30),
            null);
        assertFalse(overlap, "Gap between reservations should not be flagged as overlap");
    }

    @Test
    public void testHasOverlap_cancelledReservation_ignored() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        // R003 is CANCELLED — its slot should be available for rebooking
        boolean overlap = mr.hasOverlap("EQ001",
            LocalDateTime.of(2026, 4, 1, 10, 0),
            LocalDateTime.of(2026, 4, 1, 12, 0),
            "R001"); // exclude R001 too
        assertFalse(overlap,
            "CANCELLED reservation R003 must not block the time slot");
    }

    @Test
    public void testHasOverlap_excludeCurrentReservation_noSelfConflict() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        // When modifying R001, it should not conflict with itself
        boolean overlap = mr.hasOverlap("EQ001",
            LocalDateTime.of(2026, 4, 1, 10, 0),
            LocalDateTime.of(2026, 4, 1, 12, 0),
            "R001");
        assertFalse(overlap,
            "Excluding R001 from overlap check must not report self-conflict");
    }

    @Test
    public void testHasOverlap_differentEquipment_returnsFalse() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        // EQ002 has no reservations — any slot for it is free
        boolean overlap = mr.hasOverlap("EQ002",
            LocalDateTime.of(2026, 4, 1, 10, 0),
            LocalDateTime.of(2026, 4, 1, 12, 0),
            null);
        assertFalse(overlap);
    }

    @Test
    public void testHasOverlap_stringVersion_worksLikeDateTimeVersion() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        boolean overlap = mr.hasOverlap("EQ001",
            "2026-04-01 10:00", "2026-04-01 12:00", null);
        assertTrue(overlap);
    }

    @Test
    public void testUpdate_addsReservation_reloadShowsNewEntry() throws Exception {
        mr.load(tempCsv.getAbsolutePath());
        // Nothing to add — just verify round-trip
        mr.update(tempCsv.getAbsolutePath());
        MaintainReservation reloaded = new MaintainReservation();
        reloaded.load(tempCsv.getAbsolutePath());
        assertEquals(3, reloaded.reservations.size());
    }

    @Test
    public void testLoad_missingFile_loadsEmptyList() throws Exception {
        mr.load("/tmp/no_reservations.csv");
        assertEquals(0, mr.reservations.size());
    }
}

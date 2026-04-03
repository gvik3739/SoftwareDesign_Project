package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import data.MaintainPayment;
import model.Payment;
import java.io.*;

/**
 * Tests for MaintainPayment — persistence layer for Payment records.
 * Real data from payments.csv:
 *   P001,R001,123456789,10.00,Credit Card,COMPLETED,2026-03-19 00:51,DEPOSIT
 *   P002,R002,123456789,10.00,Debit,COMPLETED,2026-03-19 00:51,DEPOSIT
 */
public class MaintainPaymentTest {

    private File tempCsv;
    private MaintainPayment maintainPayment;

    private static final String HEADER =
        "paymentId,reservationId,userId,amount,paymentMethod,status,timestamp,type";
    private static final String P001 =
        "P001,R001,123456789,10.00,Credit Card,COMPLETED,2026-03-19 00:51,DEPOSIT";
    private static final String P002 =
        "P002,R002,123456789,10.00,Debit,COMPLETED,2026-03-19 00:51,DEPOSIT";
    private static final String P003 =
        "P003,R003,123456789,10.00,Debit,COMPLETED,2026-03-19 00:53,DEPOSIT";

    @BeforeEach
    public void setUp() throws Exception {
        tempCsv = File.createTempFile("payments_test", ".csv");
        tempCsv.deleteOnExit();
        writeCsv(HEADER, P001, P002, P003);
        maintainPayment = new MaintainPayment();
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
    public void testLoad_validCsvFile_loadsAllPayments() throws Exception {
        maintainPayment.load(tempCsv.getAbsolutePath());
        assertEquals(3, maintainPayment.payments.size());
    }

    @Test
    public void testLoad_p001_parsedCorrectly() throws Exception {
        maintainPayment.load(tempCsv.getAbsolutePath());
        Payment p = maintainPayment.payments.get(0);
        assertEquals("P001", p.getPaymentId());
        assertEquals("R001", p.getReservationId());
        assertEquals("123456789", p.getUserId());
        assertEquals(10.00, p.getAmount(), 0.001);
        assertEquals("Credit Card", p.getPaymentMethod());
        assertEquals("COMPLETED", p.getStatus());
        assertEquals("DEPOSIT", p.getType());
    }

    @Test
    public void testLoad_p002_paymentMethod_isDebit() throws Exception {
        maintainPayment.load(tempCsv.getAbsolutePath());
        assertEquals("Debit", maintainPayment.payments.get(1).getPaymentMethod());
    }

    @Test
    public void testNextId_emptyList_returnsP001() {
        // When no payments exist, first ID should be P001
        assertEquals("P001", maintainPayment.nextId());
    }

    @Test
    public void testNextId_afterLoadingThreePayments_returnsP004() throws Exception {
        maintainPayment.load(tempCsv.getAbsolutePath());
        assertEquals("P004", maintainPayment.nextId(),
            "After loading 3 payments, next ID should be P004");
    }

    @Test
    public void testNextId_sequentialIds_correctFormat() {
        // Verify the zero-padding format: P001, P002, ...
        assertEquals("P001", maintainPayment.nextId());
        maintainPayment.payments.add(new Payment("P001","R001","123",10.0,"Debit","COMPLETED","2026-01-01","DEPOSIT"));
        assertEquals("P002", maintainPayment.nextId());
    }

    @Test
    public void testUpdate_writesPaymentsToCsv_reloadSucceeds() throws Exception {
        maintainPayment.load(tempCsv.getAbsolutePath());
        maintainPayment.update(tempCsv.getAbsolutePath());
        MaintainPayment reloaded = new MaintainPayment();
        reloaded.load(tempCsv.getAbsolutePath());
        assertEquals(3, reloaded.payments.size());
    }

    @Test
    public void testUpdate_addNewPayment_persistedCorrectly() throws Exception {
        maintainPayment.load(tempCsv.getAbsolutePath());
        Payment newPayment = new Payment("P004","R004","987654321",15.0,"Credit Card","COMPLETED","2026-04-01 10:00","DEPOSIT");
        maintainPayment.payments.add(newPayment);
        maintainPayment.update(tempCsv.getAbsolutePath());

        MaintainPayment reloaded = new MaintainPayment();
        reloaded.load(tempCsv.getAbsolutePath());
        assertEquals(4, reloaded.payments.size());
        assertEquals("P004", reloaded.payments.get(3).getPaymentId());
    }

    @Test
    public void testLoad_missingFile_loadsEmptyList() throws Exception {
        maintainPayment.load("/tmp/no_payments_file.csv");
        assertEquals(0, maintainPayment.payments.size());
    }

    @Test
    public void testLoad_calledTwice_noDuplication() throws Exception {
        maintainPayment.load(tempCsv.getAbsolutePath());
        maintainPayment.load(tempCsv.getAbsolutePath());
        assertEquals(3, maintainPayment.payments.size());
    }

    @Test
    public void testLoad_timestamp_parsedAsString() throws Exception {
        maintainPayment.load(tempCsv.getAbsolutePath());
        assertEquals("2026-03-19 00:51", maintainPayment.payments.get(0).getTimestamp());
    }
}

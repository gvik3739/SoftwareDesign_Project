package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Payment;

/**
 * Tests for the Payment model.
 * Real data from payments.csv:
 *   P001, R001, 123456789, 10.00, Credit Card, COMPLETED, 2026-03-19 00:51, DEPOSIT
 *   P002, R002, 123456789, 10.00, Debit, COMPLETED, 2026-03-19 00:51, DEPOSIT
 */
public class PaymentTest {

    private Payment completedPayment;
    private Payment failedPayment;

    @BeforeEach
    public void setUp() {
        // Mirrors P001 from payments.csv
        completedPayment = new Payment(
            "P001", "R001", "123456789",
            10.00, "Credit Card", "COMPLETED", "2026-03-19 00:51", "DEPOSIT"
        );
        failedPayment = new Payment(
            "P099", "R099", "123456789",
            10.00, "Debit", "FAILED", "2026-03-20 10:00", "DEPOSIT"
        );
    }

    @Test
    public void testGetPaymentId_p001_returnsCorrectId() {
        assertEquals("P001", completedPayment.getPaymentId());
    }

    @Test
    public void testGetReservationId_r001_returnsLinkedReservation() {
        // Payment must be traceable back to its reservation
        assertEquals("R001", completedPayment.getReservationId());
    }

    @Test
    public void testGetUserId_studentId_returnsIdFromCsv() {
        assertEquals("123456789", completedPayment.getUserId());
    }

    @Test
    public void testGetAmount_tenDollars_returnsCorrectAmount() {
        assertEquals(10.00, completedPayment.getAmount(), 0.001);
    }

    @Test
    public void testGetPaymentMethod_creditCard_returnsMethodName() {
        assertEquals("Credit Card", completedPayment.getPaymentMethod());
    }

    @Test
    public void testGetStatus_completedPayment_returnsCompleted() {
        assertEquals("COMPLETED", completedPayment.getStatus());
    }

    @Test
    public void testGetStatus_failedPayment_returnsFailed() {
        assertEquals("FAILED", failedPayment.getStatus());
    }

    @Test
    public void testGetTimestamp_payment_returnsFormattedTimestamp() {
        assertEquals("2026-03-19 00:51", completedPayment.getTimestamp());
    }

    @Test
    public void testGetType_depositPayment_returnsDeposit() {
        assertEquals("DEPOSIT", completedPayment.getType());
    }

    @Test
    public void testGetType_finalPayment_returnsFinal() {
        Payment finalPayment = new Payment(
            "P003", "R001", "123456789",
            30.00, "Credit Card", "COMPLETED", "2026-03-19 10:00", "FINAL"
        );
        assertEquals("FINAL", finalPayment.getType());
    }

    @Test
    public void testGetAmount_zeroAmount_storedCorrectly() {
        // Edge case: zero-amount payment (e.g., lab manager transaction)
        Payment zero = new Payment("P000", "R000", "LM001", 0.0, "N/A", "COMPLETED", "2026-03-19 00:00", "DEPOSIT");
        assertEquals(0.0, zero.getAmount(), 0.001);
    }

    @Test
    public void testGetAmount_largeAmount_storedWithPrecision() {
        // Edge case: multi-hour session fee
        Payment large = new Payment("P050", "R050", "111222333", 200.00, "Research Grant", "COMPLETED", "2026-03-19 09:00", "FINAL");
        assertEquals(200.00, large.getAmount(), 0.001);
    }
}

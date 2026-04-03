package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.DebitPaymentStrategy;
import strategy.PaymentStrategy;

/**
 * Tests for DebitPaymentStrategy.
 * P002/P003 in payments.csv use Debit as the payment method.
 */
public class DebitPaymentStrategyTest {

    private DebitPaymentStrategy strategy;

    @BeforeEach
    public void setUp() { strategy = new DebitPaymentStrategy(); }

    @Test public void testGetMethodName_returnsDebit() { assertEquals("Debit", strategy.getMethodName()); }
    @Test public void testProcessPayment_tenDollars_returnsTrue() { assertTrue(strategy.processPayment(10.00)); }
    @Test public void testProcessPayment_zeroDollars_returnsTrue() { assertTrue(strategy.processPayment(0.0)); }
    @Test public void testProcessPayment_largeFee_returnsTrue() { assertTrue(strategy.processPayment(200.00)); }
    @Test public void testImplementsPaymentStrategy() { assertTrue(strategy instanceof PaymentStrategy); }
    @Test public void testGetMethodName_notEmpty() { assertFalse(strategy.getMethodName().isEmpty()); }
    @Test public void testGetMethodName_isDifferentFromCreditCard() {
        assertNotEquals("Credit Card", strategy.getMethodName());
    }
    @Test public void testProcessPayment_calledRepeatedly_alwaysSucceeds() {
        assertTrue(strategy.processPayment(10.00));
        assertTrue(strategy.processPayment(20.00));
        assertTrue(strategy.processPayment(30.00));
    }
    @Test public void testGetMethodName_multipleInstances_sameValue() {
        assertEquals(strategy.getMethodName(), new DebitPaymentStrategy().getMethodName());
    }
    @Test public void testProcessPayment_studentDeposit_returnsTrue() {
        // Mirrors P002 and P003 from payments.csv: $10 Debit COMPLETED
        assertTrue(strategy.processPayment(10.00));
    }
    @Test public void testProcessPayment_fractional_returnsTrue() { assertTrue(strategy.processPayment(12.50)); }
    @Test public void testProcessPayment_negativeAmount_doesNotThrow() {
        assertDoesNotThrow(() -> strategy.processPayment(-1.0));
    }
}

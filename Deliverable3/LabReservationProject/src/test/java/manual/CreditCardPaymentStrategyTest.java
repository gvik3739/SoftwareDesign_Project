package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.CreditCardPaymentStrategy;
import strategy.PaymentStrategy;

/**
 * Tests for CreditCardPaymentStrategy.
 * This strategy always returns true (payment always succeeds in the current implementation).
 */
public class CreditCardPaymentStrategyTest {

    private CreditCardPaymentStrategy strategy;

    @BeforeEach
    public void setUp() { strategy = new CreditCardPaymentStrategy(); }

    @Test public void testGetMethodName_returnsCreditCard() { assertEquals("Credit Card", strategy.getMethodName()); }
    @Test public void testProcessPayment_tenDollars_returnsTrue() { assertTrue(strategy.processPayment(10.00)); }
    @Test public void testProcessPayment_thirtyDollars_returnsTrue() { assertTrue(strategy.processPayment(30.00)); }
    @Test public void testProcessPayment_zeroDollars_returnsTrue() { assertTrue(strategy.processPayment(0.0)); }
    @Test public void testProcessPayment_largeAmount_returnsTrue() { assertTrue(strategy.processPayment(999.99)); }
    @Test public void testProcessPayment_exactStudentDeposit_returnsTrue() {
        // P001 in payments.csv: $10 Credit Card payment
        assertTrue(strategy.processPayment(10.00));
    }
    @Test public void testImplementsPaymentStrategy() { assertTrue(strategy instanceof PaymentStrategy); }
    @Test public void testGetMethodName_notEmpty() { assertFalse(strategy.getMethodName().isEmpty()); }
    @Test public void testProcessPayment_calledMultipleTimes_alwaysSucceeds() {
        for (int i = 0; i < 5; i++) assertTrue(strategy.processPayment(10.00 * i));
    }
    @Test public void testGetMethodName_multipleInstances_sameValue() {
        assertEquals(strategy.getMethodName(), new CreditCardPaymentStrategy().getMethodName());
    }
    @Test public void testProcessPayment_fractionalAmount_returnsTrue() { assertTrue(strategy.processPayment(7.50)); }
    @Test public void testProcessPayment_negativeAmount_doesNotThrow() {
        // System should not crash on edge input — actual validation is in billing layer
        assertDoesNotThrow(() -> strategy.processPayment(-5.00));
    }
}

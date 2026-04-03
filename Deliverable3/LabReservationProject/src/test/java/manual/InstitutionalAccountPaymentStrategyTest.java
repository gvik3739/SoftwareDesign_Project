package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.InstitutionalAccountPaymentStrategy;
import strategy.PaymentStrategy;

/**
 * Tests for InstitutionalAccountPaymentStrategy — used for institutional billing.
 */
public class InstitutionalAccountPaymentStrategyTest {

    private InstitutionalAccountPaymentStrategy strategy;

    @BeforeEach
    public void setUp() { strategy = new InstitutionalAccountPaymentStrategy(); }

    @Test public void testGetMethodName_returnsInstitutionalAccount() { assertEquals("Institutional Account", strategy.getMethodName()); }
    @Test public void testProcessPayment_fifteenDollars_returnsTrue() { assertTrue(strategy.processPayment(15.00)); }
    @Test public void testProcessPayment_zeroDollars_returnsTrue() { assertTrue(strategy.processPayment(0.0)); }
    @Test public void testProcessPayment_largeFee_returnsTrue() { assertTrue(strategy.processPayment(1000.00)); }
    @Test public void testImplementsPaymentStrategy() { assertTrue(strategy instanceof PaymentStrategy); }
    @Test public void testGetMethodName_notEmpty() { assertFalse(strategy.getMethodName().isEmpty()); }
    @Test public void testGetMethodName_containsInstitutional() { assertTrue(strategy.getMethodName().contains("Institutional")); }
    @Test public void testProcessPayment_calledThreeTimes_alwaysSucceeds() {
        assertTrue(strategy.processPayment(15.00));
        assertTrue(strategy.processPayment(30.00));
        assertTrue(strategy.processPayment(45.00));
    }
    @Test public void testGetMethodName_multipleInstances_sameValue() {
        assertEquals(strategy.getMethodName(), new InstitutionalAccountPaymentStrategy().getMethodName());
    }
    @Test public void testProcessPayment_fractional_returnsTrue() { assertTrue(strategy.processPayment(22.50)); }
    @Test public void testProcessPayment_negativeAmount_doesNotThrow() {
        assertDoesNotThrow(() -> strategy.processPayment(-20.0));
    }
    @Test public void testGetMethodName_differentFromOtherStrategies() {
        assertNotEquals("Debit", strategy.getMethodName());
        assertNotEquals("Credit Card", strategy.getMethodName());
    }
}

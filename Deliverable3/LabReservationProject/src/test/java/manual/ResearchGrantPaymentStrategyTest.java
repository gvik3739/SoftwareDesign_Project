package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.ResearchGrantPaymentStrategy;
import strategy.PaymentStrategy;

/**
 * Tests for ResearchGrantPaymentStrategy — used by researchers billing to a grant.
 */
public class ResearchGrantPaymentStrategyTest {

    private ResearchGrantPaymentStrategy strategy;

    @BeforeEach
    public void setUp() { strategy = new ResearchGrantPaymentStrategy(); }

    @Test public void testGetMethodName_returnsResearchGrant() { assertEquals("Research Grant", strategy.getMethodName()); }
    @Test public void testProcessPayment_twentyDollars_returnsTrue() { assertTrue(strategy.processPayment(20.00)); }
    @Test public void testProcessPayment_zeroDollars_returnsTrue() { assertTrue(strategy.processPayment(0.0)); }
    @Test public void testProcessPayment_largeFee_returnsTrue() { assertTrue(strategy.processPayment(500.00)); }
    @Test public void testImplementsPaymentStrategy() { assertTrue(strategy instanceof PaymentStrategy); }
    @Test public void testGetMethodName_notEmpty() { assertFalse(strategy.getMethodName().isEmpty()); }
    @Test public void testGetMethodName_containsGrant() { assertTrue(strategy.getMethodName().contains("Grant")); }
    @Test public void testProcessPayment_researcherDeposit20_returnsTrue() {
        // Researcher deposit = $20 (1 hour rate)
        assertTrue(strategy.processPayment(20.00));
    }
    @Test public void testProcessPayment_calledRepeatedly_alwaysSucceeds() {
        for (int i = 1; i <= 3; i++) assertTrue(strategy.processPayment(i * 20.00));
    }
    @Test public void testGetMethodName_multipleInstances_sameValue() {
        assertEquals(strategy.getMethodName(), new ResearchGrantPaymentStrategy().getMethodName());
    }
    @Test public void testProcessPayment_fractional_returnsTrue() { assertTrue(strategy.processPayment(33.33)); }
    @Test public void testProcessPayment_negativeAmount_doesNotThrow() {
        assertDoesNotThrow(() -> strategy.processPayment(-10.0));
    }
}

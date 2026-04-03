package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.ResearchGrantPaymentStrategy;
import strategy.PaymentStrategy;

// AI-generated test file for ResearchGrantPaymentStrategy class
public class ResearchGrantPaymentStrategyTest {

    private ResearchGrantPaymentStrategy obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new ResearchGrantPaymentStrategy();
    }

    @Test
    public void testGetMethodName_returnsResearchGrant() {
        assertEquals("Research Grant", obj1.getMethodName());
    }

    @Test
    public void testProcessPayment_positiveAmount_returnsTrue() {
        assertTrue(obj1.processPayment(300.0));
    }

    @Test
    public void testProcessPayment_zeroAmount_returnsTrue() {
        assertTrue(obj1.processPayment(0.0));
    }

    @Test
    public void testProcessPayment_largeAmount_returnsTrue() {
        assertTrue(obj1.processPayment(50000.0));
    }

    @Test
    public void testImplementsPaymentStrategy() {
        assertTrue(obj1 instanceof PaymentStrategy);
    }

    @Test
    public void testGetMethodName_notDebit() {
        assertNotEquals("Debit", obj1.getMethodName());
    }

    @Test
    public void testGetMethodName_notEmpty() {
        assertFalse(obj1.getMethodName().isEmpty());
    }

    @Test
    public void testGetMethodName_containsGrant() {
        assertTrue(obj1.getMethodName().contains("Grant"));
    }

    @Test
    public void testGetMethodName_containsResearch() {
        assertTrue(obj1.getMethodName().contains("Research"));
    }

    @Test
    public void testProcessPayment_decimalAmount_returnsTrue() {
        assertTrue(obj1.processPayment(1234.56));
    }

    @Test
    public void testGetMethodName_twoInstances_sameValue() {
        ResearchGrantPaymentStrategy obj2 = new ResearchGrantPaymentStrategy();
        assertEquals(obj1.getMethodName(), obj2.getMethodName());
    }
}

package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.DebitPaymentStrategy;
import strategy.PaymentStrategy;

// AI-generated test file for DebitPaymentStrategy class
public class DebitPaymentStrategyTest {

    private DebitPaymentStrategy obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new DebitPaymentStrategy();
    }

    @Test
    public void testGetMethodName_returnsDebit() {
        assertEquals("Debit", obj1.getMethodName());
    }

    @Test
    public void testProcessPayment_positiveAmount_returnsTrue() {
        assertTrue(obj1.processPayment(75.0));
    }

    @Test
    public void testProcessPayment_zeroAmount_returnsTrue() {
        assertTrue(obj1.processPayment(0.0));
    }

    @Test
    public void testProcessPayment_largeAmount_returnsTrue() {
        assertTrue(obj1.processPayment(500.0));
    }

    @Test
    public void testImplementsPaymentStrategy() {
        assertTrue(obj1 instanceof PaymentStrategy);
    }

    @Test
    public void testGetMethodName_notCreditCard() {
        assertNotEquals("Credit Card", obj1.getMethodName());
    }

    @Test
    public void testGetMethodName_notEmpty() {
        assertFalse(obj1.getMethodName().isEmpty());
    }

    @Test
    public void testProcessPayment_decimalAmount_returnsTrue() {
        assertTrue(obj1.processPayment(12.50));
    }

    @Test
    public void testGetMethodName_twoInstances_sameValue() {
        DebitPaymentStrategy obj2 = new DebitPaymentStrategy();
        assertEquals(obj1.getMethodName(), obj2.getMethodName());
    }

    @Test
    public void testProcessPayment_multipleCalls_alwaysTrue() {
        assertTrue(obj1.processPayment(30.0));
        assertTrue(obj1.processPayment(45.0));
    }

    @Test
    public void testGetMethodName_exactValue() {
        assertEquals("Debit", obj1.getMethodName());
    }
}

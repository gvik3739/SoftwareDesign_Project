package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.CreditCardPaymentStrategy;
import strategy.PaymentStrategy;

// AI-generated test file for CreditCardPaymentStrategy class
public class CreditCardPaymentStrategyTest {

    private CreditCardPaymentStrategy obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new CreditCardPaymentStrategy();
    }

    @Test
    public void testGetMethodName_returnsCreditCard() {
        assertEquals("Credit Card", obj1.getMethodName());
    }

    @Test
    public void testProcessPayment_positiveAmount_returnsTrue() {
        assertTrue(obj1.processPayment(50.0));
    }

    @Test
    public void testProcessPayment_zeroAmount_returnsTrue() {
        assertTrue(obj1.processPayment(0.0));
    }

    @Test
    public void testProcessPayment_largeAmount_returnsTrue() {
        assertTrue(obj1.processPayment(1000.0));
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
    public void testProcessPayment_smallAmount_returnsTrue() {
        assertTrue(obj1.processPayment(1.0));
    }

    @Test
    public void testGetMethodName_twoInstances_sameValue() {
        CreditCardPaymentStrategy obj2 = new CreditCardPaymentStrategy();
        assertEquals(obj1.getMethodName(), obj2.getMethodName());
    }

    @Test
    public void testProcessPayment_multipleCalls_alwaysTrue() {
        assertTrue(obj1.processPayment(10.0));
        assertTrue(obj1.processPayment(20.0));
    }

    @Test
    public void testGetMethodName_containsCard() {
        assertTrue(obj1.getMethodName().contains("Card"));
    }
}

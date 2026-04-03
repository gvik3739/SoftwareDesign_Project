package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.InstitutionalAccountPaymentStrategy;
import strategy.PaymentStrategy;

// AI-generated test file for InstitutionalAccountPaymentStrategy class
public class InstitutionalAccountPaymentStrategyTest {

    private InstitutionalAccountPaymentStrategy obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new InstitutionalAccountPaymentStrategy();
    }

    @Test
    public void testGetMethodName_returnsInstitutionalAccount() {
        assertEquals("Institutional Account", obj1.getMethodName());
    }

    @Test
    public void testProcessPayment_positiveAmount_returnsTrue() {
        assertTrue(obj1.processPayment(200.0));
    }

    @Test
    public void testProcessPayment_zeroAmount_returnsTrue() {
        assertTrue(obj1.processPayment(0.0));
    }

    @Test
    public void testProcessPayment_largeAmount_returnsTrue() {
        assertTrue(obj1.processPayment(9999.0));
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
    public void testGetMethodName_notDebit() {
        assertNotEquals("Debit", obj1.getMethodName());
    }

    @Test
    public void testGetMethodName_notEmpty() {
        assertFalse(obj1.getMethodName().isEmpty());
    }

    @Test
    public void testGetMethodName_containsAccount() {
        assertTrue(obj1.getMethodName().contains("Account"));
    }

    @Test
    public void testProcessPayment_decimalAmount_returnsTrue() {
        assertTrue(obj1.processPayment(150.75));
    }

    @Test
    public void testGetMethodName_twoInstances_sameValue() {
        InstitutionalAccountPaymentStrategy obj2 = new InstitutionalAccountPaymentStrategy();
        assertEquals(obj1.getMethodName(), obj2.getMethodName());
    }
}

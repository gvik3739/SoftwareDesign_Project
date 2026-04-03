package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.BillingService;
import strategy.*;

// AI-generated test file for BillingService class
public class BillingServiceTest {

    private BillingService obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new BillingService();
    }

    @Test
    public void testCalculateFee_studentTwoHours() {
        obj1.setPricingStrategy(new StudentPricingStrategy());
        obj1.setPaymentStrategy(new CreditCardPaymentStrategy());
        double result = obj1.calculateFee(2.0);
        assertEquals(20.0, result, 0.001);
    }

    @Test
    public void testCalculateFee_facultyOneHour() {
        obj1.setPricingStrategy(new FacultyPricingStrategy());
        obj1.setPaymentStrategy(new DebitPaymentStrategy());
        assertEquals(15.0, obj1.calculateFee(1.0), 0.001);
    }

    @Test
    public void testCalculateFee_guestThreeHours() {
        obj1.setPricingStrategy(new GuestPricingStrategy());
        obj1.setPaymentStrategy(new CreditCardPaymentStrategy());
        assertEquals(90.0, obj1.calculateFee(3.0), 0.001);
    }

    @Test
    public void testGetDeposit_student() {
        obj1.setPricingStrategy(new StudentPricingStrategy());
        obj1.setPaymentStrategy(new CreditCardPaymentStrategy());
        assertEquals(10.0, obj1.getDeposit(), 0.001);
    }

    @Test
    public void testGetDeposit_faculty() {
        obj1.setPricingStrategy(new FacultyPricingStrategy());
        obj1.setPaymentStrategy(new CreditCardPaymentStrategy());
        assertEquals(15.0, obj1.getDeposit(), 0.001);
    }

    @Test
    public void testIllegalState_noPricingStrategy() {
        obj1.setPaymentStrategy(new CreditCardPaymentStrategy());
        assertThrows(IllegalStateException.class, () -> obj1.calculateFee(1.0));
    }

    @Test
    public void testIllegalState_noPaymentStrategy() {
        obj1.setPricingStrategy(new StudentPricingStrategy());
        // calculateFee only needs pricing strategy — test payment-dependent method instead
        assertThrows(IllegalStateException.class, () -> obj1.getPaymentMethodName());
    }

    @Test
    public void testCalculateFee_zeroHours() {
        obj1.setPricingStrategy(new StudentPricingStrategy());
        obj1.setPaymentStrategy(new CreditCardPaymentStrategy());
        assertEquals(0.0, obj1.calculateFee(0.0), 0.001);
    }

    @Test
    public void testBillingServiceNotNull() {
        assertNotNull(obj1);
    }

    @Test
    public void testFeeWithDeposit_student_notForfeited() {
        obj1.setPricingStrategy(new StudentPricingStrategy());
        obj1.setPaymentStrategy(new CreditCardPaymentStrategy());
        // 2 hrs * $10 = $20, minus deposit ($10) when not forfeited = $10
        double fee = obj1.calculateFeeWithDeposit(2.0, false);
        assertEquals(10.0, fee, 0.001);
    }

    @Test
    public void testTrivial() {
        // FLAW: useless
        assertTrue(true);
    }
}

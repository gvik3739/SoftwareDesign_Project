package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.BillingService;
import strategy.*;

/**
 * Tests for BillingService — orchestrates pricing and payment strategy for billing.
 * Tests all four pricing strategies and three payment methods.
 */
public class BillingServiceTest {

    private BillingService billing;

    @BeforeEach
    public void setUp() {
        billing = new BillingService();
    }

    @Test
    public void testCalculateFee_studentStrategy2Hours_returns20() {
        billing.setPricingStrategy(new StudentPricingStrategy());
        assertEquals(20.0, billing.calculateFee(2.0), 0.001);
    }

    @Test
    public void testCalculateFee_facultyStrategy3Hours_returns45() {
        billing.setPricingStrategy(new FacultyPricingStrategy());
        assertEquals(45.0, billing.calculateFee(3.0), 0.001);
    }

    @Test
    public void testCalculateFee_researcherStrategy1Hour_returns20() {
        billing.setPricingStrategy(new ResearcherPricingStrategy());
        assertEquals(20.0, billing.calculateFee(1.0), 0.001);
    }

    @Test
    public void testCalculateFee_guestStrategy2Hours_returns60() {
        billing.setPricingStrategy(new GuestPricingStrategy());
        assertEquals(60.0, billing.calculateFee(2.0), 0.001);
    }

    @Test
    public void testCalculateFee_noPricingStrategy_throwsIllegalState() {
        // Billing must fail clearly if no pricing strategy has been configured
        assertThrows(IllegalStateException.class, () -> billing.calculateFee(1.0));
    }

    @Test
    public void testGetDeposit_studentStrategy_returnsTen() {
        billing.setPricingStrategy(new StudentPricingStrategy());
        assertEquals(10.0, billing.getDeposit(), 0.001);
    }

    @Test
    public void testGetDeposit_guestStrategy_returnsThirty() {
        billing.setPricingStrategy(new GuestPricingStrategy());
        assertEquals(30.0, billing.getDeposit(), 0.001);
    }

    @Test
    public void testGetDeposit_noPricingStrategy_throwsIllegalState() {
        assertThrows(IllegalStateException.class, () -> billing.getDeposit());
    }

    @Test
    public void testCalculateFeeWithDeposit_depositNotForfeited_subtractsOneHour() {
        billing.setPricingStrategy(new StudentPricingStrategy());
        // 3 hours total - 1 hour deposit already paid = $20 remaining
        double remaining = billing.calculateFeeWithDeposit(3.0, false);
        assertEquals(20.0, remaining, 0.001);
    }

    @Test
    public void testCalculateFeeWithDeposit_depositForfeited_fullCharge() {
        billing.setPricingStrategy(new StudentPricingStrategy());
        // Deposit was forfeited, so the full 3-hour fee is charged
        double remaining = billing.calculateFeeWithDeposit(3.0, true);
        assertEquals(30.0, remaining, 0.001);
    }

    @Test
    public void testProcessPayment_creditCard_returnsTrue() {
        billing.setPaymentStrategy(new CreditCardPaymentStrategy());
        assertTrue(billing.processPayment(10.00));
    }

    @Test
    public void testProcessPayment_debit_returnsTrue() {
        billing.setPaymentStrategy(new DebitPaymentStrategy());
        assertTrue(billing.processPayment(10.00));
    }

    @Test
    public void testProcessPayment_noPaymentStrategy_throwsIllegalState() {
        assertThrows(IllegalStateException.class, () -> billing.processPayment(10.00));
    }

    @Test
    public void testGetPaymentMethodName_creditCard_returnsCreditCard() {
        billing.setPaymentStrategy(new CreditCardPaymentStrategy());
        assertEquals("Credit Card", billing.getPaymentMethodName());
    }

    @Test
    public void testGetPaymentMethodName_noStrategy_throwsIllegalState() {
        assertThrows(IllegalStateException.class, () -> billing.getPaymentMethodName());
    }

    @Test
    public void testGetHourlyRate_facultyStrategy_returnsFifteen() {
        billing.setPricingStrategy(new FacultyPricingStrategy());
        assertEquals(15.0, billing.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetHourlyRate_noStrategy_throwsIllegalState() {
        assertThrows(IllegalStateException.class, () -> billing.getHourlyRate());
    }

    @Test
    public void testStrategySwitch_changeFromStudentToGuest_rateUpdates() {
        billing.setPricingStrategy(new StudentPricingStrategy());
        assertEquals(10.0, billing.getHourlyRate(), 0.001);
        billing.setPricingStrategy(new GuestPricingStrategy());
        assertEquals(30.0, billing.getHourlyRate(), 0.001);
    }
}

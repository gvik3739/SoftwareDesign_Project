package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.GuestPricingStrategy;
import strategy.PricingStrategy;

/**
 * Tests for GuestPricingStrategy — $30/hour, the premium rate.
 */
public class GuestPricingStrategyTest {

    private GuestPricingStrategy strategy;

    @BeforeEach
    public void setUp() { strategy = new GuestPricingStrategy(); }

    @Test public void testGetRate_guest_returnsThirty() { assertEquals(30.0, strategy.getRate(), 0.001); }
    @Test public void testGetRate_isPositive() { assertTrue(strategy.getRate() > 0); }
    @Test public void testGetRate_highestRate_aboveAllOtherTypes() {
        assertTrue(strategy.getRate() > new strategy.StudentPricingStrategy().getRate());
        assertTrue(strategy.getRate() > new strategy.FacultyPricingStrategy().getRate());
        assertTrue(strategy.getRate() > new strategy.ResearcherPricingStrategy().getRate());
    }
    @Test public void testImplementsPricingStrategy() { assertTrue(strategy instanceof PricingStrategy); }
    @Test public void testFeeCalculation_oneHour_thirtyDollars() { assertEquals(30.0, 1.0 * strategy.getRate(), 0.001); }
    @Test public void testFeeCalculation_twoHours_sixtyDollars() { assertEquals(60.0, 2.0 * strategy.getRate(), 0.001); }
    @Test public void testFeeCalculation_halfHour_fifteenDollars() { assertEquals(15.0, 0.5 * strategy.getRate(), 0.001); }
    @Test public void testGetRate_multipleInstances_sameValue() { assertEquals(strategy.getRate(), new GuestPricingStrategy().getRate(), 0.001); }
    @Test public void testGetRate_exactlyThirty() { assertEquals(30.0, strategy.getRate(), 0.0001); }
    @Test public void testGetRate_tripleStudentRate() { assertEquals(3.0 * new strategy.StudentPricingStrategy().getRate(), strategy.getRate(), 0.001); }
    @Test public void testDepositForGuest_oneHourDeposit_thirtyDollars() { assertEquals(30.0, strategy.getRate(), 0.001); }
    @Test public void testFeeCalculation_fiveHourSession_oneFiftyDollars() { assertEquals(150.0, 5.0 * strategy.getRate(), 0.001); }
}

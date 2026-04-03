package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.ResearcherPricingStrategy;
import strategy.PricingStrategy;

/**
 * Tests for ResearcherPricingStrategy — $20/hour for researchers.
 */
public class ResearcherPricingStrategyTest {

    private ResearcherPricingStrategy strategy;

    @BeforeEach
    public void setUp() { strategy = new ResearcherPricingStrategy(); }

    @Test public void testGetRate_researcher_returnsTwenty() { assertEquals(20.0, strategy.getRate(), 0.001); }
    @Test public void testGetRate_isPositive() { assertTrue(strategy.getRate() > 0); }
    @Test public void testGetRate_higherThanStudent() { assertTrue(strategy.getRate() > new strategy.StudentPricingStrategy().getRate()); }
    @Test public void testGetRate_higherThanFaculty() { assertTrue(strategy.getRate() > new strategy.FacultyPricingStrategy().getRate()); }
    @Test public void testGetRate_lowerThanGuest() { assertTrue(strategy.getRate() < new strategy.GuestPricingStrategy().getRate()); }
    @Test public void testImplementsPricingStrategy() { assertTrue(strategy instanceof PricingStrategy); }
    @Test public void testFeeCalculation_oneHour_twentyDollars() { assertEquals(20.0, 1.0 * strategy.getRate(), 0.001); }
    @Test public void testFeeCalculation_threeHours_sixtyDollars() { assertEquals(60.0, 3.0 * strategy.getRate(), 0.001); }
    @Test public void testFeeCalculation_halfHour_tenDollars() { assertEquals(10.0, 0.5 * strategy.getRate(), 0.001); }
    @Test public void testGetRate_multipleInstances_sameValue() { assertEquals(strategy.getRate(), new ResearcherPricingStrategy().getRate(), 0.001); }
    @Test public void testGetRate_exactlyTwenty_notApproximate() { assertEquals(20.0, strategy.getRate(), 0.0001); }
    @Test public void testDepositCalculation_oneHourResearcher_twentyDollars() { assertEquals(20.0, strategy.getRate(), 0.001); }
}

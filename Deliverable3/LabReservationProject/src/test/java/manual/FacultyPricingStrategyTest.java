package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.FacultyPricingStrategy;
import strategy.PricingStrategy;

/**
 * Tests for FacultyPricingStrategy — $15/hour for faculty members.
 */
public class FacultyPricingStrategyTest {

    private FacultyPricingStrategy strategy;

    @BeforeEach
    public void setUp() { strategy = new FacultyPricingStrategy(); }

    @Test public void testGetRate_faculty_returnsFifteen() { assertEquals(15.0, strategy.getRate(), 0.001); }
    @Test public void testGetRate_isPositive() { assertTrue(strategy.getRate() > 0); }
    @Test public void testGetRate_higherThanStudent() { assertTrue(strategy.getRate() > new strategy.StudentPricingStrategy().getRate()); }
    @Test public void testGetRate_lowerThanResearcher() { assertTrue(strategy.getRate() < new strategy.ResearcherPricingStrategy().getRate()); }
    @Test public void testGetRate_lowerThanGuest() { assertTrue(strategy.getRate() < new strategy.GuestPricingStrategy().getRate()); }
    @Test public void testImplementsPricingStrategy() { assertTrue(strategy instanceof PricingStrategy); }
    @Test public void testFeeCalculation_twoHours_thirtyDollars() { assertEquals(30.0, 2.0 * strategy.getRate(), 0.001); }
    @Test public void testFeeCalculation_oneHour_equalToRate() { assertEquals(15.0, 1.0 * strategy.getRate(), 0.001); }
    @Test public void testFeeCalculation_halfHour_sevenFifty() { assertEquals(7.5, 0.5 * strategy.getRate(), 0.001); }
    @Test public void testGetRate_multipleInstances_sameValue() { assertEquals(strategy.getRate(), new FacultyPricingStrategy().getRate(), 0.001); }
    @Test public void testGetRate_exactlyFifteen_notApproximate() { assertEquals(15.0, strategy.getRate(), 0.0001); }
    @Test public void testDepositCalculation_oneHourFaculty_fifteenDollars() {
        // Deposit = 1 hour's rate
        assertEquals(15.0, strategy.getRate(), 0.001);
    }
}

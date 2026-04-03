package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.StudentPricingStrategy;
import strategy.PricingStrategy;

/**
 * Tests for StudentPricingStrategy — $10/hour for students.
 */
public class StudentPricingStrategyTest {

    private StudentPricingStrategy strategy;

    @BeforeEach
    public void setUp() {
        strategy = new StudentPricingStrategy();
    }

    @Test
    public void testGetRate_student_returnsTen() {
        assertEquals(10.0, strategy.getRate(), 0.001);
    }

    @Test
    public void testGetRate_isPositive() {
        assertTrue(strategy.getRate() > 0, "Student hourly rate must be positive");
    }

    @Test
    public void testGetRate_lessThanFacultyRate() {
        assertTrue(strategy.getRate() < new strategy.FacultyPricingStrategy().getRate());
    }

    @Test
    public void testGetRate_lessThanResearcherRate() {
        assertTrue(strategy.getRate() < new strategy.ResearcherPricingStrategy().getRate());
    }

    @Test
    public void testGetRate_lessThanGuestRate() {
        assertTrue(strategy.getRate() < new strategy.GuestPricingStrategy().getRate());
    }

    @Test
    public void testImplementsPricingStrategy_interfaceContract() {
        assertTrue(strategy instanceof PricingStrategy);
    }

    @Test
    public void testFeeCalculation_oneHour_equalToRate() {
        double hours = 1.0;
        double fee   = hours * strategy.getRate();
        assertEquals(10.0, fee, 0.001);
    }

    @Test
    public void testFeeCalculation_threeHours_thirtyDollars() {
        double fee = 3.0 * strategy.getRate();
        assertEquals(30.0, fee, 0.001);
    }

    @Test
    public void testFeeCalculation_halfHour_fiveDollars() {
        double fee = 0.5 * strategy.getRate();
        assertEquals(5.0, fee, 0.001);
    }

    @Test
    public void testGetRate_multipleInstances_sameValue() {
        StudentPricingStrategy s2 = new StudentPricingStrategy();
        assertEquals(strategy.getRate(), s2.getRate(), 0.001);
    }

    @Test
    public void testGetRate_lowestAmongAllUserTypes() {
        // Students get the cheapest rate in the system
        double studentRate   = strategy.getRate();
        double facultyRate   = new strategy.FacultyPricingStrategy().getRate();
        double researcherRate = new strategy.ResearcherPricingStrategy().getRate();
        double guestRate     = new strategy.GuestPricingStrategy().getRate();

        assertTrue(studentRate <= facultyRate);
        assertTrue(studentRate <= researcherRate);
        assertTrue(studentRate <= guestRate);
    }

    @Test
    public void testGetRate_exactlyTen_notApproximate() {
        // Ensure no floating-point drift — rate must be exactly $10.00
        assertEquals(10.0, strategy.getRate(), 0.0001);
    }
}

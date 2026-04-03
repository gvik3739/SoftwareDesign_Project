package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.FacultyPricingStrategy;
import strategy.PricingStrategy;

// AI-generated test file for FacultyPricingStrategy class
public class FacultyPricingStrategyTest {

    private FacultyPricingStrategy obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new FacultyPricingStrategy();
    }

    @Test
    public void testGetRate_returnsFifteen() {
        assertEquals(15.0, obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_notZero() {
        assertNotEquals(0.0, obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_greaterThanStudentRate() {
        // Faculty rate (15.0) is greater than student rate (10.0)
        assertTrue(obj1.getRate() > 10.0);
    }

    @Test
    public void testGetRate_lessThanGuestRate() {
        // Faculty rate (15.0) is less than guest rate (30.0)
        assertTrue(obj1.getRate() < 30.0);
    }

    @Test
    public void testImplementsPricingStrategy() {
        assertTrue(obj1 instanceof PricingStrategy);
    }

    @Test
    public void testGetRate_consistentAcrossCalls() {
        double first = obj1.getRate();
        double second = obj1.getRate();
        assertEquals(first, second, 0.001);
    }

    @Test
    public void testGetRate_twoInstances_sameValue() {
        FacultyPricingStrategy obj2 = new FacultyPricingStrategy();
        assertEquals(obj1.getRate(), obj2.getRate(), 0.001);
    }

    @Test
    public void testGetRate_positive() {
        assertTrue(obj1.getRate() > 0);
    }

    @Test
    public void testGetRate_notStudentRate() {
        assertNotEquals(10.0, obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_notResearcherRate() {
        assertNotEquals(20.0, obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_exactValue() {
        assertEquals(15.0, obj1.getRate());
    }
}

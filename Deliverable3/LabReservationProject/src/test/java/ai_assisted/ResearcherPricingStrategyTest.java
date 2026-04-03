package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.ResearcherPricingStrategy;
import strategy.PricingStrategy;

// AI-generated test file for ResearcherPricingStrategy class
public class ResearcherPricingStrategyTest {

    private ResearcherPricingStrategy obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new ResearcherPricingStrategy();
    }

    @Test
    public void testGetRate_returnsTwenty() {
        assertEquals(20.0, obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_greaterThanFacultyRate() {
        assertTrue(obj1.getRate() > 15.0);
    }

    @Test
    public void testGetRate_greaterThanStudentRate() {
        assertTrue(obj1.getRate() > 10.0);
    }

    @Test
    public void testGetRate_lessThanGuestRate() {
        assertTrue(obj1.getRate() < 30.0);
    }

    @Test
    public void testImplementsPricingStrategy() {
        assertTrue(obj1 instanceof PricingStrategy);
    }

    @Test
    public void testGetRate_positive() {
        assertTrue(obj1.getRate() > 0);
    }

    @Test
    public void testGetRate_consistentAcrossCalls() {
        assertEquals(obj1.getRate(), obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_notFacultyRate() {
        assertNotEquals(15.0, obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_notStudentRate() {
        assertNotEquals(10.0, obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_exactValue() {
        assertEquals(20.0, obj1.getRate());
    }

    @Test
    public void testGetRate_twoInstances_sameValue() {
        ResearcherPricingStrategy obj2 = new ResearcherPricingStrategy();
        assertEquals(obj1.getRate(), obj2.getRate(), 0.001);
    }
}

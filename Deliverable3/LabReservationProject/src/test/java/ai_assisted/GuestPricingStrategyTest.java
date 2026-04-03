package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import strategy.GuestPricingStrategy;
import strategy.PricingStrategy;

// AI-generated test file for GuestPricingStrategy class
public class GuestPricingStrategyTest {

    private GuestPricingStrategy obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new GuestPricingStrategy();
    }

    @Test
    public void testGetRate_returnsThirty() {
        assertEquals(30.0, obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_highestRate() {
        // Guest rate (30.0) is the highest of all user types
        assertTrue(obj1.getRate() > 20.0);
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
    public void testGetRate_notResearcherRate() {
        assertNotEquals(20.0, obj1.getRate(), 0.001);
    }

    @Test
    public void testGetRate_twoInstances_sameValue() {
        GuestPricingStrategy obj2 = new GuestPricingStrategy();
        assertEquals(obj1.getRate(), obj2.getRate(), 0.001);
    }
}

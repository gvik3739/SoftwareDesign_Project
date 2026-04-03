package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Researcher;

// AI-generated test file for Researcher class
public class ResearcherTest {

    private Researcher obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new Researcher("Darius Tehrani", "dtehrani@yorku.ca", "Research@123", "111222333", true);
    }

    @Test
    public void testGetUserType() {
        assertEquals("Researcher", obj1.getUserType());
    }

    @Test
    public void testGetHourlyRate() {
        assertEquals(20.0, obj1.getHourlyRate(), 0.001);
    }

    @Test
    public void testIsApproved() {
        assertTrue(obj1.isApproved());
    }

    @Test
    public void testGetName() {
        assertEquals("Darius Tehrani", obj1.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("dtehrani@yorku.ca", obj1.getEmail());
    }

    @Test
    public void testGetIdNumber() {
        assertEquals("111222333", obj1.getIdNumber());
    }

    @Test
    public void testConstructorUnapproved() {
        Researcher obj2 = new Researcher("Alice", "a@yorku.ca", "Test@123", "999999999", false);
        assertFalse(obj2.isApproved());
    }

    @Test
    public void testHourlyRateNotNull() {
        assertNotNull(obj1.getHourlyRate());
    }

    @Test
    public void testUserType_notGuest() {
        assertNotEquals("Guest", obj1.getUserType());
    }

    @Test
    public void testTrivialAssertion() {
        // FLAW: meaningless test
        assertTrue(1 + 1 == 2);
    }

    @Test
    public void testGetPassword() {
        assertEquals("Research@123", obj1.getPassword());
    }
}

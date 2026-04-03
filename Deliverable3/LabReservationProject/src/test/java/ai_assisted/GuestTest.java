package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Guest;

// AI-generated test file for Guest class
public class GuestTest {

    private Guest obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new Guest("Emily Brown", "ebrown@yorku.ca", "Guest@123", "444555666");
    }

    @Test
    public void testGetUserType() {
        assertEquals("Guest", obj1.getUserType());
    }

    @Test
    public void testGetHourlyRate() {
        assertEquals(30.0, obj1.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetName() {
        assertEquals("Emily Brown", obj1.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("ebrown@yorku.ca", obj1.getEmail());
    }

    @Test
    public void testGetIdNumber() {
        assertEquals("444555666", obj1.getIdNumber());
    }

    @Test
    public void testGetPassword() {
        assertEquals("Guest@123", obj1.getPassword());
    }

    @Test
    public void testHourlyRate_greaterThanStudent() {
        // FLAW: hard-coded comparison rather than using Student class
        assertTrue(obj1.getHourlyRate() > 10.0);
    }

    @Test
    public void testUserType_notLabManager() {
        assertNotEquals("LabManager", obj1.getUserType());
    }

    @Test
    public void testGuestIsNotNull() {
        assertNotNull(obj1);
    }

    @Test
    public void testTrivialCheck() {
        // FLAW: useless
        assertEquals("Guest", "Guest");
    }

    @Test
    public void testHourlyRate_isPositive() {
        assertTrue(obj1.getHourlyRate() > 0);
    }
}

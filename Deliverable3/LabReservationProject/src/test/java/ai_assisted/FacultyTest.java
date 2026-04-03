package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Faculty;

// AI-generated test file for Faculty class
public class FacultyTest {

    private Faculty obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new Faculty("Priya Sharma", "psharma@yorku.ca", "Faculty@123", "987654321", true);
    }

    @Test
    public void testGetUserType() {
        assertEquals("Faculty", obj1.getUserType());
    }

    @Test
    public void testGetHourlyRate() {
        assertEquals(15.0, obj1.getHourlyRate(), 0.001);
    }

    @Test
    public void testIsApproved_true() {
        assertTrue(obj1.isApproved());
    }

    @Test
    public void testIsApproved_false() {
        Faculty obj2 = new Faculty("Bob", "bob@yorku.ca", "Test@123", "111111111", false);
        assertFalse(obj2.isApproved());
    }

    @Test
    public void testGetName() {
        assertEquals("Priya Sharma", obj1.getName());
    }

    @Test
    public void testGetEmail() {
        // FLAW: redundant assertion — checks the same value twice
        assertEquals("psharma@yorku.ca", obj1.getEmail());
        assertEquals("psharma@yorku.ca", obj1.getEmail());
    }

    @Test
    public void testGetPassword() {
        assertEquals("Faculty@123", obj1.getPassword());
    }

    @Test
    public void testGetIdNumber() {
        assertEquals("987654321", obj1.getIdNumber());
    }

    @Test
    public void testUserTypeNotStudent() {
        assertNotEquals("Student", obj1.getUserType());
    }

    @Test
    public void testHourlyRate_constant() {
        // FLAW: checks only happy path, doesn't test that rate is independent of approval
        assertEquals(15.0, obj1.getHourlyRate(), 0.001);
    }

    @Test
    public void testTrivialCheck() {
        // FLAW: useless assertion
        assertEquals(true, true);
    }
}

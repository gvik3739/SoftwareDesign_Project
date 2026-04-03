package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import factory.UserFactory;
import model.*;

/**
 * Tests for UserFactory — the factory that creates all User subtypes.
 * Tests type dispatch, hourly rate correctness, and error handling.
 */
public class UserFactoryTest {

    private UserFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new UserFactory();
    }

    @Test
    public void testCreateUser_student_returnsStudentInstance() {
        User user = factory.createUser("student", "James Carter", "jcarter@yorku.ca", "Strong@123", "123456789", true);
        assertTrue(user instanceof Student);
    }

    @Test
    public void testCreateUser_faculty_returnsFacultyInstance() {
        User user = factory.createUser("faculty", "Priya Sharma", "psharma@yorku.ca", "Faculty@123", "987654321", true);
        assertTrue(user instanceof Faculty);
    }

    @Test
    public void testCreateUser_researcher_returnsResearcherInstance() {
        User user = factory.createUser("researcher", "Darius Tehrani", "dtehrani@yorku.ca", "Research@123", "111222333", true);
        assertTrue(user instanceof Researcher);
    }

    @Test
    public void testCreateUser_guest_returnsGuestInstance() {
        User user = factory.createUser("guest", "Emily Brown", "ebrown@yorku.ca", "Guest@123", "444555666", true);
        assertTrue(user instanceof Guest);
    }

    @Test
    public void testCreateUser_labmanager_returnsLabManagerInstance() {
        User user = factory.createUser("labmanager", "Arjun Patel", "apatel@yorku.ca", "Manager@123", "LM001", true);
        assertTrue(user instanceof LabManager);
    }

    @Test
    public void testCreateUser_unknownType_throwsIllegalArgument() {
        // Unsupported types should fail fast with a clear error message
        assertThrows(IllegalArgumentException.class, () ->
            factory.createUser("admin", "X", "x@y.ca", "P@1", "000", true)
        );
    }

    @Test
    public void testCreateUser_studentHourlyRate_returnsTen() {
        User user = factory.createUser("student", "X", "x@yorku.ca", "P@1", "111", true);
        assertEquals(10.0, user.getHourlyRate(), 0.001);
    }

    @Test
    public void testCreateUser_facultyHourlyRate_returnsFifteen() {
        User user = factory.createUser("faculty", "X", "x@yorku.ca", "P@1", "111", true);
        assertEquals(15.0, user.getHourlyRate(), 0.001);
    }

    @Test
    public void testCreateUser_researcherHourlyRate_returnsTwenty() {
        User user = factory.createUser("researcher", "X", "x@yorku.ca", "P@1", "111", true);
        assertEquals(20.0, user.getHourlyRate(), 0.001);
    }

    @Test
    public void testCreateUser_guestHourlyRate_returnsThirty() {
        User user = factory.createUser("guest", "X", "x@yorku.ca", "P@1", "111", true);
        assertEquals(30.0, user.getHourlyRate(), 0.001);
    }

    @Test
    public void testCreateUser_caseInsensitiveType_createsStudentFromUppercase() {
        // User type lookup is case-insensitive per the switch .toLowerCase()
        User user = factory.createUser("Student", "X", "x@y.ca", "P@1", "000", true);
        assertTrue(user instanceof Student);
    }

    @Test
    public void testCreateLabManager_validParams_returnsLabManager() {
        LabManager lm = factory.createLabManager("Arjun Patel", "apatel@yorku.ca", "Manager@123", "LM001");
        assertNotNull(lm);
        assertEquals("LM001", lm.getManagerId());
        assertEquals("LabManager", lm.getUserType());
    }
}

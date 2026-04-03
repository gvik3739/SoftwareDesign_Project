package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.RegistrationService;
import model.*;

/**
 * Tests for RegistrationService — validates passwords and creates User objects.
 * Uses real user data from users.csv to test the happy path.
 */
public class RegistrationServiceTest {

    private RegistrationService service;

    @BeforeEach
    public void setUp() {
        service = new RegistrationService();
    }

    @Test
    public void testRegisterUser_validStudent_returnsStudentObject() {
        // Real data from users.csv: James Carter
        User user = service.registerUser("student", "James Carter", "jcarter@yorku.ca", "Strong@123", "123456789", true);
        assertNotNull(user);
        assertTrue(user instanceof Student);
    }

    @Test
    public void testRegisterUser_validFaculty_returnsFacultyObject() {
        User user = service.registerUser("faculty", "Priya Sharma", "psharma@yorku.ca", "Faculty@123", "987654321", true);
        assertTrue(user instanceof Faculty);
    }

    @Test
    public void testRegisterUser_validResearcher_returnsResearcherObject() {
        User user = service.registerUser("researcher", "Darius Tehrani", "dtehrani@yorku.ca", "Research@123", "111222333", true);
        assertTrue(user instanceof Researcher);
    }

    @Test
    public void testRegisterUser_validGuest_returnsGuestObject() {
        User user = service.registerUser("guest", "Emily Brown", "ebrown@yorku.ca", "Guest@123", "444555666", true);
        assertTrue(user instanceof Guest);
    }

    @Test
    public void testRegisterUser_weakPasswordNoUppercase_throwsIllegalArgument() {
        // Password policy requires at least one uppercase letter
        assertThrows(IllegalArgumentException.class, () ->
            service.registerUser("student", "Test", "t@yorku.ca", "weakpass1!", "000000001", true)
        );
    }

    @Test
    public void testRegisterUser_weakPasswordNoLowercase_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () ->
            service.registerUser("student", "Test", "t@yorku.ca", "NOLOW3R@", "000000002", true)
        );
    }

    @Test
    public void testRegisterUser_weakPasswordNoDigit_throwsIllegalArgument() {
        // Must contain at least one digit
        assertThrows(IllegalArgumentException.class, () ->
            service.registerUser("student", "Test", "t@yorku.ca", "NoDigit@!", "000000003", true)
        );
    }

    @Test
    public void testRegisterUser_weakPasswordNoSymbol_throwsIllegalArgument() {
        // Must contain at least one special character
        assertThrows(IllegalArgumentException.class, () ->
            service.registerUser("student", "Test", "t@yorku.ca", "NoSymbol1", "000000004", true)
        );
    }

    @Test
    public void testRegisterUser_emptyPassword_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () ->
            service.registerUser("student", "Test", "t@yorku.ca", "", "000000005", true)
        );
    }

    @Test
    public void testRegisterUser_validPassword_nameStoredCorrectly() {
        User user = service.registerUser("student", "James Carter", "jcarter@yorku.ca", "Strong@123", "123456789", true);
        assertEquals("James Carter", user.getName());
    }

    @Test
    public void testRegisterUser_validPassword_emailStoredCorrectly() {
        User user = service.registerUser("student", "James Carter", "jcarter@yorku.ca", "Strong@123", "123456789", true);
        assertEquals("jcarter@yorku.ca", user.getEmail());
    }

    @Test
    public void testRegisterUser_validPassword_idNumberStoredCorrectly() {
        User user = service.registerUser("student", "James Carter", "jcarter@yorku.ca", "Strong@123", "123456789", true);
        assertEquals("123456789", user.getIdNumber());
    }

    @Test
    public void testRegisterUser_invalidType_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () ->
            service.registerUser("admin", "X", "x@y.ca", "Admin@123", "000", true)
        );
    }
}

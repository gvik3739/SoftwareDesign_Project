package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.RegistrationService;
import model.User;

// AI-generated test file for RegistrationService class
public class RegistrationServiceTest {

    private RegistrationService obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new RegistrationService();
    }

    @Test
    public void testRegister_student() {
        User result = obj1.registerUser("student", "Test User", "test@yorku.ca", "Strong@123", "999999999", false);
        assertNotNull(result);
    }

    @Test
    public void testRegister_faculty() {
        User result = obj1.registerUser("faculty", "Test Faculty", "fac@yorku.ca", "Faculty@123", "888888888", true);
        assertNotNull(result);
    }

    @Test
    public void testRegister_weakPassword_noUppercase() {
        assertThrows(Exception.class, () ->
            obj1.registerUser("student", "Test", "t@yorku.ca", "weak@123", "777777777", false));
    }

    @Test
    public void testRegister_weakPassword_noDigit() {
        assertThrows(Exception.class, () ->
            obj1.registerUser("student", "Test", "t2@yorku.ca", "WeakPass!", "666666666", false));
    }

    @Test
    public void testRegister_weakPassword_noSymbol() {
        assertThrows(Exception.class, () ->
            obj1.registerUser("student", "Test", "t3@yorku.ca", "WeakPass1", "555555555", false));
    }

    @Test
    public void testRegister_getUserType_student() {
        User result = obj1.registerUser("student", "Alice", "alice@yorku.ca", "Alice@123", "444444444", false);
        // FLAW: only checks not null, doesn't verify getUserType() == "Student"
        assertNotNull(result);
    }

    @Test
    public void testRegister_researcher() {
        User result = obj1.registerUser("researcher", "Res User", "res@yorku.ca", "Research@1", "333333333", true);
        assertNotNull(result);
    }

    @Test
    public void testRegister_guest() {
        User result = obj1.registerUser("guest", "Guest User", "guest@yorku.ca", "Guest@123", "222222222", false);
        assertNotNull(result);
    }

    @Test
    public void testServiceNotNull() {
        assertNotNull(obj1);
    }

    @Test
    public void testTrivial() {
        // FLAW: useless
        assertEquals(true, true);
    }
}

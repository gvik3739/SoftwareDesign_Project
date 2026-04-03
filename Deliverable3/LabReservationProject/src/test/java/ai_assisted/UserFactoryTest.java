package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import factory.UserFactory;
import model.User;

// AI-generated test file for UserFactory
public class UserFactoryTest {

    private UserFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new UserFactory();
    }

    @Test
    public void testCreateUser_student() {
        User result = factory.createUser("student", "Alice", "alice@yorku.ca", "Pass@123", "111", false);
        assertNotNull(result);
        assertEquals("Student", result.getUserType());
    }

    @Test
    public void testCreateUser_faculty() {
        User result = factory.createUser("faculty", "Bob", "bob@yorku.ca", "Pass@123", "222", true);
        assertNotNull(result);
    }

    @Test
    public void testCreateUser_researcher() {
        User result = factory.createUser("researcher", "Carol", "carol@yorku.ca", "Pass@123", "333", true);
        assertNotNull(result);
    }

    @Test
    public void testCreateUser_guest() {
        User result = factory.createUser("guest", "Dave", "dave@yorku.ca", "Pass@123", "444", false);
        assertNotNull(result);
    }

    @Test
    public void testCreateUser_unknownType() {
        assertThrows(Exception.class, () ->
            factory.createUser("unknown", "Eve", "eve@yorku.ca", "Pass@123", "555", false));
    }

    @Test
    public void testCreateUser_caseInsensitive() {
        User result = factory.createUser("STUDENT", "Frank", "frank@yorku.ca", "Pass@123", "666", false);
        assertNotNull(result);
    }

    @Test
    public void testCreateUser_student_rate() {
        User result = factory.createUser("student", "Alice", "alice@yorku.ca", "Pass@123", "111", false);
        assertEquals(10.0, result.getHourlyRate(), 0.001);
    }

    @Test
    public void testCreateUser_guest_rate() {
        User result = factory.createUser("guest", "Dave", "dave@yorku.ca", "Pass@123", "444", false);
        assertEquals(30.0, result.getHourlyRate(), 0.001);
    }

    @Test
    public void testCreateLabManager() {
        UserFactory uf = new UserFactory();
        User result = uf.createLabManager("Mgr", "mgr@yorku.ca", "Mgr@123", "LM999");
        assertNotNull(result);
        assertEquals("LabManager", result.getUserType());
    }

    @Test
    public void testTrivial() {
        assertTrue(true);
    }
}

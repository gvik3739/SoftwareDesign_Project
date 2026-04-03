package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import data.StubUser;
import model.User;

/**
 * Tests for StubUser — the lightweight placeholder used when loading reservations from CSV.
 * Constructor: super(userId, "", "", userId)
 *   → name = userId, email = "", password = "", idNumber = userId
 */
public class StubUserTest {

    private StubUser stub;

    @BeforeEach
    public void setUp() {
        stub = new StubUser("123456789");
    }

    @Test
    public void testGetIdNumber_stub_returnsProvidedId() {
        assertEquals("123456789", stub.getIdNumber());
    }

    @Test
    public void testGetUserType_stub_returnsUnknown() {
        assertEquals("Unknown", stub.getUserType());
    }

    @Test
    public void testGetHourlyRate_stub_returnsZero() {
        assertEquals(0.0, stub.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetName_stub_returnsUserId() {
        // StubUser passes userId as the name field: super(userId, "", "", userId)
        assertEquals("123456789", stub.getName());
    }

    @Test
    public void testGetEmail_stub_isEmpty() {
        // Email is passed as empty string
        assertEquals("", stub.getEmail());
    }

    @Test
    public void testGetPassword_stub_isEmpty() {
        // Password is passed as empty string: super(userId, "", "", userId)
        assertEquals("", stub.getPassword());
    }

    @Test
    public void testStubIsInstanceOfUser() {
        assertTrue(stub instanceof User);
    }

    @Test
    public void testStubUserId_labManagerId_preservedCorrectly() {
        StubUser labStub = new StubUser("LM001");
        assertEquals("LM001", labStub.getIdNumber());
    }

    @Test
    public void testMultipleStubs_differentIds_independent() {
        StubUser s2 = new StubUser("987654321");
        assertNotEquals(stub.getIdNumber(), s2.getIdNumber());
    }

    @Test
    public void testHourlyRate_alwaysZero_forAllInstances() {
        StubUser s2 = new StubUser("111222333");
        assertEquals(0.0, s2.getHourlyRate(), 0.001);
    }

    @Test
    public void testUserType_alwaysUnknown_forAllInstances() {
        StubUser s2 = new StubUser("444555666");
        assertEquals("Unknown", s2.getUserType());
    }
}

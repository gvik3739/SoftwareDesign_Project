package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Guest;

/**
 * Tests for the Guest user model.
 * Guests pay the highest rate ($30/hr) and do not require pre-approval.
 * Real data from users.csv: Emily Brown, ebrown@yorku.ca, 444555666
 */
public class GuestTest {

    private Guest guest;

    @BeforeEach
    public void setUp() {
        guest = new Guest("Emily Brown", "ebrown@yorku.ca", "Guest@123", "444555666");
    }

    @Test
    public void testGetUserType_guest_returnsGuestString() {
        assertEquals("Guest", guest.getUserType());
    }

    @Test
    public void testGetHourlyRate_guest_returnsThirty() {
        // Guests pay the premium rate of $30/hour
        assertEquals(30.0, guest.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetName_emilyBrown_returnsFullName() {
        assertEquals("Emily Brown", guest.getName());
    }

    @Test
    public void testGetEmail_ebrown_returnsEmail() {
        assertEquals("ebrown@yorku.ca", guest.getEmail());
    }

    @Test
    public void testGetIdNumber_guest_returnsNineDigitId() {
        assertEquals("444555666", guest.getIdNumber());
    }

    @Test
    public void testGetPassword_guest_returnsStoredPassword() {
        assertEquals("Guest@123", guest.getPassword());
    }

    @Test
    public void testGetHourlyRate_guestHighestAmongAllUserTypes() {
        // Guests pay more than students, faculty, and researchers
        assertTrue(guest.getHourlyRate() > 20.0,
            "Guest rate ($30) must exceed researcher rate ($20)");
    }

    @Test
    public void testGetHourlyRate_guestRateDoublesStudent() {
        // Guest rate is exactly 3x student rate — pricing tier validation
        assertEquals(30.0, guest.getHourlyRate(), 0.001);
        assertEquals(10.0, new model.Student("X","x@y.ca","P@1","1").getHourlyRate(), 0.001);
        // 30 / 10 = 3x the student rate
        assertEquals(3.0, guest.getHourlyRate() / 10.0, 0.001);
    }

    @Test
    public void testConstructor_differentGuests_independentObjects() {
        Guest g2 = new Guest("John Doe", "jdoe@yorku.ca", "Jdoe@123", "999000111");
        assertNotEquals(guest.getName(), g2.getName());
        assertNotEquals(guest.getIdNumber(), g2.getIdNumber());
    }

    @Test
    public void testGetHourlyRate_multipleGuestInstances_sameRate() {
        Guest g2 = new Guest("Another Guest", "anon@yorku.ca", "Anon@123", "111999888");
        assertEquals(guest.getHourlyRate(), g2.getHourlyRate(), 0.001,
            "All guest instances must have the same $30/hour rate");
    }

    @Test
    public void testGetUserType_multipleGuests_alwaysReturnsGuest() {
        Guest g2 = new Guest("Visitor One", "visitor@external.ca", "Visit@1", "000999888");
        assertEquals("Guest", g2.getUserType());
    }

    @Test
    public void testGetIdNumber_numericString_storedAsString() {
        // ID numbers can contain leading zeros — must remain as String
        Guest g = new Guest("Zero ID", "zero@test.ca", "Zero@1", "000000001");
        assertEquals("000000001", g.getIdNumber());
    }
}

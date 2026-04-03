package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Faculty;

/**
 * Tests for the Faculty user model.
 * Faculty pay $15/hr and have an approval flag for lab access.
 * Real data from users.csv: Priya Sharma, psharma@yorku.ca, 987654321
 */
public class FacultyTest {

    private Faculty approvedFaculty;
    private Faculty unapprovedFaculty;

    @BeforeEach
    public void setUp() {
        approvedFaculty   = new Faculty("Priya Sharma",   "psharma@yorku.ca",  "Faculty@123", "987654321", true);
        unapprovedFaculty = new Faculty("Pending Member", "pending@yorku.ca",  "Pending@123", "000111999", false);
    }

    @Test
    public void testGetUserType_faculty_returnsFacultyString() {
        assertEquals("Faculty", approvedFaculty.getUserType());
    }

    @Test
    public void testGetHourlyRate_faculty_returnsFifteen() {
        // Faculty are charged $15/hour per billing policy
        assertEquals(15.0, approvedFaculty.getHourlyRate(), 0.001);
    }

    @Test
    public void testIsApproved_approvedFaculty_returnsTrue() {
        assertTrue(approvedFaculty.isApproved(),
            "Faculty loaded from CSV with approved=true should pass approval check");
    }

    @Test
    public void testIsApproved_unapprovedFaculty_returnsFalse() {
        // Lab managers can set faculty to unapproved — access should be denied
        assertFalse(unapprovedFaculty.isApproved());
    }

    @Test
    public void testGetName_psharma_returnsFullName() {
        assertEquals("Priya Sharma", approvedFaculty.getName());
    }

    @Test
    public void testGetEmail_psharma_returnsYorkEmail() {
        assertEquals("psharma@yorku.ca", approvedFaculty.getEmail());
    }

    @Test
    public void testGetIdNumber_faculty_returns9DigitId() {
        assertEquals("987654321", approvedFaculty.getIdNumber());
    }

    @Test
    public void testGetPassword_faculty_returnsStoredPassword() {
        assertEquals("Faculty@123", approvedFaculty.getPassword());
    }

    @Test
    public void testGetHourlyRate_facultyHigherThanStudent() {
        // Business rule: Faculty ($15) > Student ($10)
        assertTrue(approvedFaculty.getHourlyRate() > 10.0);
    }

    @Test
    public void testGetHourlyRate_facultyLowerThanGuest() {
        // Business rule: Faculty ($15) < Guest ($30)
        assertTrue(approvedFaculty.getHourlyRate() < 30.0);
    }

    @Test
    public void testApprovalStatus_doesNotAffectHourlyRate() {
        // Approval status is only for access control, not billing
        assertEquals(approvedFaculty.getHourlyRate(), unapprovedFaculty.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetUserType_unapprovedFaculty_stillReturnsFaculty() {
        // User type is intrinsic, not affected by approval status
        assertEquals("Faculty", unapprovedFaculty.getUserType());
    }
}

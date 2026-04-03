package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Researcher;

/**
 * Tests for the Researcher user model.
 * Researchers pay $20/hr and require lab coordinator approval.
 * Real data from users.csv: Darius Tehrani, dtehrani@yorku.ca, 111222333
 */
public class ResearcherTest {

    private Researcher approvedResearcher;
    private Researcher pendingResearcher;

    @BeforeEach
    public void setUp() {
        approvedResearcher = new Researcher("Darius Tehrani", "dtehrani@yorku.ca", "Research@123", "111222333", true);
        pendingResearcher  = new Researcher("New Researcher",  "newres@yorku.ca",   "NewRes@123",  "555666777", false);
    }

    @Test
    public void testGetUserType_researcher_returnsResearcherString() {
        assertEquals("Researcher", approvedResearcher.getUserType());
    }

    @Test
    public void testGetHourlyRate_researcher_returnsTwenty() {
        // Researchers are charged $20/hour — higher than faculty, lower than guests
        assertEquals(20.0, approvedResearcher.getHourlyRate(), 0.001);
    }

    @Test
    public void testIsApproved_approvedResearcher_returnsTrue() {
        assertTrue(approvedResearcher.isApproved());
    }

    @Test
    public void testIsApproved_pendingResearcher_returnsFalse() {
        // Researchers must be approved before they can use lab equipment
        assertFalse(pendingResearcher.isApproved());
    }

    @Test
    public void testGetName_dtehrani_returnsFullName() {
        assertEquals("Darius Tehrani", approvedResearcher.getName());
    }

    @Test
    public void testGetEmail_dtehrani_returnsYorkEmail() {
        assertEquals("dtehrani@yorku.ca", approvedResearcher.getEmail());
    }

    @Test
    public void testGetIdNumber_researcher_returnsNineDigitId() {
        assertEquals("111222333", approvedResearcher.getIdNumber());
    }

    @Test
    public void testGetHourlyRate_researcherHigherThanFaculty() {
        // Billing tier: Researcher ($20) > Faculty ($15)
        assertTrue(approvedResearcher.getHourlyRate() > 15.0);
    }

    @Test
    public void testGetHourlyRate_researcherLowerThanGuest() {
        // Billing tier: Researcher ($20) < Guest ($30)
        assertTrue(approvedResearcher.getHourlyRate() < 30.0);
    }

    @Test
    public void testGetHourlyRate_approvalStatusDoesNotAffectRate() {
        // Approval changes access, not billing rate
        assertEquals(approvedResearcher.getHourlyRate(), pendingResearcher.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetPassword_researcher_returnsStoredPassword() {
        assertEquals("Research@123", approvedResearcher.getPassword());
    }

    @Test
    public void testGetUserType_pendingResearcher_stillReturnsResearcher() {
        assertEquals("Researcher", pendingResearcher.getUserType());
    }
}

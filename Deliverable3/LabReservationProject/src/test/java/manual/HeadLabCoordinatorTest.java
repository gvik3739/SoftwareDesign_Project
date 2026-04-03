package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.HeadLabCoordinator;
import model.LabManager;

/**
 * Tests for HeadLabCoordinator — a Singleton that acts as the factory for LabManager accounts.
 */
public class HeadLabCoordinatorTest {

    @Test
    public void testGetInstance_firstCall_returnsNonNull() {
        assertNotNull(HeadLabCoordinator.getInstance());
    }

    @Test
    public void testGetInstance_calledTwice_returnsSameObject() {
        // Singleton guarantee: both calls must return the exact same instance
        HeadLabCoordinator first  = HeadLabCoordinator.getInstance();
        HeadLabCoordinator second = HeadLabCoordinator.getInstance();
        assertSame(first, second,
            "HeadLabCoordinator.getInstance() must always return the same singleton instance");
    }

    @Test
    public void testGetInstance_calledManyTimes_alwaysSameObject() {
        HeadLabCoordinator ref = HeadLabCoordinator.getInstance();
        for (int i = 0; i < 10; i++) {
            assertSame(ref, HeadLabCoordinator.getInstance());
        }
    }

    @Test
    public void testCreateLabManagerAccount_validParams_returnsLabManager() {
        HeadLabCoordinator coordinator = HeadLabCoordinator.getInstance();
        LabManager lm = coordinator.createLabManagerAccount(
            "Arjun Patel", "apatel@yorku.ca", "Manager@123", "LM001"
        );
        assertNotNull(lm, "createLabManagerAccount must return a valid LabManager object");
    }

    @Test
    public void testCreateLabManagerAccount_name_storedCorrectly() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Test Manager", "tm@yorku.ca", "Test@123", "LM099");
        assertEquals("Test Manager", lm.getName());
    }

    @Test
    public void testCreateLabManagerAccount_email_storedCorrectly() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Test Manager", "tm@yorku.ca", "Test@123", "LM099");
        assertEquals("tm@yorku.ca", lm.getEmail());
    }

    @Test
    public void testCreateLabManagerAccount_managerId_storedCorrectly() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Arjun Patel", "apatel@yorku.ca", "Manager@123", "LM001");
        assertEquals("LM001", lm.getManagerId());
    }

    @Test
    public void testCreateLabManagerAccount_userType_isLabManager() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("X", "x@y.ca", "Pass@1", "LM002");
        assertEquals("LabManager", lm.getUserType());
    }

    @Test
    public void testCreateLabManagerAccount_multipleCalls_uniqueObjects() {
        HeadLabCoordinator coordinator = HeadLabCoordinator.getInstance();
        LabManager lm1 = coordinator.createLabManagerAccount("A", "a@y.ca", "A@pass1", "LM010");
        LabManager lm2 = coordinator.createLabManagerAccount("B", "b@y.ca", "B@pass1", "LM011");
        assertNotSame(lm1, lm2, "Each call should produce a distinct LabManager instance");
    }

    @Test
    public void testCreateLabManagerAccount_hourlyRate_isZero() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Z", "z@y.ca", "Z@pass1", "LM099");
        assertEquals(0.0, lm.getHourlyRate(), 0.001);
    }

    @Test
    public void testCreateLabManagerAccount_password_storedCorrectly() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Arjun Patel", "apatel@yorku.ca", "Manager@123", "LM001");
        assertEquals("Manager@123", lm.getPassword());
    }
}

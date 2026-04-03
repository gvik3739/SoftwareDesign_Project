package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.HeadLabCoordinator;
import model.LabManager;

// AI-generated test file for HeadLabCoordinator class
public class HeadLabCoordinatorTest {

    @BeforeEach
    public void setUp() {
        // Reset singleton for clean tests
        try {
            java.lang.reflect.Field f = HeadLabCoordinator.class.getDeclaredField("instance");
            f.setAccessible(true);
            f.set(null, null);
        } catch (Exception e) {
            // ignore if field access fails
        }
    }

    @Test
    public void testGetInstance_notNull() {
        assertNotNull(HeadLabCoordinator.getInstance());
    }

    @Test
    public void testGetInstance_singleton_sameObject() {
        HeadLabCoordinator a = HeadLabCoordinator.getInstance();
        HeadLabCoordinator b = HeadLabCoordinator.getInstance();
        assertSame(a, b);
    }

    @Test
    public void testCreateLabManagerAccount_notNull() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Alice Manager", "alice@lab.ca", "Manager@123", "LM001");
        assertNotNull(lm);
    }

    @Test
    public void testCreateLabManagerAccount_correctName() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Alice Manager", "alice@lab.ca", "Manager@123", "LM001");
        assertEquals("Alice Manager", lm.getName());
    }

    @Test
    public void testCreateLabManagerAccount_correctEmail() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Bob Manager", "bob@lab.ca", "Manager@456", "LM002");
        assertEquals("bob@lab.ca", lm.getEmail());
    }

    @Test
    public void testCreateLabManagerAccount_correctUserType() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Carol Manager", "carol@lab.ca", "Manager@789", "LM003");
        assertEquals("LabManager", lm.getUserType());
    }

    @Test
    public void testCreateLabManagerAccount_correctIdNumber() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Dave Manager", "dave@lab.ca", "Manager@321", "LM004");
        assertEquals("LM004", lm.getIdNumber());
    }

    @Test
    public void testCreateLabManagerAccount_twoAccounts_differentObjects() {
        LabManager lm1 = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Manager1", "m1@lab.ca", "Mgr@Pass1", "LM010");
        LabManager lm2 = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Manager2", "m2@lab.ca", "Mgr@Pass2", "LM011");
        assertNotSame(lm1, lm2);
    }

    @Test
    public void testCreateLabManagerAccount_hourlyRateIsZero() {
        LabManager lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Eve Manager", "eve@lab.ca", "Manager@Eve", "LM005");
        assertEquals(0.0, lm.getHourlyRate(), 0.001);
    }

    @Test
    public void testCreateLabManagerAccount_isInstanceOfLabManager() {
        Object lm = HeadLabCoordinator.getInstance()
            .createLabManagerAccount("Frank Manager", "frank@lab.ca", "Manager@Fr", "LM006");
        assertTrue(lm instanceof LabManager);
    }

    @Test
    public void testGetInstance_afterCreateAccount_stillSameSingleton() {
        HeadLabCoordinator hc = HeadLabCoordinator.getInstance();
        hc.createLabManagerAccount("Grace", "grace@lab.ca", "Manager@Gr", "LM007");
        assertSame(hc, HeadLabCoordinator.getInstance());
    }
}

package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import data.MaintainUser;
import model.*;
import java.io.*;
import java.nio.file.*;

/**
 * Tests for MaintainUser — the data-access layer for User objects.
 * Uses temp files for I/O tests so the real users.csv is never modified.
 * Real data from users.csv:
 *   student,James Carter,jcarter@yorku.ca,Strong@123,123456789,true
 *   faculty,Priya Sharma,psharma@yorku.ca,Faculty@123,987654321,true
 */
public class MaintainUserTest {

    private File tempCsv;
    private MaintainUser maintainUser;

    private static final String CSV_HEADER = "userType,name,email,password,idNumber,approved";
    private static final String STUDENT_ROW = "student,James Carter,jcarter@yorku.ca,Strong@123,123456789,true";
    private static final String FACULTY_ROW = "faculty,Priya Sharma,psharma@yorku.ca,Faculty@123,987654321,true";
    private static final String RESEARCHER_ROW = "researcher,Darius Tehrani,dtehrani@yorku.ca,Research@123,111222333,true";
    private static final String GUEST_ROW = "guest,Emily Brown,ebrown@yorku.ca,Guest@123,444555666,true";
    private static final String MANAGER_ROW = "LabManager,Arjun Patel,apatel@yorku.ca,Manager@123,LM001,true";

    @BeforeEach
    public void setUp() throws Exception {
        tempCsv = File.createTempFile("users_test", ".csv");
        tempCsv.deleteOnExit();
        writeCsv(CSV_HEADER, STUDENT_ROW, FACULTY_ROW, RESEARCHER_ROW, GUEST_ROW, MANAGER_ROW);
        maintainUser = new MaintainUser();
    }

    @AfterEach
    public void tearDown() {
        if (tempCsv != null) tempCsv.delete();
    }

    private void writeCsv(String... lines) throws Exception {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempCsv))) {
            for (String line : lines) pw.println(line);
        }
    }

    @Test
    public void testLoad_validCsvFile_loadsAllUsers() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        assertEquals(5, maintainUser.users.size(),
            "Should load all 5 users from the CSV file");
    }

    @Test
    public void testLoad_studentRow_createsStudentInstance() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        User user = maintainUser.users.get(0);
        assertTrue(user instanceof Student, "First row is 'student' type");
    }

    @Test
    public void testLoad_facultyRow_createsFacultyInstance() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        User user = maintainUser.users.get(1);
        assertTrue(user instanceof Faculty);
    }

    @Test
    public void testLoad_studentEmail_parsedCorrectly() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        assertEquals("jcarter@yorku.ca", maintainUser.users.get(0).getEmail());
    }

    @Test
    public void testFindByEmail_existingEmail_returnsUser() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        User user = maintainUser.findByEmail("jcarter@yorku.ca");
        assertNotNull(user);
        assertEquals("James Carter", user.getName());
    }

    @Test
    public void testFindByEmail_nonExistentEmail_returnsNull() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        User user = maintainUser.findByEmail("nobody@nowhere.ca");
        assertNull(user, "Non-existent email should return null");
    }

    @Test
    public void testFindByEmail_caseInsensitive_returnsUser() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        User user = maintainUser.findByEmail("JCARTER@YORKU.CA");
        assertNotNull(user, "Email lookup should be case-insensitive");
    }

    @Test
    public void testFindById_existingId_returnsUser() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        User user = maintainUser.findById("123456789");
        assertNotNull(user);
        assertEquals("James Carter", user.getName());
    }

    @Test
    public void testFindById_labManagerId_returnsLabManager() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        User user = maintainUser.findById("LM001");
        assertNotNull(user);
        assertTrue(user instanceof LabManager);
    }

    @Test
    public void testFindById_nonExistentId_returnsNull() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        assertNull(maintainUser.findById("999999999"));
    }

    @Test
    public void testLoad_missingFile_loadsZeroUsers() throws Exception {
        maintainUser.load("/tmp/does_not_exist_xyz_abc.csv");
        assertEquals(0, maintainUser.users.size());
    }

    @Test
    public void testUpdate_writesUsersToCsv_reloadSucceeds() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        maintainUser.update(tempCsv.getAbsolutePath());
        MaintainUser reloaded = new MaintainUser();
        reloaded.load(tempCsv.getAbsolutePath());
        assertEquals(5, reloaded.users.size());
    }

    @Test
    public void testLoad_calledTwice_clearsPreviousData() throws Exception {
        maintainUser.load(tempCsv.getAbsolutePath());
        assertEquals(5, maintainUser.users.size());
        maintainUser.load(tempCsv.getAbsolutePath());
        assertEquals(5, maintainUser.users.size(),
            "Second load must not accumulate duplicates");
    }
}

package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Student;

/**
 * Tests for the Student user model.
 * Students pay $10/hr and do not require approval.
 * Real data from users.csv: James Carter, jcarter@yorku.ca, 123456789
 */
public class StudentTest {

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
    }

    @Test
    public void testGetUserType_student_returnsStudentString() {
        // Students must identify themselves as "Student" for role-based access
        assertEquals("Student", student.getUserType());
    }

    @Test
    public void testGetHourlyRate_student_returnsTen() {
        // Per billing policy, students are charged $10/hour
        assertEquals(10.0, student.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetName_validName_returnsFullName() {
        assertEquals("James Carter", student.getName());
    }

    @Test
    public void testGetEmail_validEmail_returnsYorkEmail() {
        // Email is used for login authentication
        assertEquals("jcarter@yorku.ca", student.getEmail());
    }

    @Test
    public void testGetPassword_storedPassword_returnsPlaintext() {
        // Password is stored as provided (hashing handled at service layer)
        assertEquals("Strong@123", student.getPassword());
    }

    @Test
    public void testGetIdNumber_studentId_returnsNumericId() {
        // ID number is used to look up reservations and payments
        assertEquals("123456789", student.getIdNumber());
    }

    @Test
    public void testGetHourlyRate_studentVsFaculty_studentCheaper() {
        // Students pay less than faculty ($10 vs $15)
        Student s = new Student("Alex Test", "atest@yorku.ca", "Pass@1", "111000111");
        assertTrue(s.getHourlyRate() < 15.0,
            "Student rate should be less than the $15 faculty rate");
    }

    @Test
    public void testGetHourlyRate_studentVsGuest_studentCheaper() {
        // Students pay less than guests ($10 vs $30)
        assertTrue(student.getHourlyRate() < 30.0,
            "Student rate should be well below the $30 guest rate");
    }

    @Test
    public void testConstructor_differentStudents_independentObjects() {
        // Each student object should maintain its own state independently
        Student s2 = new Student("Maria Lopez", "mlopez@yorku.ca", "Pass@22", "999888777");
        assertNotEquals(student.getName(), s2.getName());
        assertNotEquals(student.getIdNumber(), s2.getIdNumber());
    }

    @Test
    public void testGetHourlyRate_multipleInstances_consistentRate() {
        // The $10 hourly rate is a class-wide constant — should never vary between instances
        Student s2 = new Student("Another Student", "astudent@yorku.ca", "Pass@33", "333222111");
        assertEquals(student.getHourlyRate(), s2.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetUserType_multipleStudents_alwaysReturnsStudent() {
        Student s2 = new Student("Test User", "test@yorku.ca", "Pass@99", "000111222");
        assertEquals("Student", s2.getUserType(),
            "All Student instances must report type 'Student'");
    }

    @Test
    public void testGetEmail_emptyEmail_storedAsProvided() {
        // Edge case: empty email should not cause NPE — value is stored as-is
        Student s = new Student("No Email", "", "Pass@1", "000000001");
        assertEquals("", s.getEmail());
    }
}

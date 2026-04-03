package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Student;

// AI-generated test file for Student class
public class StudentTest {

    private Student obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
    }

    @Test
    public void testGetUserType() {
        assertEquals("Student", obj1.getUserType());
    }

    @Test
    public void testGetHourlyRate() {
        assertEquals(10.0, obj1.getHourlyRate(), 0.001);
    }

    @Test
    public void testGetName() {
        assertEquals("James Carter", obj1.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("jcarter@yorku.ca", obj1.getEmail());
    }

    @Test
    public void testGetPassword() {
        assertEquals("Strong@123", obj1.getPassword());
    }

    @Test
    public void testGetIdNumber() {
        assertEquals("123456789", obj1.getIdNumber());
    }

    @Test
    public void testStudentNotNull() {
        assertNotNull(obj1);
    }

    @Test
    public void testStudentType_trivial() {
        // FLAW: trivially useless assertion
        assertEquals(true, true);
    }

    @Test
    public void testConstructorTwoStudents() {
        Student obj2 = new Student("Alice", "alice@yorku.ca", "Pass1@bc", "987654321");
        assertNotSame(obj1, obj2);
    }

    @Test
    public void testGetUserType_isNotFaculty() {
        assertNotEquals("Faculty", obj1.getUserType());
    }

    @Test
    public void testHourlyRate_isPositive() {
        assertTrue(obj1.getHourlyRate() > 0);
    }
}

package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Reservation;
import model.Student;
import model.Equipment;
import java.time.LocalDateTime;

/**
 * Tests for the Reservation model.
 * Uses realistic data matching the CSV structure.
 * Real user: James Carter (123456789), Equipment: EQ001 Digital Microscope
 */
public class ReservationTest {

    private Reservation reservation;
    private Student     student;
    private Equipment   microscope;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @BeforeEach
    public void setUp() {
        student    = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        microscope = new Equipment("EQ001", "Digital Microscope", "Lab A");
        startTime  = LocalDateTime.of(2026, 4, 1, 10, 0);
        endTime    = LocalDateTime.of(2026, 4, 1, 12, 0);
        reservation = new Reservation("R001", student, microscope, startTime, endTime, 10.0);
    }

    @Test
    public void testGetReservationId_r001_returnsCorrectId() {
        assertEquals("R001", reservation.getReservationId());
    }

    @Test
    public void testGetUserId_studentReservation_returnsStudentId() {
        assertEquals("123456789", reservation.getUserId());
    }

    @Test
    public void testGetEquipmentId_microscope_returnsEquipmentId() {
        assertEquals("EQ001", reservation.getEquipmentId());
    }

    @Test
    public void testGetStartTime_twoHourSession_returnsStart() {
        assertEquals(startTime, reservation.getStartTime());
    }

    @Test
    public void testGetEndTime_twoHourSession_returnsEnd() {
        assertEquals(endTime, reservation.getEndTime());
    }

    @Test
    public void testGetStatus_newReservation_defaultsToActive() {
        // Newly created reservations are ACTIVE until changed
        assertEquals("ACTIVE", reservation.getStatus());
    }

    @Test
    public void testSetStatus_cancelled_updatesStatus() {
        reservation.setStatus("CANCELLED");
        assertEquals("CANCELLED", reservation.getStatus());
    }

    @Test
    public void testSetStatus_modified_updatesStatus() {
        reservation.setStatus("MODIFIED");
        assertEquals("MODIFIED", reservation.getStatus());
    }

    @Test
    public void testHasArrived_newReservation_defaultsFalse() {
        assertFalse(reservation.hasArrived(),
            "User has not arrived by default at reservation creation");
    }

    @Test
    public void testMarkArrived_setArrival_returnsTrue() {
        reservation.markArrived();
        assertTrue(reservation.hasArrived());
    }

    @Test
    public void testIsDepositForfeited_newReservation_defaultsFalse() {
        assertFalse(reservation.isDepositForfeited(),
            "Deposit should not be forfeited by default");
    }

    @Test
    public void testForfeitDeposit_lateArrival_depositMarkedForfeited() {
        reservation.forfeitDeposit();
        assertTrue(reservation.isDepositForfeited());
    }

    @Test
    public void testGetDepositAmount_studentReservation_tenDollarDeposit() {
        assertEquals(10.0, reservation.getDepositAmount(), 0.001);
    }

    @Test
    public void testSetStartTime_modifySlot_startTimeUpdated() {
        LocalDateTime newStart = LocalDateTime.of(2026, 4, 1, 11, 0);
        reservation.setStartTime(newStart);
        assertEquals(newStart, reservation.getStartTime());
    }

    @Test
    public void testSetEndTime_extend_endTimeUpdated() {
        LocalDateTime newEnd = LocalDateTime.of(2026, 4, 1, 14, 0);
        reservation.setEndTime(newEnd);
        assertEquals(newEnd, reservation.getEndTime());
    }
}

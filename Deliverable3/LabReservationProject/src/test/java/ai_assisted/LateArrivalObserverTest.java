package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.LateArrivalObserver;
import model.Reservation;
import model.Student;
import model.Equipment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// AI-generated test file for LateArrivalObserver class
public class LateArrivalObserverTest {

    private List<Reservation> reservations;
    private LateArrivalObserver observer;
    private Reservation reservation;
    private static final LocalDateTime START = LocalDateTime.of(2026, 6, 1, 10, 0);
    private static final LocalDateTime END   = LocalDateTime.of(2026, 6, 1, 12, 0);

    @BeforeEach
    public void setUp() {
        reservations = new ArrayList<>();
        Student student     = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        Equipment equipment = new Equipment("EQ001", "Microscope", "Lab A");
        reservation = new Reservation("R001", student, equipment, START, END, 10.0);
        reservations.add(reservation);
        observer = new LateArrivalObserver(reservations);
    }

    @Test
    public void testUpdate_onTime_depositNotForfeited() {
        observer.update(START);
        assertFalse(reservation.isDepositForfeited());
    }

    @Test
    public void testUpdate_exactlyAtGracePeriod_depositNotForfeited() {
        // Exactly 20 minutes — not yet past the threshold
        observer.update(START.plusMinutes(20));
        assertFalse(reservation.isDepositForfeited());
    }

    @Test
    public void testUpdate_21MinutesLate_depositForfeited() {
        observer.update(START.plusMinutes(21));
        assertTrue(reservation.isDepositForfeited());
    }

    @Test
    public void testUpdate_1HourLate_depositForfeited() {
        observer.update(START.plusHours(1));
        assertTrue(reservation.isDepositForfeited());
    }

    @Test
    public void testUpdate_alreadyArrived_depositNotForfeited() {
        reservation.markArrived();
        observer.update(START.plusMinutes(30));
        assertFalse(reservation.isDepositForfeited());
    }

    @Test
    public void testUpdate_depositAlreadyForfeited_notForfeited_again() {
        reservation.forfeitDeposit();
        observer.update(START.plusMinutes(25));
        // Should not crash and deposit stays forfeited
        assertTrue(reservation.isDepositForfeited());
    }

    @Test
    public void testUpdate_nonDateTimeEventData_noException() {
        assertDoesNotThrow(() -> observer.update("not a datetime"));
    }

    @Test
    public void testUpdate_nullEventData_noException() {
        assertDoesNotThrow(() -> observer.update(null));
    }

    @Test
    public void testUpdate_emptyReservationList_noException() {
        LateArrivalObserver emptyObserver = new LateArrivalObserver(new ArrayList<>());
        assertDoesNotThrow(() -> emptyObserver.update(START.plusMinutes(30)));
    }

    @Test
    public void testUpdate_multipleReservations_onlyLateOneForfeited() {
        Student s2 = new Student("Sara Lee", "slee@yorku.ca", "Pass@123", "987654321");
        Equipment eq2 = new Equipment("EQ002", "Centrifuge", "Lab B");
        Reservation res2 = new Reservation("R002", s2, eq2,
            LocalDateTime.of(2026, 6, 1, 14, 0),
            LocalDateTime.of(2026, 6, 1, 16, 0), 10.0);
        reservations.add(res2);

        // Only first reservation is past its grace period at 10:21
        observer.update(START.plusMinutes(21));
        assertTrue(reservation.isDepositForfeited());
        assertFalse(res2.isDepositForfeited());
    }
}

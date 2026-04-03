package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.LateArrivalObserver;
import model.Reservation;
import model.Student;
import model.Equipment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for LateArrivalObserver.
 * Forfeit deposit when user doesn't arrive within 20 min of start time.
 */
public class LateArrivalObserverTest {

    private List<Reservation> reservations;
    private LateArrivalObserver observer;
    private Reservation reservation;

    @BeforeEach
    public void setUp() {
        reservations = new ArrayList<>();
        Student   student   = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        Equipment equipment = new Equipment("EQ001", "Digital Microscope", "Lab A");

        // Reservation starts at 10:00 AM
        reservation = new Reservation("R001", student, equipment,
            LocalDateTime.of(2026, 4, 1, 10, 0),
            LocalDateTime.of(2026, 4, 1, 12, 0),
            10.0);
        reservations.add(reservation);
        observer = new LateArrivalObserver(reservations);
    }

    @Test
    public void testUpdate_arriveOnTime_depositNotForfeited() {
        // User arrives exactly at start time — no forfeiture
        LocalDateTime onTime = LocalDateTime.of(2026, 4, 1, 10, 0);
        observer.update(onTime);
        assertFalse(reservation.isDepositForfeited(),
            "Deposit must not be forfeited if user arrives on time");
    }

    @Test
    public void testUpdate_arrive15MinLate_depositNotForfeited() {
        // 15 minutes late is within the 20-minute grace period
        LocalDateTime fifteenLate = LocalDateTime.of(2026, 4, 1, 10, 15);
        observer.update(fifteenLate);
        assertFalse(reservation.isDepositForfeited(),
            "Deposit must not be forfeited within the 20-minute grace period");
    }

    @Test
    public void testUpdate_arrive21MinLate_depositForfeited() {
        // 21 minutes late — grace period expired, deposit is forfeited
        LocalDateTime twentyOneLate = LocalDateTime.of(2026, 4, 1, 10, 21);
        observer.update(twentyOneLate);
        assertTrue(reservation.isDepositForfeited(),
            "Deposit should be forfeited when user is more than 20 minutes late");
    }

    @Test
    public void testUpdate_arrive60MinLate_depositForfeited() {
        LocalDateTime veryLate = LocalDateTime.of(2026, 4, 1, 11, 0);
        observer.update(veryLate);
        assertTrue(reservation.isDepositForfeited());
    }

    @Test
    public void testUpdate_arrivedMarked_depositNotForfeited() {
        // If user marked as arrived, deposit should never be forfeited
        reservation.markArrived();
        LocalDateTime late = LocalDateTime.of(2026, 4, 1, 10, 30);
        observer.update(late);
        assertFalse(reservation.isDepositForfeited(),
            "Deposit must not be forfeited if hasArrived() is true");
    }

    @Test
    public void testUpdate_alreadyForfeited_noDoubleForfeiture() {
        // If already forfeited, update should be idempotent
        reservation.forfeitDeposit();
        LocalDateTime late = LocalDateTime.of(2026, 4, 1, 10, 30);
        observer.update(late); // should not throw
        assertTrue(reservation.isDepositForfeited());
    }

    @Test
    public void testUpdate_nonDateTimeEvent_ignored() {
        // Observer only reacts to LocalDateTime events — other types are ignored
        observer.update("not a date");
        assertFalse(reservation.isDepositForfeited(),
            "String event should be ignored by LateArrivalObserver");
    }

    @Test
    public void testUpdate_nullEvent_noCrash() {
        // Null events should not crash the observer
        assertDoesNotThrow(() -> observer.update(null));
    }

    @Test
    public void testUpdate_multipleReservations_allLateOnesForfeited() {
        Student   s2 = new Student("Maria", "m@yorku.ca", "Pass@1", "999");
        Equipment e2 = new Equipment("EQ002", "Centrifuge", "Lab A");
        Reservation r2 = new Reservation("R002", s2, e2,
            LocalDateTime.of(2026, 4, 1, 10, 0),
            LocalDateTime.of(2026, 4, 1, 11, 0),
            10.0);
        reservations.add(r2);

        LocalDateTime late = LocalDateTime.of(2026, 4, 1, 10, 25);
        observer.update(late);

        assertTrue(reservation.isDepositForfeited(), "R001 should be forfeited");
        assertTrue(r2.isDepositForfeited(), "R002 should also be forfeited");
    }

    @Test
    public void testUpdate_exactly20MinutesLate_notForfeited() {
        // Grace period is strictly >20 minutes; exactly 20 is still OK
        LocalDateTime exactly20 = LocalDateTime.of(2026, 4, 1, 10, 20);
        observer.update(exactly20);
        assertFalse(reservation.isDepositForfeited(),
            "Exactly 20 minutes late should still be within the grace period");
    }

    @Test
    public void testUpdate_emptyReservationList_noException() {
        LateArrivalObserver emptyObserver = new LateArrivalObserver(new ArrayList<>());
        assertDoesNotThrow(() -> emptyObserver.update(LocalDateTime.of(2026, 4, 1, 10, 30)));
    }
}

package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.ReservationService;
import model.*;
import strategy.CreditCardPaymentStrategy;
import strategy.DebitPaymentStrategy;
import util.SystemClock;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * End-to-end tests for ReservationService.
 * Tests the full reservation workflow through the command pattern.
 * Real data: James Carter (123456789), Priya Sharma (987654321), EQ001.
 */
public class ReservationServiceTest {

    private File tempResCsv;
    private File tempPayCsv;
    private ReservationService service;
    private Student student;
    private Faculty faculty;
    private Equipment microscope;
    private LocalDateTime futureStart;
    private LocalDateTime futureEnd;
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @BeforeEach
    public void setUp() throws Exception {
        tempResCsv = File.createTempFile("svc_reservations", ".csv");
        tempPayCsv = File.createTempFile("svc_payments",     ".csv");
        tempResCsv.deleteOnExit();
        tempPayCsv.deleteOnExit();

        try (PrintWriter pw = new PrintWriter(new FileWriter(tempResCsv))) {
            pw.println("reservationId,userId,equipmentId,startTime,endTime,status,depositAmount,depositForfeited");
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempPayCsv))) {
            pw.println("paymentId,reservationId,userId,amount,paymentMethod,status,timestamp,type");
        }

        service     = new ReservationService(tempResCsv.getAbsolutePath(), tempPayCsv.getAbsolutePath());
        student     = new Student("James Carter",  "jcarter@yorku.ca", "Strong@123",  "123456789");
        faculty     = new Faculty("Priya Sharma",  "psharma@yorku.ca", "Faculty@123", "987654321", true);
        microscope  = new Equipment("EQ001", "Digital Microscope", "Lab A");
        futureStart = SystemClock.getInstance().now().plusDays(1);
        futureEnd   = futureStart.plusHours(2);
    }

    @AfterEach
    public void tearDown() {
        if (tempResCsv != null) tempResCsv.delete();
        if (tempPayCsv != null) tempPayCsv.delete();
    }

    @Test
    public void testMakeReservation_availableEquipmentFutureTime_returnsTrue() {
        assertTrue(service.makeReservation(student, microscope, futureStart, futureEnd,
            new CreditCardPaymentStrategy()));
    }

    @Test
    public void testMakeReservation_disabledEquipment_returnsFalse() {
        microscope.disable();
        assertFalse(service.makeReservation(student, microscope, futureStart, futureEnd,
            new CreditCardPaymentStrategy()));
    }

    @Test
    public void testMakeReservation_persistsToCSV() throws Exception {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempResCsv.getAbsolutePath());
        assertEquals(1, mr.reservations.size());
    }

    @Test
    public void testMakeReservation_duplicateTimeSlot_secondReturnsFalse() {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        assertFalse(
            service.makeReservation(faculty, microscope, futureStart, futureEnd, new DebitPaymentStrategy()),
            "Second booking for the same slot must be rejected"
        );
    }

    @Test
    public void testCancelReservation_futureReservation_returnsTrue() throws Exception {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempResCsv.getAbsolutePath());
        Reservation r = mr.reservations.get(0);

        // Re-hydrate the full objects before cancelling
        r = new Reservation(r.getReservationId(), student, microscope,
            r.getStartTime(), r.getEndTime(), r.getDepositAmount());
        assertTrue(service.cancelReservation(r));
    }

    @Test
    public void testCancelReservation_alreadyCancelledReservation_returnsFalse() {
        LocalDateTime start = futureStart.plusDays(5);
        LocalDateTime end   = start.plusHours(2);
        Reservation r = new Reservation("R999", student, microscope, start, end, 10.0);
        r.setStatus("CANCELLED");
        assertFalse(service.cancelReservation(r));
    }

    @Test
    public void testModifyReservation_validNewSlot_returnsTrue() throws Exception {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempResCsv.getAbsolutePath());
        Reservation r = new Reservation(mr.reservations.get(0).getReservationId(),
            student, microscope, futureStart, futureEnd, 10.0);
        LocalDateTime newStart = futureStart.plusDays(3);
        assertTrue(service.modifyReservation(r, newStart, newStart.plusHours(2)));
    }

    @Test
    public void testExtendReservation_laterEndTime_returnsTrue() throws Exception {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempResCsv.getAbsolutePath());
        Reservation r = new Reservation(mr.reservations.get(0).getReservationId(),
            student, microscope, futureStart, futureEnd, 10.0);
        assertTrue(service.extendReservation(r, futureEnd.plusHours(2)));
    }

    @Test
    public void testGetAllReservations_emptyFile_returnsEmptyList() {
        assertTrue(service.getAllReservations().isEmpty());
    }

    @Test
    public void testGetAllReservations_afterMakeReservation_returnsOneItem() {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        assertEquals(1, service.getAllReservations().size());
    }

    @Test
    public void testGetReservationsForUser_correctUserFiltered() {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        List<Reservation> studentRes = service.getReservationsForUser("123456789");
        assertEquals(1, studentRes.size());
        assertEquals("123456789", studentRes.get(0).getUserId());
    }

    @Test
    public void testGetReservationsForUser_wrongUser_returnsEmpty() {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        List<Reservation> other = service.getReservationsForUser("987654321");
        assertTrue(other.isEmpty());
    }

    @Test
    public void testGetReservationsForEquipment_correctEquipmentFiltered() {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        List<Reservation> eqRes = service.getReservationsForEquipment("EQ001");
        assertEquals(1, eqRes.size());
    }

    @Test
    public void testPrintCommandHistory_noException() {
        service.makeReservation(student, microscope, futureStart, futureEnd, new CreditCardPaymentStrategy());
        assertDoesNotThrow(() -> service.printCommandHistory());
    }

    @Test
    public void testGetLastError_returnsEmptyString() {
        assertEquals("", service.getLastError());
    }
}

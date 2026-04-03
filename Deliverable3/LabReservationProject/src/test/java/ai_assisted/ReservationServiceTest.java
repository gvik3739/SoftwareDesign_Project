package ai_assisted;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.ReservationService;
import model.*;
import strategy.CreditCardPaymentStrategy;
import strategy.DebitPaymentStrategy;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

// AI-generated test file for ReservationService class
public class ReservationServiceTest {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private File resCsv;
    private File paymentCsv;
    private ReservationService service;
    private Student student;
    private Equipment equipment;
    private LocalDateTime futureStart;
    private LocalDateTime futureEnd;

    @BeforeEach
    public void setUp() throws Exception {
        resCsv     = File.createTempFile("svc_res", ".csv");
        paymentCsv = File.createTempFile("svc_pay", ".csv");
        resCsv.deleteOnExit();
        paymentCsv.deleteOnExit();

        // Write headers
        try (PrintWriter pw = new PrintWriter(new FileWriter(resCsv))) {
            pw.println("reservationId,userId,equipmentId,startTime,endTime,status,depositAmount,depositForfeited");
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(paymentCsv))) {
            pw.println("paymentId,reservationId,userId,amount,type,timestamp");
        }

        service   = new ReservationService(resCsv.getAbsolutePath(), paymentCsv.getAbsolutePath());
        student   = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        equipment = new Equipment("EQ001", "Microscope", "Lab A");
        futureStart = LocalDateTime.of(2027, 8, 1, 10, 0);
        futureEnd   = futureStart.plusHours(2);
    }

    @AfterEach
    public void tearDown() {
        if (resCsv != null)     resCsv.delete();
        if (paymentCsv != null) paymentCsv.delete();
    }

    @Test
    public void testGetAllReservations_emptyFile_returnsEmptyList() {
        List<Reservation> list = service.getAllReservations();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testMakeReservation_validInputs_returnsTrue() {
        boolean result = service.makeReservation(
            student, equipment, futureStart, futureEnd, new CreditCardPaymentStrategy());
        assertTrue(result);
    }

    @Test
    public void testMakeReservation_createsReservationRecord() {
        service.makeReservation(student, equipment, futureStart, futureEnd, new CreditCardPaymentStrategy());
        List<Reservation> list = service.getAllReservations();
        assertEquals(1, list.size());
    }

    @Test
    public void testGetReservationsForUser_afterMakeReservation_returnsOne() {
        service.makeReservation(student, equipment, futureStart, futureEnd, new DebitPaymentStrategy());
        List<Reservation> list = service.getReservationsForUser("123456789");
        assertEquals(1, list.size());
    }

    @Test
    public void testGetReservationsForUser_wrongId_returnsEmpty() {
        service.makeReservation(student, equipment, futureStart, futureEnd, new CreditCardPaymentStrategy());
        List<Reservation> list = service.getReservationsForUser("WRONG_ID");
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetReservationsForEquipment_afterMakeReservation_returnsOne() {
        service.makeReservation(student, equipment, futureStart, futureEnd, new CreditCardPaymentStrategy());
        List<Reservation> list = service.getReservationsForEquipment("EQ001");
        assertEquals(1, list.size());
    }

    @Test
    public void testGetReservationsForEquipment_wrongId_returnsEmpty() {
        service.makeReservation(student, equipment, futureStart, futureEnd, new CreditCardPaymentStrategy());
        List<Reservation> list = service.getReservationsForEquipment("EQ_NONE");
        assertTrue(list.isEmpty());
    }

    @Test
    public void testCancelReservation_futureReservation_returnsTrue() throws Exception {
        service.makeReservation(student, equipment, futureStart, futureEnd, new CreditCardPaymentStrategy());
        List<Reservation> list = service.getAllReservations();
        assertFalse(list.isEmpty());
        boolean result = service.cancelReservation(list.get(0));
        assertTrue(result);
    }

    @Test
    public void testPrintCommandHistory_noException() {
        assertDoesNotThrow(() -> service.printCommandHistory());
    }

    @Test
    public void testGetLastError_returnsString() {
        assertNotNull(service.getLastError());
    }
}

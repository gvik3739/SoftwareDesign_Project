package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.MakeReservationCommand;
import model.*;
import strategy.CreditCardPaymentStrategy;
import strategy.DebitPaymentStrategy;
import util.SystemClock;
import java.io.*;
import java.time.LocalDateTime;

/**
 * Tests for MakeReservationCommand.
 * Preconditions: (1) equipment must be AVAILABLE, (2) start time in future, (3) no time conflict.
 * Real data: James Carter (123456789), EQ001 Digital Microscope.
 */
public class MakeReservationCommandTest {

    private File tempResCsv;
    private File tempPayCsv;
    private Student student;
    private Equipment microscope;
    private LocalDateTime futureStart;
    private LocalDateTime futureEnd;

    @BeforeEach
    public void setUp() throws Exception {
        tempResCsv = File.createTempFile("res_make", ".csv");
        tempPayCsv = File.createTempFile("pay_make", ".csv");
        tempResCsv.deleteOnExit();
        tempPayCsv.deleteOnExit();

        // Write empty CSVs
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempResCsv))) {
            pw.println("reservationId,userId,equipmentId,startTime,endTime,status,depositAmount,depositForfeited");
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempPayCsv))) {
            pw.println("paymentId,reservationId,userId,amount,paymentMethod,status,timestamp,type");
        }

        student     = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        microscope  = new Equipment("EQ001", "Digital Microscope", "Lab A");
        futureStart = SystemClock.getInstance().now().plusDays(1);
        futureEnd   = futureStart.plusHours(2);
    }

    @AfterEach
    public void tearDown() {
        if (tempResCsv != null) tempResCsv.delete();
        if (tempPayCsv != null) tempPayCsv.delete();
    }

    private MakeReservationCommand makeCmd() {
        return new MakeReservationCommand(student, microscope, futureStart, futureEnd,
            tempResCsv.getAbsolutePath(), tempPayCsv.getAbsolutePath(),
            new CreditCardPaymentStrategy());
    }

    @Test
    public void testCanExecute_availableEquipmentFutureTime_returnsTrue() {
        assertTrue(makeCmd().canExecute());
    }

    @Test
    public void testCanExecute_disabledEquipment_returnsFalse() {
        microscope.disable();
        assertFalse(makeCmd().canExecute(),
            "Cannot reserve DISABLED equipment");
    }

    @Test
    public void testCanExecute_maintenanceEquipment_returnsFalse() {
        microscope.markUnderMaintenance();
        assertFalse(makeCmd().canExecute(),
            "Cannot reserve equipment under MAINTENANCE");
    }

    @Test
    public void testCanExecute_pastStartTime_returnsFalse() {
        LocalDateTime pastStart = SystemClock.getInstance().now().minusDays(1);
        LocalDateTime pastEnd   = pastStart.plusHours(2);
        MakeReservationCommand cmd = new MakeReservationCommand(
            student, microscope, pastStart, pastEnd,
            tempResCsv.getAbsolutePath(), tempPayCsv.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        assertFalse(cmd.canExecute(),
            "Start time must be in the future");
    }

    @Test
    public void testGetErrorMessage_disabledEquipment_containsStateInfo() {
        microscope.disable();
        MakeReservationCommand cmd = makeCmd();
        cmd.canExecute();
        assertFalse(cmd.getErrorMessage().isEmpty());
    }

    @Test
    public void testGetErrorMessage_validCommand_isEmpty() {
        MakeReservationCommand cmd = makeCmd();
        cmd.canExecute();
        assertEquals("", cmd.getErrorMessage());
    }

    @Test
    public void testGetDescription_containsEquipmentName() {
        assertTrue(makeCmd().getDescription().contains("Digital Microscope"));
    }

    @Test
    public void testGetDescription_containsUserId() {
        assertTrue(makeCmd().getDescription().contains("123456789"));
    }

    @Test
    public void testExecute_createsReservationInCsv() throws Exception {
        MakeReservationCommand cmd = makeCmd();
        cmd.execute();
        data.MaintainReservation mr = new data.MaintainReservation();
        mr.load(tempResCsv.getAbsolutePath());
        assertEquals(1, mr.reservations.size(),
            "After execute(), exactly one reservation should be written to CSV");
    }

    @Test
    public void testExecute_createsPaymentRecordInCsv() throws Exception {
        MakeReservationCommand cmd = makeCmd();
        cmd.execute();
        data.MaintainPayment mp = new data.MaintainPayment();
        mp.load(tempPayCsv.getAbsolutePath());
        assertEquals(1, mp.payments.size(),
            "After execute(), a deposit payment should be written to CSV");
    }

    @Test
    public void testExecute_depositAmountMatchesStudentHourlyRate() throws Exception {
        MakeReservationCommand cmd = makeCmd();
        cmd.execute();
        data.MaintainPayment mp = new data.MaintainPayment();
        mp.load(tempPayCsv.getAbsolutePath());
        assertEquals(10.0, mp.payments.get(0).getAmount(), 0.001,
            "Deposit must equal 1 hour's student rate ($10)");
    }

    @Test
    public void testCanExecute_overlappingReservationExists_returnsFalse() throws Exception {
        // Write a pre-existing reservation that overlaps our target slot
        LocalDateTime fmt = futureStart;
        try (PrintWriter pw = new PrintWriter(new FileWriter(tempResCsv))) {
            pw.println("reservationId,userId,equipmentId,startTime,endTime,status,depositAmount,depositForfeited");
            pw.println("R001,987654321,EQ001,"
                + fmt.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + ","
                + futureEnd.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                + ",ACTIVE,15.00,false");
        }
        assertFalse(makeCmd().canExecute(),
            "Should not allow booking when equipment already has an overlapping reservation");
    }
}

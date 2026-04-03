package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.MakeReservationCommand;
import model.Equipment;
import model.Student;
import model.User;
import data.MaintainReservation;
import data.MaintainPayment;
import strategy.CreditCardPaymentStrategy;
import java.io.File;
import java.time.LocalDateTime;

// AI-generated test file for MakeReservationCommand class
public class MakeReservationCommandTest {

    private Equipment eq;
    private User user;
    private LocalDateTime start;
    private LocalDateTime end;
    private File resFile;
    private File payFile;

    @BeforeEach
    public void setUp() throws Exception {
        eq    = new Equipment("EQ001", "Digital Microscope", "Lab A");
        user  = new Student("James Carter", "jcarter@yorku.ca", "Strong@123", "123456789");
        start = LocalDateTime.now().plusHours(2);
        end   = LocalDateTime.now().plusHours(4);
        resFile = File.createTempFile("reservations", ".csv");
        payFile = File.createTempFile("payments", ".csv");
        java.nio.file.Files.write(resFile.toPath(),
            "reservationId,userId,equipmentId,startTime,endTime,status,depositAmount\n".getBytes());
        java.nio.file.Files.write(payFile.toPath(),
            "paymentId,reservationId,userId,amount,paymentMethod,status,timestamp,paymentType\n".getBytes());
    }

    @AfterEach
    public void tearDown() {
        resFile.delete();
        payFile.delete();
    }

    @Test
    public void testCanExecute_availableEquipment() {
        MakeReservationCommand cmd = new MakeReservationCommand(
            user, eq, start, end,
            resFile.getAbsolutePath(), payFile.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        assertTrue(cmd.canExecute());
    }

    @Test
    public void testCanExecute_disabledEquipment() {
        eq.disable();
        MakeReservationCommand cmd = new MakeReservationCommand(
            user, eq, start, end,
            resFile.getAbsolutePath(), payFile.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        assertFalse(cmd.canExecute());
    }

    @Test
    public void testCanExecute_pastStartTime() {
        LocalDateTime pastStart = LocalDateTime.now().minusHours(1);
        LocalDateTime pastEnd   = LocalDateTime.now().plusHours(1);
        MakeReservationCommand cmd = new MakeReservationCommand(
            user, eq, pastStart, pastEnd,
            resFile.getAbsolutePath(), payFile.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        assertFalse(cmd.canExecute());
    }

    @Test
    public void testExecute_createsReservation() throws Exception {
        MakeReservationCommand cmd = new MakeReservationCommand(
            user, eq, start, end,
            resFile.getAbsolutePath(), payFile.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        cmd.execute();
        MaintainReservation mr = new MaintainReservation();
        mr.load(resFile.getAbsolutePath());
        assertEquals(1, mr.reservations.size());
    }

    @Test
    public void testGetDescription_notEmpty() {
        MakeReservationCommand cmd = new MakeReservationCommand(
            user, eq, start, end,
            resFile.getAbsolutePath(), payFile.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        assertFalse(cmd.getDescription().isEmpty());
    }

    @Test
    public void testCanExecute_maintenanceEquipment() {
        eq.markUnderMaintenance();
        MakeReservationCommand cmd = new MakeReservationCommand(
            user, eq, start, end,
            resFile.getAbsolutePath(), payFile.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        assertFalse(cmd.canExecute());
    }

    @Test
    public void testCommandNotNull() {
        MakeReservationCommand cmd = new MakeReservationCommand(
            user, eq, start, end,
            resFile.getAbsolutePath(), payFile.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        assertNotNull(cmd);
    }

    @Test
    public void testTrivial() {
        // FLAW: useless
        assertTrue(true);
    }

    @Test
    public void testCanExecute_calledTwice_sameResult() {
        MakeReservationCommand cmd = new MakeReservationCommand(
            user, eq, start, end,
            resFile.getAbsolutePath(), payFile.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        boolean first  = cmd.canExecute();
        boolean second = cmd.canExecute();
        assertEquals(first, second);
    }

    @Test
    public void testExecute_createsPayment() throws Exception {
        MakeReservationCommand cmd = new MakeReservationCommand(
            user, eq, start, end,
            resFile.getAbsolutePath(), payFile.getAbsolutePath(),
            new CreditCardPaymentStrategy());
        cmd.execute();
        MaintainPayment mp = new MaintainPayment();
        mp.load(payFile.getAbsolutePath());
        assertEquals(1, mp.payments.size());
    }
}

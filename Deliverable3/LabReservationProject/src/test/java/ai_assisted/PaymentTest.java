package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import model.Payment;

// AI-generated test file for Payment class
public class PaymentTest {

    private Payment obj1;

    @BeforeEach
    public void setUp() {
        obj1 = new Payment("P001", "R001", "123456789", 10.0,
                           "Credit Card", "COMPLETED",
                           "2026-03-19 00:51", "DEPOSIT");
    }

    @Test
    public void testGetPaymentId() {
        assertEquals("P001", obj1.getPaymentId());
    }

    @Test
    public void testGetReservationId() {
        assertEquals("R001", obj1.getReservationId());
    }

    @Test
    public void testGetUserId() {
        assertEquals("123456789", obj1.getUserId());
    }

    @Test
    public void testGetAmount() {
        assertEquals(10.0, obj1.getAmount(), 0.001);
    }

    @Test
    public void testGetPaymentMethod() {
        assertEquals("Credit Card", obj1.getPaymentMethod());
    }

    @Test
    public void testGetStatus() {
        assertEquals("COMPLETED", obj1.getStatus());
    }

    @Test
    public void testGetPaymentType() {
        assertEquals("DEPOSIT", obj1.getType());
    }

    @Test
    public void testGetTimestamp_notNull() {
        assertNotNull(obj1.getTimestamp());
    }

    @Test
    public void testPaymentNotNull() {
        assertNotNull(obj1);
    }

    @Test
    public void testAmountIsPositive() {
        // FLAW: only tests happy path, doesn't test zero or negative amounts
        assertTrue(obj1.getAmount() > 0);
    }

    @Test
    public void testStatusNotNull() {
        // FLAW: redundant — already tested by testGetStatus()
        assertNotNull(obj1.getStatus());
    }
}

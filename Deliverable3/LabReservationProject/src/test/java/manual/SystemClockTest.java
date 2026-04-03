package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import util.SystemClock;
import util.Observer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for SystemClock — a Singleton Subject that provides current time
 * and notifies observers via tick().
 */
public class SystemClockTest {

    static class TimeCapture implements Observer {
        List<Object> events = new ArrayList<>();
        @Override public void update(Object eventData) { events.add(eventData); }
    }

    @Test
    public void testGetInstance_returnsNonNull() {
        assertNotNull(SystemClock.getInstance());
    }

    @Test
    public void testGetInstance_singletonPattern_sameInstance() {
        assertSame(SystemClock.getInstance(), SystemClock.getInstance(),
            "SystemClock must always return the same singleton instance");
    }

    @Test
    public void testNow_returnsCurrentTime_notNull() {
        assertNotNull(SystemClock.getInstance().now());
    }

    @Test
    public void testNow_returnsLocalDateTime() {
        assertTrue(SystemClock.getInstance().now() instanceof LocalDateTime);
    }

    @Test
    public void testNow_twoCallsInSuccession_secondIsAfterOrEqualFirst() {
        LocalDateTime t1 = SystemClock.getInstance().now();
        LocalDateTime t2 = SystemClock.getInstance().now();
        assertFalse(t2.isBefore(t1), "second call to now() must not return a time before the first");
    }

    @Test
    public void testNow_isInYear2026() {
        // The test environment is set up for 2026 — sanity check
        assertTrue(SystemClock.getInstance().now().getYear() >= 2026);
    }

    @Test
    public void testAttach_observerReceivesTickEvent() {
        TimeCapture capture = new TimeCapture();
        SystemClock clock   = SystemClock.getInstance();
        clock.attach(capture);
        clock.tick();
        assertFalse(capture.events.isEmpty(),
            "After tick(), the attached observer must receive at least one event");
        clock.detach(capture); // clean up
    }

    @Test
    public void testDetach_observerNoLongerReceivesEvents() {
        TimeCapture capture = new TimeCapture();
        SystemClock clock   = SystemClock.getInstance();
        clock.attach(capture);
        clock.detach(capture);
        clock.tick();
        assertTrue(capture.events.isEmpty(),
            "Detached observer must not receive tick events");
    }

    @Test
    public void testTick_notifiesObserverWithLocalDateTime() {
        TimeCapture capture = new TimeCapture();
        SystemClock clock   = SystemClock.getInstance();
        clock.attach(capture);
        clock.tick();
        assertTrue(capture.events.get(0) instanceof LocalDateTime);
        clock.detach(capture);
    }

    @Test
    public void testNotifyObservers_directCall_observerReceivesEvent() {
        TimeCapture capture = new TimeCapture();
        SystemClock clock   = SystemClock.getInstance();
        clock.attach(capture);
        clock.notifyObservers("TEST");
        assertEquals("TEST", capture.events.get(0));
        clock.detach(capture);
    }

    @Test
    public void testTick_multipleTicks_observerReceivesMultipleEvents() {
        TimeCapture capture = new TimeCapture();
        SystemClock clock   = SystemClock.getInstance();
        clock.attach(capture);
        clock.tick();
        clock.tick();
        clock.tick();
        assertEquals(3, capture.events.size());
        clock.detach(capture);
    }
}

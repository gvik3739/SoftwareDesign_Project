package manual;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.CommandManager;
import command.ReservationCommand;
import java.util.List;

/**
 * Tests for CommandManager — the Command pattern invoker.
 * Verifies precondition enforcement, history tracking, and error handling.
 */
public class CommandManagerTest {

    private CommandManager manager;

    // Stub commands for testing
    static class AlwaysSucceedCommand implements ReservationCommand {
        boolean executed = false;
        @Override public boolean canExecute() { return true; }
        @Override public void execute() { executed = true; }
        @Override public String getDescription() { return "AlwaysSucceed"; }
        @Override public String getErrorMessage() { return ""; }
    }

    static class AlwaysFailCommand implements ReservationCommand {
        @Override public boolean canExecute() { return false; }
        @Override public void execute() {}
        @Override public String getDescription() { return "AlwaysFail"; }
        @Override public String getErrorMessage() { return "Precondition failed intentionally"; }
    }

    static class ThrowingCommand implements ReservationCommand {
        @Override public boolean canExecute() { return true; }
        @Override public void execute() throws Exception { throw new RuntimeException("Simulated error"); }
        @Override public String getDescription() { return "ThrowingCommand"; }
        @Override public String getErrorMessage() { return ""; }
    }

    @BeforeEach
    public void setUp() {
        manager = new CommandManager();
    }

    @Test
    public void testExecute_commandPreconditionsPasses_returnsTrue() {
        assertTrue(manager.execute(new AlwaysSucceedCommand()));
    }

    @Test
    public void testExecute_commandPreconditionsFails_returnsFalse() {
        assertFalse(manager.execute(new AlwaysFailCommand()));
    }

    @Test
    public void testExecute_successfulCommand_addedToHistory() {
        manager.execute(new AlwaysSucceedCommand());
        assertEquals(1, manager.getHistory().size());
    }

    @Test
    public void testExecute_failedCommand_notAddedToHistory() {
        manager.execute(new AlwaysFailCommand());
        assertEquals(0, manager.getHistory().size(),
            "Commands that fail canExecute() must not be recorded in history");
    }

    @Test
    public void testExecute_commandActuallyRuns_executedFlagSet() {
        AlwaysSucceedCommand cmd = new AlwaysSucceedCommand();
        manager.execute(cmd);
        assertTrue(cmd.executed, "execute() must be called when canExecute() returns true");
    }

    @Test
    public void testExecute_throwingCommand_returnsFalse() {
        assertFalse(manager.execute(new ThrowingCommand()),
            "Command that throws during execute() should return false");
    }

    @Test
    public void testExecute_throwingCommand_notAddedToHistory() {
        manager.execute(new ThrowingCommand());
        assertEquals(0, manager.getHistory().size(),
            "Command that throws must not be recorded in history");
    }

    @Test
    public void testGetHistory_emptyManager_returnsEmptyList() {
        assertTrue(manager.getHistory().isEmpty());
    }

    @Test
    public void testGetHistory_twoSuccessfulCommands_returnsBothInOrder() {
        AlwaysSucceedCommand cmd1 = new AlwaysSucceedCommand();
        AlwaysSucceedCommand cmd2 = new AlwaysSucceedCommand();
        manager.execute(cmd1);
        manager.execute(cmd2);
        List<ReservationCommand> history = manager.getHistory();
        assertEquals(2, history.size());
        assertSame(cmd1, history.get(0));
        assertSame(cmd2, history.get(1));
    }

    @Test
    public void testGetHistory_mixedSuccessAndFailure_onlySuccessInHistory() {
        manager.execute(new AlwaysSucceedCommand());
        manager.execute(new AlwaysFailCommand());
        manager.execute(new AlwaysSucceedCommand());
        assertEquals(2, manager.getHistory().size());
    }

    @Test
    public void testPrintHistory_noException() {
        manager.execute(new AlwaysSucceedCommand());
        assertDoesNotThrow(() -> manager.printHistory());
    }

    @Test
    public void testPrintHistory_emptyHistory_noException() {
        assertDoesNotThrow(() -> manager.printHistory());
    }
}

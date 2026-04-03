package ai_assisted;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import command.CommandManager;
import command.ReservationCommand;

// AI-generated test file for CommandManager
public class CommandManagerTest {

    static class AlwaysSucceedCommand implements ReservationCommand {
        boolean executed = false;
        public boolean canExecute() { return true; }
        public void execute() { executed = true; }
        public String getDescription() { return "Success command"; }
        public String getErrorMessage() { return ""; }
    }

    static class AlwaysFailCommand implements ReservationCommand {
        public boolean canExecute() { return false; }
        public void execute() {}
        public String getDescription() { return "Fail command"; }
        public String getErrorMessage() { return "Cannot execute"; }
    }

    @Test
    public void testExecute_successCommand_returnsTrue() {
        CommandManager mgr = new CommandManager();
        assertTrue(mgr.execute(new AlwaysSucceedCommand()));
    }

    @Test
    public void testExecute_failCommand_returnsFalse() {
        CommandManager mgr = new CommandManager();
        assertFalse(mgr.execute(new AlwaysFailCommand()));
    }

    @Test
    public void testGetHistory_afterExecution() {
        CommandManager mgr = new CommandManager();
        mgr.execute(new AlwaysSucceedCommand());
        assertEquals(1, mgr.getHistory().size());
    }

    @Test
    public void testGetHistory_failedNotInHistory() {
        CommandManager mgr = new CommandManager();
        mgr.execute(new AlwaysFailCommand());
        assertEquals(0, mgr.getHistory().size());
    }

    @Test
    public void testHistory_empty_initially() {
        CommandManager mgr = new CommandManager();
        assertEquals(0, mgr.getHistory().size());
    }

    @Test
    public void testExecuteMultiple() {
        CommandManager mgr = new CommandManager();
        mgr.execute(new AlwaysSucceedCommand());
        mgr.execute(new AlwaysSucceedCommand());
        assertEquals(2, mgr.getHistory().size());
    }

    @Test
    public void testCommandManagerNotNull() {
        assertNotNull(new CommandManager());
    }

    @Test
    public void testExecute_setsExecutedFlag() {
        CommandManager mgr = new CommandManager();
        AlwaysSucceedCommand cmd = new AlwaysSucceedCommand();
        mgr.execute(cmd);
        assertTrue(cmd.executed);
    }

    @Test
    public void testTrivial() {
        // FLAW: useless
        assertTrue(true);
    }

    @Test
    public void testGetHistory_returnsCorrectCommand() {
        CommandManager mgr = new CommandManager();
        AlwaysSucceedCommand cmd = new AlwaysSucceedCommand();
        mgr.execute(cmd);
        assertSame(cmd, mgr.getHistory().get(0));
    }
}

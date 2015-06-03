package pl.labno.bernard;

        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.rules.ExpectedException;
        import static org.mockito.Mockito.*;
        import static org.junit.Assert.*;


public class TerminalTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void sendLine_lineIsNull_throwsException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("line param must not be null");
        //Given
        Connection con = mock(Connection.class);
        Terminal terminal = new Terminal(con);
        // When
        terminal.sendLine(null);
    }

    @Test
    public void sendLine_connectionNotConnected_throwsExceptionAndErrorMsg() {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Not connected");
        // Given
        Connection con = mock(Connection.class);
        when(con.isConnected()).thenReturn(false);
        Terminal terminal = new Terminal(con);
        // When
        terminal.sendLine("line");
        String errorMessage = terminal.getErrorMessage();
        // Then
        assertEquals("terminal is not connected", errorMessage);
    }


    @Test
    public void sendLine_connectionIsConnectedAndCommandNoValid_throwsExceptionAndErrorMsg() {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Unknown command");
        // Given
        Connection con = mock(Connection.class);
        when(con.isConnected()).thenReturn(true);
        when(con.sendLine("line")).thenThrow(UnknownCommandException.class);
        Terminal terminal = new Terminal(con);
        // When
        terminal.sendLine("line");
        String errorMsg = terminal.getErrorMessage();
        // Then
        assertEquals("This command is unknown", errorMsg);
    }


    @Test
    public void sendLine_connectionIsConnectedAndCommandValid_executeConnectionSendLine() {
        // Given
        Connection con = mock(Connection.class);
        when(con.isConnected()).thenReturn(true);
        when(con.sendLine("line")).thenReturn("line");
        Terminal terminal = new Terminal(con);
        // When
        String line = terminal.sendLine("line");
        // Then
        assertEquals("line", line);
    }

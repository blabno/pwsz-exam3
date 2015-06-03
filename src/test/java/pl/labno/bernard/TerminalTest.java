package pl.labno.bernard;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;

public class TerminalTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void sendLine_connectionNoConnected_throwExceptionAndSetErrorMsg() {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Not connected");
        // Given
        Connection conn = mock(Connection.class);
        when(conn.isConnected()).thenReturn(false);
        Terminal t = new Terminal(conn);
        // When
        t.sendLine("line");
        String errorMsg = t.getErrorMessage();
        // Then
        assertEquals("terminal is not connected", errorMsg);
    }

    @Test
    public void sendLine_lineNull_throwException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("line param must not be null");
        //Given
        Connection conn = mock(Connection.class);
        Terminal t = new Terminal(conn);
        // When
        t.sendLine(null);
    }

    @Test
    public void sendLine_connectionConnectedAndCommandNoValid_throwExceptionAndSetErrorMsg() {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Unknown command");
        // Given
        Connection conn = mock(Connection.class);
        when(conn.isConnected()).thenReturn(true);
        when(conn.sendLine("line")).thenThrow(UnknownCommandException.class);
        Terminal t = new Terminal(conn);
        // When
        t.sendLine("line");
        String error = t.getErrorMessage();
        // Then
        assertEquals("This command is unknown", error);
    }

    @Test
    public void sendLine_connectionConnectedAndCommandValid_executeConnectionSendLine() {
        // Given
        Connection conn = mock(Connection.class);
        when(conn.isConnected()).thenReturn(true);
        when(conn.sendLine("line")).thenReturn("line");
        Terminal t = new Terminal(conn);
        // When
        String line = t.sendLine("line");
        // Then
        assertEquals("line", line);
    }
}
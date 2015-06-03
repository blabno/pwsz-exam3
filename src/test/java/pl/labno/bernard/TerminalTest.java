package pl.labno.bernard;

import org.junit.Assert;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;


public class TerminalTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getMessage_messageNull_throwException() {

        // Given
        Terminal terminal = new Terminal(mock(Connection.class));

        // When
        String message = terminal.getErrorMessage();

        // Then
        Assert.assertNull(message);
    }

    @Test
    public void sendLine_connectionNotConnected_throwsExceptionAndErrorMsg() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Not connected");

        // Given
        Connection con = mock(Connection.class);
        when(con.isConnected()).thenReturn(false);
        Terminal terminal = new Terminal(con);

        // When
        terminal.sendLine("command");
        String errorMessage = terminal.getErrorMessage();

        // Then
        assertEquals("terminal is not connected", errorMessage);
    }

    @Test
    public void sendLine_lineIsNull_throwException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("line param must not be null");

        //Given
        Connection connection = mock(Connection.class);
        Terminal terminal = new Terminal(connection);

        // When
        terminal.sendLine(null);
    }

    @Test
    public void sendLine_isConnectedAndCommandIsValid_executeSendLine() {
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

    @Test
    public void sendLine_connectionIsConnectedAndCommandNoValid_throwsExceptionAndErrorMsg() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Unknown command");

        // Given
        Connection con = mock(Connection.class);
        when(con.isConnected()).thenReturn(true);
        when(con.sendLine("aaa")).thenThrow(UnknownCommandException.class);
        Terminal terminal = new Terminal(con);

        // When
        terminal.sendLine("aaa");
        String errorMsg = terminal.getErrorMessage();

        // Then
        assertEquals("This command is unknown", errorMsg);
    }
}

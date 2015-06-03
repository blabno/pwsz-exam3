package pl.labno.bernard;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;
public class TerminalTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void sendLine_nullLine_Exception() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("line param must not be null");
        //Given
        Connection connMock = mock(Connection.class);
        Terminal ter = new Terminal(connMock);
        // When
        ter.sendLine(null);
    }

    @Test
    public void sendLine_notConnected_ExceptionAndSetErrorMsg() {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Not connected");
        // Given
        Connection connMock = mock(Connection.class);
        when(connMock.isConnected()).thenReturn(false);
        Terminal ter = new Terminal(connMock);
        // When
        ter.sendLine("line");
        String errorMsg = ter.getErrorMessage();
        // Then
        assertEquals("terminal is not connected", errorMsg);
    }

    @Test
    public void sendLine_isConnectedAndCommandNotValid_ExceptionAndSetErrorMsg() {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Unknown command");
        // Given
        Connection connMock = mock(Connection.class);
        when(connMock.isConnected()).thenReturn(true);
        when(connMock.sendLine("line")).thenThrow(UnknownCommandException.class);
        Terminal ter = new Terminal(connMock);
        // When
        ter.sendLine("line");
        String errorMsg = ter.getErrorMessage();
        // Then
        assertEquals("This command is unknown", errorMsg);
    }

    @Test
    public void sendLine_isConnectedAndCommandIsValid_executeConnectionSendLine() {
        // Given
        Connection connMock = mock(Connection.class);
        when(connMock.isConnected()).thenReturn(true);
        when(connMock.sendLine("line")).thenReturn("line");
        Terminal ter = new Terminal(connMock);
        // When
        String line = ter.sendLine("line");
        // Then
        assertEquals("line", line);
    }
}

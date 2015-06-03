package pl.labno.bernard;

import org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito.*;

public class TerminalTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void sendLine_lineJestNull_throwException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("line param must not be null");
        //Given
        Connection coMo = mock(Connection.class);
        Terminal t = new Terminal(coMo);
        // When
        t.sendLine(null);
    }

    @Test
    public void sendLine_connecJestConnectedICommandJestValid_executeConnectionSendLine() {
        // Given
        Connection coMo = mock(Connection.class);
        when(coMo.isConnected()).thenReturn(true);
        when(coMo.sendLine("line")).thenReturn("line");
        Terminal t = new Terminal(coMo);
        // When
        String line = t.sendLine("line");
        // Then
        assertEquals("line", line);
    }

    @Test
    public void sendLine_connecNieJestConnected_throwExceptionAndSetErrorMsg() {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Not connected");
        // Given
        Connection coMo = mock(Connection.class);
        when(coMo.isConnected()).thenReturn(false);
        Terminal t = new Terminal(coMo);
        // When
        t.sendLine("line");
        String errorMsg = t.getErrorMessage();
        // Then
        assertEquals("terminal is not connected", errorMsg);
    }

    @Test
    public void sendLine_connecJestConnectedAndCommandNotValid_throwExceptionAndSetErrorMsg() {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Unknown command");
        // Given
        Connection coMo = mock(Connection.class);
        when(coMo.isConnected()).thenReturn(true);
        when(coMo.sendLine("line")).thenThrow(UnknownCommandException.class);
        Terminal t = new Terminal(coMo);
        // When
        t.sendLine("line");
        String errorMsg = t.getErrorMessage();
        // Then
        assertEquals("This command is unknown", errorMsg);
    }
}
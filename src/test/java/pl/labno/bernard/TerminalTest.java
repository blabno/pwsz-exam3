package pl.labno.bernard;



import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;




    public class TerminalTest {

        @Test
        public void lineToSend_connectionWorksAndCommandNotValid_throwsExceptionAndErrorMsg() {
            exception.expect(IllegalStateException.class);
            exception.expectMessage("Unknown command");
            // Given
            Connection connect = mock(Connection.class);
            when(connect.isConnected()).thenReturn(true);
            when(connect.sendLine("line")).thenThrow(UnknownCommandException.class);
            Terminal terminal = new Terminal(connect);
            // When
            terminal.sendLine("line");
            String errorMsg = terminal.getErrorMessage();
            // Then
            assertEquals("This command is unknown", errorMsg);
        }

        @Rule
        public ExpectedException exception = ExpectedException.none();

        @Test
        public void lineToSend_lineNull_throwsException() {
            exception.expect(IllegalArgumentException.class);
            exception.expectMessage("line paramater must not be null");
            //Given
            Connection connect = mock(Connection.class);
            Terminal terminal = new Terminal(connect);
            // When
            terminal.sendLine(null);
        }


        @Test
        public void lineToSend_connectionIsConnectedAndCommandValid_executeConnectionSendLine() {
            // Given
            Connection connect = mock(Connection.class);
            when(connect.isConnected()).thenReturn(true);
            when(connect.sendLine("line")).thenReturn("line");
            Terminal terminal = new Terminal(connect);
            // When
            String line = terminal.sendLine("line");
            // Then
            assertEquals("line", line);
        }

        @Test
        public void lineToSend_connectionNotConnected_throwsExceptionAndErrorMsg() {
            exception.expect(IllegalStateException.class);
            exception.expectMessage("Not connected");
            // Given
            Connection connect = mock(Connection.class);
            when(con.isConnected()).thenReturn(false);
            Terminal terminal = new Terminal(con);
            // When
            terminal.sendLine("line");
            String errorMessage = terminal.getErrorMessage();
            // Then
            assertEquals("terminal is not connected", errorMessage);
        }

    }
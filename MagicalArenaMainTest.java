import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MagicalArenaMainTest {

    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMain() {
        MagicalArenaMain.main(null);

        String output = outContent.toString();

        // Checking the initial player states are printed
        assertTrue(output.contains("Player A: "));
        assertTrue(output.contains("Player B: "));

        // Checking the final winner message is printed
        assertTrue(output.contains("wins the game!"));
        assertFalse(output.contains("wins the game!!"));
    }
}

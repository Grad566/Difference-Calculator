package hexlet.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    protected ByteArrayOutputStream output;
    private PrintStream old;

    @BeforeEach
    public void setUpStreams() {
        old = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(old);
    }
    @Test
    public void right1() throws Exception {
        var str1 = "src/test/resources/file1.json";
        var str2 = "src/test/resources/file2.json";
        var expected = "{\n"
                + " - follow: false\n"
                + "   host: hexlet.io\n"
                + " - proxy: 123.234.53.22\n"
                + " - timeout: 50\n"
                + " + timeout: 20\n"
                + " + verbose: true\n"
                + "}\n";

        Differ.generate(str1, str2);

        assertEquals(expected, output.toString());
    }
}

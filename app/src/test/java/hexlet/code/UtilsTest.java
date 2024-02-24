package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.Utils.getContentOfFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {
    @Test
    public void right1() throws Exception {
        var actual = getContentOfFile("src/test/resources/file1.json");
        var expected = "{\n"
                + "  \"host\": \"hexlet.io\",\n"
                + "  \"timeout\": 50,\n"
                + "  \"proxy\": \"123.234.53.22\",\n"
                + "  \"follow\": false\n"
                + "}";
        assertEquals(expected.trim(), actual.trim());
    }
}

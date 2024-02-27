package hexlet.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static hexlet.code.Differ.generate;
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
    public void rightJSON() throws Exception {
        var str1 = "src/test/resources/file1.json";
        var str2 = "src/test/resources/file2.json";
        var format = "stylish";
        var expected = "{\n" +
                "    chars1: [a, b, c]\n" +
                "  - chars2: [d, e, f]\n" +
                "  + chars2: false\n" +
                "  - checked: false\n" +
                "  + checked: true\n" +
                "  - default: null\n" +
                "  + default: [value1, value2]\n" +
                "  - id: 45\n" +
                "  + id: null\n" +
                "  - key1: value1\n" +
                "  + key2: value2\n" +
                "    numbers1: [1, 2, 3, 4]\n" +
                "  - numbers2: [2, 3, 4, 5]\n" +
                "  + numbers2: [22, 33, 44, 55]\n" +
                "  - numbers3: [3, 4, 5]\n" +
                "  + numbers4: [4, 5, 6]\n" +
                "  + obj1: {nestedKey=value, isNested=true}\n" +
                "  - setting1: Some value\n" +
                "  + setting1: Another value\n" +
                "  - setting2: 200\n" +
                "  + setting2: 300\n" +
                "  - setting3: true\n" +
                "  + setting3: none\n" +
                "}";

        generate(str1, str2, format);

        assertEquals(expected, output.toString().trim());
    }

    @Test
    public void rightYAML() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var format = "stylish";
        var expected = "{\n" +
                "    chars1: [a, b, c]\n" +
                "  - chars2: [d, e, f]\n" +
                "  + chars2: false\n" +
                "  - checked: false\n" +
                "  + checked: true\n" +
                "  - default: null\n" +
                "  + default: [value1, value2]\n" +
                "  - id: 45\n" +
                "  + id: null\n" +
                "  - key1: value1\n" +
                "  + key2: value2\n" +
                "    numbers1: [1, 2, 3, 4]\n" +
                "  - numbers2: [2, 3, 4, 5]\n" +
                "  + numbers2: [22, 33, 44, 55]\n" +
                "  - numbers3: [3, 4, 5]\n" +
                "  + numbers4: [4, 5, 6]\n" +
                "  + obj1: {nestedKey=value, isNested=true}\n" +
                "  - setting1: Some value\n" +
                "  + setting1: Another value\n" +
                "  - setting2: 200\n" +
                "  + setting2: 300\n" +
                "  - setting3: true\n" +
                "  + setting3: none\n" +
                "}";

        generate(str1, str2, format);

        assertEquals(expected, output.toString().trim());
    }
}

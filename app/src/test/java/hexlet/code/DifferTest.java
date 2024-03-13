package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private static String stylishOutput;
    private static String plainOutput;
    private static String jsonOutput;
    @BeforeAll
    public static void setExpected() throws IOException {
        stylishOutput = getOutput("src/test/resources/testStylishOutput.txt");
        plainOutput = getOutput("src/test/resources/testPlainOutput.txt");
        jsonOutput = getOutput("src/test/resources/resultForTest.json");
    }

    public static String getOutput(String path) throws IOException {
        var absolutePath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(absolutePath).trim();
    }

    @Test
    public void testGenerateStylishWithJsonInput() throws Exception {
        var str1 = "src/test/resources/file1.json";
        var str2 = "src/test/resources/file2.json";
        var format = "stylish";
        var expected = stylishOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateStylishWithYamlInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var format = "stylish";
        var expected = stylishOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual);
    }

    @Test
    public void testGeneratePlainWithYamlInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var format = "plain";
        var expected = plainOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual);
    }

    @Test
    public void testGeneratePlainWithJsonInput() throws Exception {
        var str1 = "src/test/resources/file1.json";
        var str2 = "src/test/resources/file2.json";
        var format = "plain";
        var expected = plainOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonWithYamlInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var format = "json";
        var expected = jsonOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonWithJsonInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var format = "json";
        var expected = jsonOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDefaultWithYamlInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var expected = stylishOutput;

        var actual = generate(str1, str2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDefaultWithJsonInput() throws Exception {
        var str1 = "src/test/resources/file1.json";
        var str2 = "src/test/resources/file2.json";
        var expected = stylishOutput;

        var actual = generate(str1, str2);

        assertEquals(expected, actual);
    }
}

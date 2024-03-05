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
        stylishOutput = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

        plainOutput = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";

        var path = "src/test/resources/resultForTest.json";
        var absolutePath = Paths.get(path).toAbsolutePath().normalize();
        jsonOutput = Files.readString(absolutePath).trim();
    }

    @Test
    public void testGenerateStylishWithJsonInput() throws Exception {
        var str1 = "src/test/resources/file1.json";
        var str2 = "src/test/resources/file2.json";
        var format = "stylish";
        var expected = stylishOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual.trim());
    }

    @Test
    public void testGenerateStylishWithYamlInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var format = "stylish";
        var expected = stylishOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual.trim());
    }

    @Test
    public void testGeneratePlainWithYamlInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var format = "plain";
        var expected = plainOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected.trim(), actual.trim());
    }

    @Test
    public void testGeneratePlainWithJsonInput() throws Exception {
        var str1 = "src/test/resources/file1.json";
        var str2 = "src/test/resources/file2.json";
        var format = "plain";
        var expected = plainOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual.trim());
    }

    @Test
    public void testGenerateJsonWithYamlInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var format = "json";
        var expected = jsonOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected, actual.trim());
    }

    @Test
    public void testGenerateJsonWithJsonInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var format = "json";
        var expected = jsonOutput;

        var actual = generate(str1, str2, format);

        assertEquals(expected.trim(), actual.trim());
    }

    @Test
    public void testGenerateDefaultWithYamlInput() throws Exception {
        var str1 = "src/test/resources/file5.yml";
        var str2 = "src/test/resources/file6.yml";
        var expected = stylishOutput;

        var actual = generate(str1, str2);

        assertEquals(expected, actual.trim());
    }

    @Test
    public void testGenerateDefaultWithJsonInput() throws Exception {
        var str1 = "src/test/resources/file1.json";
        var str2 = "src/test/resources/file2.json";
        var expected = stylishOutput;

        var actual = generate(str1, str2);

        assertEquals(expected, actual.trim());
    }
}

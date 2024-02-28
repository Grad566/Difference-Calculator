package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.Utils.getContentOfFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {
    @Test
    public void right1() throws Exception {
        var actual = getContentOfFile("src/test/resources/file1.json");
        var expected = "{\n"
                + "  \"setting1\": \"Some value\",\n"
                + "  \"setting2\": 200,\n"
                + "  \"setting3\": true,\n"
                + "  \"key1\": \"value1\",\n"
                + "  \"numbers1\": [1, 2, 3, 4],\n"
                + "  \"numbers2\": [2, 3, 4, 5],\n"
                + "  \"id\": 45,\n"
                + "  \"default\": null,\n"
                + "  \"checked\": false,\n"
                + "  \"numbers3\": [3, 4, 5],\n"
                + "  \"chars1\": [\"a\", \"b\", \"c\"],\n"
                + "  \"chars2\": [\"d\", \"e\", \"f\"]\n"
                + "}";
        assertEquals(expected, actual);
    }
}

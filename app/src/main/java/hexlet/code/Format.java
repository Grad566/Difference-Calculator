package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Format {
    public static void printResult(String format, List<Map<String, Object>> difference)
            throws JsonProcessingException {
        if (format.equals("stylish")) {
            Stylish.printAsStylish(difference);
        } else if (format.equals("plain")) {
            Plain.printAsPlain(difference);
        } else {
            Json.printAsJson(difference);
        }
    }
}

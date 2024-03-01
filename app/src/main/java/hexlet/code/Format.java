package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Format {
    public static String printResult(String format, List<Map<String, Object>> difference)
            throws JsonProcessingException {
        String result;

        if (format.equals("stylish")) {
            result = Stylish.printAsStylish(difference);
        } else if (format.equals("plain")) {
            result = Plain.printAsPlain(difference);
        } else {
            result = Json.printAsJson(difference);
        }

        return result;
    }
}

package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class BaseFormat {
    // transforms the result into the required format
    public static String chooseFormat(String format, List<Map<String, Object>> difference)
            throws JsonProcessingException {

        String result = switch (format) {
            case "stylish" -> Stylish.printAsStylish(difference);
            case "plain" -> Plain.printAsPlain(difference);
            case "json" -> Json.printAsJson(difference);
            default -> throw new RuntimeException("Unknown format of output");
        };

        return result;
    }
}

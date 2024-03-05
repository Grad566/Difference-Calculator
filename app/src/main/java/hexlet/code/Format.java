package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Format {
    // transforms the result into the required format
    public static String printResult(String format, List<Map<String, Object>> difference)
            throws JsonProcessingException {

        String result;

        switch (format) {
            case "stylish" :
                result = Stylish.printAsStylish(difference);
            case "plain":
                result = Plain.printAsPlain(difference);
            default:
                result = Json.printAsJson(difference);
        }

        return result;
    }
}

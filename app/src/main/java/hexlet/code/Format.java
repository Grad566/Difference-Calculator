package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Format {
    public static void printResult(String format, List<Map<String, Object>> difference) {
        if (format.equals("stylish")) {
            Stylish.printAsStylish(difference);
        } else {
            Plain.printAsPlain(difference);
        }
    }
}

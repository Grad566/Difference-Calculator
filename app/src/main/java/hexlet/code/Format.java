package hexlet.code.formatters;

import hexlet.code.Utils;

import java.util.List;
import java.util.Map;

public class Format {
    public static void printResult(String format, List<Map<String, Object>> difference) {
        if (format.equals("stylish")) {
            printAsStylish(difference);
        } else {
            printAsPlain(difference);
        }
    }
    public static void printAsStylish(List<Map<String, Object>> result) {
        System.out.println("{");
        result.forEach(element -> {
            if (element.get("status").equals("added")) {
                System.out.println("  + " + element.get("key") + ": " + element.get("value"));
            } else if (element.get("status").equals("removed")) {
                System.out.println("  - " + element.get("key") + ": " + element.get("value"));
            } else if (element.get("status").equals("unchanged")) {
                System.out.println("    " + element.get("key") + ": " + element.get("value"));
            } else {
                System.out.println("  - " + element.get("key") + ": " + element.get("oldValue"));
                System.out.println("  + " + element.get("key") + ": " + element.get("newValue"));
            }
        });
        System.out.println("}");
    }

    public static void printAsPlain(List<Map<String, Object>> result) {
        result.forEach(element -> {
            if (element.containsKey("value")) {
                element.replace("value",
                        element.get("value"),
                        Utils.replaceWithComplexValue(element.get("value")));
            } else {
                element.replace("oldValue", Utils.replaceWithComplexValue(element.get("oldValue")));
                element.replace("newValue", Utils.replaceWithComplexValue(element.get("newValue")));
            }

            if (element.get("status").equals("added")) {
                System.out.printf("Property %s was added with value: %s%n",
                        element.get("key"), element.get("value"));
            } else if (element.get("status").equals("removed")) {
                System.out.printf("Property %s was removed%n",
                        element.get("key"));
            } else if (element.get("status").equals("updated")) {
                System.out.printf("Property %s was updated. From %s to %s%n",
                        element.get("key"), element.get("oldValue"), element.get("newValue"));
            }
        });
    }
}

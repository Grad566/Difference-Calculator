package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
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
}

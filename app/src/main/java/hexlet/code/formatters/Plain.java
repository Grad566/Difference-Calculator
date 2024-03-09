package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    // returns plain format as string
    public static String printAsPlain(List<Map<String, Object>> result) {
        StringBuilder plainFormat = new StringBuilder();

        result.forEach(element -> {
            if (element.containsKey("value")) {
                element.replace("value", element.get("value"), replaceWithComplexValue(element.get("value")));
            } else {
                element.replace("oldValue", replaceWithComplexValue(element.get("oldValue")));
                element.replace("newValue", replaceWithComplexValue(element.get("newValue")));
            }

            switch (element.get("status").toString()) {
                case "added" -> plainFormat.append(String.format("Property '%s' was added with value: %s%n",
                        element.get("key"),
                        element.get("value")));
                case "removed" -> plainFormat.append(String.format("Property '%s' was removed%n",
                        element.get("key")));
                case "updated" -> plainFormat.append(String.format("Property '%s' was updated. From %s to %s%n",
                        element.get("key"),
                        element.get("oldValue"),
                        element.get("newValue")));
                case "unchanged" -> {
                    break;
                }
                default -> throw new RuntimeException("Unknown status");
            }
        });

        return plainFormat.toString().trim();
    }

    // replace nested values with 'complex value'
    public static Object replaceWithComplexValue(Object obj) {
        if (obj == null || obj.equals("null")) {
            return null;
        } else if (obj instanceof List
                || obj instanceof Map) {
            return  "[complex value]";
        } else if (obj instanceof String) {
            return  "'" + obj + "'";
        } else {
            return obj;
        }
    }
}

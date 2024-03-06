package hexlet.code.formatters;

import hexlet.code.Utils;

import java.util.List;
import java.util.Map;

public class Plain {
    // returns plain format as string
    public static String printAsPlain(List<Map<String, Object>> result) {
        StringBuilder plainFormat = new StringBuilder();

        result.forEach(element -> {
            if (element.containsKey("value")) {
                element.replace("value", element.get("value"), Utils.replaceWithComplexValue(element.get("value")));
            } else {
                element.replace("oldValue", Utils.replaceWithComplexValue(element.get("oldValue")));
                element.replace("newValue", Utils.replaceWithComplexValue(element.get("newValue")));
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
                default -> throw new RuntimeException("Unknown status");
            }
        });

        return plainFormat.toString().trim();
    }
}

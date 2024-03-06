package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    // returns stylish format as string
    public static String printAsStylish(List<Map<String, Object>> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        result.forEach(element -> {
            switch (element.get("status").toString()) {
                case "added" -> sb.append("  + ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("value"))
                        .append("\n");
                case "removed" -> sb.append("  - ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("value"))
                        .append("\n");
                case "unchanged" -> sb.append("    ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("value"))
                        .append("\n");
                default -> {
                    sb.append("  - ")
                            .append(element.get("key"))
                            .append(": ")
                            .append(element.get("oldValue"))
                            .append("\n");
                    sb.append("  + ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("newValue"))
                        .append("\n");
                }
            }
        });

        sb.append("}");

        return sb.toString().trim();
    }
}

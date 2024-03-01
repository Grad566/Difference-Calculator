package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        var contentAsMap1 = Utils.getContentAsTreeMap(path1);
        var contentAsMap2 = Utils.getContentAsTreeMap(path2);
        var difference = new ArrayList<Map<String, Object>>();

        var keys = new TreeSet<String>(contentAsMap1.keySet());
        keys.addAll(contentAsMap2.keySet());

        for (var key : keys) {
            var infoAboutElement = new HashMap<String, Object>();

            if (contentAsMap1.get(key) == null) {
                contentAsMap1.replace(key, null, "null");
            }

            if (!contentAsMap1.containsKey(key)) {
                infoAboutElement.put("status", "added");
                infoAboutElement.put("key", key);
                infoAboutElement.put("value", contentAsMap2.get(key));
            } else if (!contentAsMap2.containsKey(key)) {
                infoAboutElement.put("status", "removed");
                infoAboutElement.put("key", key);
                infoAboutElement.put("value", contentAsMap1.get(key));
            } else if (contentAsMap1.get(key).equals(contentAsMap2.get(key))) {
                infoAboutElement.put("status", "unchanged");
                infoAboutElement.put("key", key);
                infoAboutElement.put("value", contentAsMap1.get(key));
            } else {
                infoAboutElement.put("status", "updated");
                infoAboutElement.put("key", key);
                infoAboutElement.put("oldValue", contentAsMap1.get(key));
                infoAboutElement.put("newValue", contentAsMap2.get(key));
            }

            difference.add(infoAboutElement);
        }

        var result = Format.printResult(format, difference);

        System.out.println(result);
        return result;
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }
}

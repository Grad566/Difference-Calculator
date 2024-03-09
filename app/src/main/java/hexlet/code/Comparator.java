package hexlet.code;

import java.util.TreeMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Comparator {
    public static List<Map<String, Object>> generateDifference(TreeMap<String, Object> map1,
                                                               TreeMap<String, Object> map2) {
        var difference = new ArrayList<Map<String, Object>>();
        var keys = new TreeSet<String>(map1.keySet());
        keys.addAll(map2.keySet());

        for (var key : keys) {
            var infoAboutElement = new HashMap<String, Object>();

            if (map1.get(key) == null) {
                map1.replace(key, null, "null");
            }

            if (!map1.containsKey(key)) {
                infoAboutElement.put("status", "added");
                infoAboutElement.put("key", key);
                infoAboutElement.put("value", map2.get(key));
            } else if (!map2.containsKey(key)) {
                infoAboutElement.put("status", "removed");
                infoAboutElement.put("key", key);
                infoAboutElement.put("value", map1.get(key));
            } else if (map1.get(key).equals(map2.get(key))) {
                infoAboutElement.put("status", "unchanged");
                infoAboutElement.put("key", key);
                infoAboutElement.put("value", map1.get(key));
            } else {
                infoAboutElement.put("status", "updated");
                infoAboutElement.put("key", key);
                infoAboutElement.put("oldValue", map1.get(key));
                infoAboutElement.put("newValue", map2.get(key));
            }

            difference.add(infoAboutElement);
        }
        return difference;
    }
}

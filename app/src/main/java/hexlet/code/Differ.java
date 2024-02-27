package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.format.Format;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;


public class Differ {
    public static void generate(String path1, String path2, String format) throws Exception {
        var contentAsMap1 = Utils.getContentAsTreeMap(path1);
        var contentAsMap2 = Utils.getContentAsTreeMap(path2);
        var difference = new ArrayList<String>();

        var keys = new TreeSet<String>(contentAsMap1.keySet());
        keys.addAll(contentAsMap2.keySet());

        for (var key : keys) {
            if (contentAsMap1.get(key) == null) {
                contentAsMap1.replace(key, null, "null");
            }

            if (!contentAsMap1.containsKey(key)) {
                difference.add("  + " + key + ": " + contentAsMap2.get(key));
            } else if (!contentAsMap2.containsKey(key)) {
                difference.add("  - " + key + ": " + contentAsMap1.get(key));
            } else if (contentAsMap1.get(key).equals(contentAsMap2.get(key))) {
                difference.add("    " + key + ": " + contentAsMap1.get(key));
            } else {
                difference.add("  - " + key + ": " + contentAsMap1.get(key));
                difference.add("  + " + key + ": " + contentAsMap2.get(key));
            }
        }

        Format.printResult(format, difference);
    }
}

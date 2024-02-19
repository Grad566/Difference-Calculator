package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    public static void generate(String str, String str2) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        var content1 = Utils.getContentOfFile(str);
        var content2 = Utils.getContentOfFile(str2);
        var contentAsMap1 = mapper.readValue(content1, new TypeReference<TreeMap<String,Object>>(){});
        var contentAsMap2 = mapper.readValue(content2, new TypeReference<TreeMap<String,Object>>(){});

        var keys = new TreeSet<String>(contentAsMap1.keySet());
        keys.addAll(contentAsMap2.keySet());

        System.out.println("{");
        for (var key : keys) {
            if (!contentAsMap1.containsKey(key)) {
                System.out.println(" + " + key + ": " + contentAsMap2.get(key));
            } else if (!contentAsMap2.containsKey(key)) {
                System.out.println(" - " + key + ": " + contentAsMap1.get(key));
            } else if (contentAsMap1.get(key).equals(contentAsMap2.get(key))) {
                System.out.println("   " + key + ": " + contentAsMap1.get(key));
            } else {
                System.out.println(" - " + key + ": " + contentAsMap1.get(key));
                System.out.println(" + " + key + ": " + contentAsMap2.get(key));
            }
        }
        System.out.println("}");
    }
}

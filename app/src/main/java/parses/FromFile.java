package parses;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.TreeMap;

public class FromFile {

    // transform a string to TreeMap
    public static TreeMap<String, Object> getContentAsTreeMap(String content, String input) throws Exception {
        ObjectMapper mapper;

        if (input.equals("json")) {
            mapper = new ObjectMapper();
        } else {
            mapper = new YAMLMapper();
        }

        return mapper.readValue(content, new TypeReference<TreeMap<String, Object>>() { });
    }
}

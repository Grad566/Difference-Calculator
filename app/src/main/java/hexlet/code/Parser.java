package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;


public class Parser {

    // transform a string to TreeMap
    public static Map<String, Object> getContentAsMap(String content, String input) throws Exception {
        ObjectMapper mapper = switch (input) {
            case "json" -> new ObjectMapper();
            case "yml", "yaml" -> new YAMLMapper();
            default -> throw new RuntimeException("Unknown format of file input");
        };

        return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}

package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static void printAsJson(List<Map<String, Object>> result) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var resultAsString = objectMapper.writeValueAsString(result);
        System.out.println(resultAsString);
    }
}

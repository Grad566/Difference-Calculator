package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Utils {
    public static String getContentOfFile(String str) throws Exception {
        Path path = Paths.get(str).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    public static TreeMap<String, Object> getContentAsTreeMap(String path) throws Exception {
        String[] pathAsArray = path.split("\\.");
        var formatOfFile = pathAsArray[1];
        ObjectMapper mapper;
        var content = getContentOfFile(path);

        if (formatOfFile.equals("json")) {
            mapper = new ObjectMapper();
        } else {
            mapper = new YAMLMapper();
        }

        return mapper.readValue(content, new TypeReference<TreeMap<String, Object>>() { });
    }
}

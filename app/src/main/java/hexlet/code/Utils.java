package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static String getContentOfFile(String str) throws Exception {
        Path path = Paths.get(str).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}

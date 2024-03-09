package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Differ {
    // creates a difference in the form of a sorted list that contains maps
    public static String generate(String path1, String path2, String format) throws Exception {
        var formatOfFirstFileInput = getFormatOfInput(path1);
        var formatOfSecondFileInput = getFormatOfInput(path2);
        var contentOfFirstFile = getContentOfFile(path1);
        var contentOfSecondFile = getContentOfFile(path2);

        var contentAsMap1 = FromFile.getContentAsTreeMap(contentOfFirstFile, formatOfFirstFileInput);
        var contentAsMap2 = FromFile.getContentAsTreeMap(contentOfSecondFile, formatOfSecondFileInput);

        var difference = DifferBetweenMap.generateDifference(contentAsMap1, contentAsMap2);

        var result = BaseFormat.chooseFormat(format, difference);

        System.out.println(result);
        return result;
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

    // get content of file as string
    public static String getContentOfFile(String str) throws Exception {
        Path path = Paths.get(str).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    // get format of input
    public static String getFormatOfInput(String path) {
        String[] pathAsArray = path.split("\\.");
        return pathAsArray[1];
    }
}

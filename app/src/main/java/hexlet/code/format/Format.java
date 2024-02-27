package hexlet.code.format;

import java.util.List;

public class Format {
    public static void printResult(String format, List<String> difference) {
        if (format.equals("stylish")) {
            printAsStylish(difference);
        }
    }
    public static void printAsStylish(List<String> result) {
        System.out.println("{");
        result.forEach(System.out::println);
        System.out.println("}");
    }
}

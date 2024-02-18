package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Scanner;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String path1;
    @Parameters(paramLabel = "filepath2", description = "path to first file")
    private String path2;
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String format;
    String value;
    public static void main (String[] args) {
        new CommandLine(new App()).execute(args);
    }

   @Override
   public void run() {
   }
}

package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.Scanner;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    String value;
    public static void main (String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        var input = scanner.next();
        new CommandLine(new App()).execute(args);
    }

   @Override
   public void run() {
   }
}

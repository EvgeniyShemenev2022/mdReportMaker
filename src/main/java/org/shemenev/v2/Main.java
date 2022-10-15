package org.shemenev.v2;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Main {

    private static Path pathToFile;
    private static String onNoArgsMessage = """
              Hello. You run me without arguments. I don't know what to do.
              Please run me with -h argument.
              Buy!
            """;
    private static String with_h_ArgsMessage = """
            Hello. I am programm to calculate report statictic.
            This is my help menu:
                    1) run me as:
            C:\\path> java showStatictic.jar -path "C:\\user\\documents\\path\\report\\01.05.2022.md"
            to process report and see statictic

            Buy!""";

    private static String with_path_ArgsMessage = """
            C:\\path> java showStatictic.jar -path "C:\\user\\documents\\path\\report\\01.05.2022.md"
              Hello. I perform calculation of report for path: "C:\\user\\documents\\path\\report\\01.05.2022.md"\s
             \s
              Report:
              ==================
              break -> PT1H47M
              утреннее совещание -> PT30M
              ID-1788 -> PT5H55M
              inbox -> PT1H43M
              всего -> PT9H55M
              без перерывов -> PT8H8M
              ==================
             \s
              Buy!
            """;

    public static void main(String[] args) throws  URISyntaxException {

        String jarPath = Main.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toURI()
                .getPath();
        String jarName = jarPath.substring(jarPath.lastIndexOf("/") + 1);

        if (args.length == 0) {
            System.out.println("\n" + jarPath + " " + jarName);
            System.out.println(onNoArgsMessage);
            return;
        }
        if (args[0].equals("-h")) {
            System.out.println("\n" + jarPath + " " + jarName);
            System.out.println(with_h_ArgsMessage);
        }
        if (args[0].equals("-path")) {
            pathToFile = Path.of(args[1]);
            System.out.println("\n" + "Hello. I perform calculation of report for path: " + pathToFile + "\n");
            printReport();
        }
    }

    public static void printReport() {
        Parser parser = new Parser();
        List<Record> recordList = parser.parse(pathToFile);

        ReportGenerator rg = new ReportGenerator();
        Map<String, Duration> firstMap = rg.generate(recordList);   // карта со всеми задачами
        Map<String, Duration> secondMap = rg.noBreaksGenerate(firstMap); // карта с общим временем и без перерывов

        System.out.println("""
                Report:
                ==================""");
        for (Map.Entry<String, Duration> entry : firstMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
        for (Map.Entry<String, Duration> entry : secondMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
        System.out.println("""
                ==================
                 \s
                Buy!""");
    }

}

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Test {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        String outFile = "../out.txt";
        String ansFile = "../ans.txt";

        if (!Files.exists(Paths.get(outFile))) {
            System.out.println(RED + "Output file not found!" + RESET);
            System.exit(1);
        }
        if (!Files.exists(Paths.get(ansFile))) {
            System.out.println(RED + "Answer file not found!" + RESET);
            System.exit(1);
        }

        try {
            List<String> outLinesRaw = Files.readAllLines(Paths.get(outFile));
            List<String> ansLinesRaw = Files.readAllLines(Paths.get(ansFile));

            // 预处理：去除空行和首尾空格
            List<String> outLines = preprocessLines(outLinesRaw);
            List<String> ansLines = preprocessLines(ansLinesRaw);

            int maxLen = Math.max(outLines.size(), ansLines.size());

            for (int i = 0; i < maxLen; i++) {
                String outLine = i < outLines.size() ? outLines.get(i) : "<no line>";
                String ansLine = i < ansLines.size() ? ansLines.get(i) : "<no line>";

                if (!outLine.equals(ansLine)) {
                    System.out.println(RED + "Wrong Answer" + RESET);
                    System.out.println("---------------------");
                    System.out.println(CYAN + "Difference at line " + (i + 1) + RESET);
                    System.out.println(YELLOW + "Expected: " + RESET + ansLine);
                    System.out.println(YELLOW + "Received: " + RESET + outLine);
                    System.exit(1);
                }
            }

            System.out.println(GREEN + "Accepted" + RESET);

        } catch (IOException e) {
            System.out.println(RED + "Error reading files: " + e.getMessage() + RESET);
            System.exit(1);
        }
    }

    private static List<String> preprocessLines(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            String trimmed = line.trim();
            if (!trimmed.isEmpty()) {
                result.add(trimmed);
            }
        }
        return result;
    }
}

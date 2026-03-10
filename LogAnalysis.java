import java.io.*;
import java.util.*;

public class LogAnalysis {

    public static void analyzeLogs(String filePath) throws IOException {

        Map<String, Integer> userCount = new HashMap<>();
        Map<String, Integer> actionCount = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {

            String[] parts = line.split(",");

            String user = parts[1];
            String action = parts[2];

            userCount.put(user, userCount.getOrDefault(user, 0) + 1);
            actionCount.put(action, actionCount.getOrDefault(action, 0) + 1);
        }

        br.close();

        String mostActiveUser = Collections.max(userCount.entrySet(),
                Map.Entry.comparingByValue()).getKey();

        String mostCommonAction = Collections.max(actionCount.entrySet(),
                Map.Entry.comparingByValue()).getKey();

        System.out.println("Most Active User: " + mostActiveUser);
        System.out.println("Most Common Action: " + mostCommonAction);
    }

    public static void main(String[] args) throws IOException {
        analyzeLogs("logs.txt");
    }
}
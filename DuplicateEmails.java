import java.io.*;
import java.util.*;

public class DuplicateEmails {

    public static void findDuplicates(String filePath) throws IOException {

        Set<String> seenEmails = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String email;

        while ((email = br.readLine()) != null) {

            email = email.trim();

            if (seenEmails.contains(email)) {
                duplicates.add(email);
            } else {
                seenEmails.add(email);
            }
        }

        br.close();

        for (String dup : duplicates) {
            System.out.println(dup);
        }
    }

    public static void main(String[] args) throws IOException {
        findDuplicates("emails.txt");
    }
}
import java.io.*;
import java.util.*;

public class TopFrequentWords {

    public static void topKWords(String filePath, int k) throws IOException {

        Map<String, Integer> freq = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String word;

        while ((word = br.readLine()) != null) {
            word = word.trim();
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        br.close();

        PriorityQueue<Map.Entry<String, Integer>> heap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {

            heap.offer(entry);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Map.Entry<String, Integer>> result = new ArrayList<>(heap);
        result.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : result) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        topKWords("words.txt", 10);
    }
}
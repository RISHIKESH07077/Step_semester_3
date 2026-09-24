package string.assignment_problems;

import java.util.*;

public class Stop_Word_Filtered_Word_Frequency {

    public static void printFilteredWordFrequency(String feedback) {

        String cleanedText = feedback.toLowerCase();

        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        String[] words = cleanedText.split("\\s+");

        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        HashMap<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            int currentCount = wordFrequency.getOrDefault(word, 0);

            wordFrequency.put(word, currentCount + 1);
        }

        List<Map.Entry<String, Integer>> wordList =
                new ArrayList<>(wordFrequency.entrySet());

        wordList.sort(
                (entry1, entry2) ->
                        entry2.getValue().compareTo(entry1.getValue())
        );

        for (Map.Entry<String, Integer> entry : wordList) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter feedback paragraph: ");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}
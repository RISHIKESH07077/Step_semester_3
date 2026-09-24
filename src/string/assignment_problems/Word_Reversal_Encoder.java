package string.assignment_problems;

import java.util.Scanner;

public class Word_Reversal_Encoder {

    public static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();

            result.append(reversedWord);
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String result = reverseEachWord(sentence);

        System.out.println("Output: " + result);

        scanner.close();
    }
}
package string.class_problems;

import java.util.Scanner;

public class StringMethodParameter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            int result = countCharacters(text);

            System.out.println("Number of characters: " + result);
        }
    }

    public static int countCharacters(String text) {
        return text.length();
    }
}
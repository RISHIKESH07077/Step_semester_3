package string.class_problems;

import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            showStringDetails(text);
        }
    }

    public static void showStringDetails(String text) {
        System.out.println("Length: " + text.length());
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("First character: " + (text.isEmpty() ? "No character" : text.charAt(0)));
        System.out.println("Contains 'Java': " + text.contains("Java"));
        System.out.println("Trimmed: " + text.trim());
    }
}
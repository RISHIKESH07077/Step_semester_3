package string.class_problems;

import java.util.Scanner;

public class AsciiValues {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a character: ");
            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Please enter only one character.");
                return;
            }

            printAsciiValue(input.charAt(0));
        }
    }

    public static void printAsciiValue(char character) {
        int asciiValue = (int) character;
        System.out.println("ASCII value of '" + character + "' is " + asciiValue);
    }
}
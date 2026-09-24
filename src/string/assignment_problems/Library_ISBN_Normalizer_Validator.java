package string.assignment_problems;

import java.util.Scanner;

public class Library_ISBN_Normalizer_Validator {

    public static String normalizeCode(String raw) {

        String trimmedCode = raw.trim();

        if (trimmedCode.length() < 3) {
            return trimmedCode;
        }

        String publisherCode = trimmedCode.substring(0, 3).toUpperCase();
        String remainingCode = trimmedCode.substring(3);

        return publisherCode + remainingCode;
    }

    public static String validateAndFormat(String code) {

        // Check whether the code has exactly 13 characters
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check the first 3 characters
        for (int i = 0; i < 3; i++) {

            char character = code.charAt(i);

            if (!Character.isLetter(character)) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check the remaining 10 characters
        for (int i = 3; i < 13; i++) {

            char character = code.charAt(i);

            if (!Character.isDigit(character)) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisherCode);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalogNumber);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String rawCode = scanner.nextLine();

        String normalizedCode = normalizeCode(rawCode);

        String result = validateAndFormat(normalizedCode);

        System.out.println(result);

        scanner.close();
    }
}
package practice_problems;

import java.util.Scanner;

public class ReverseCustomerName {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            String reversedName = reverseCustomerName(customerName);

            System.out.println("Original Name: " + customerName);
            System.out.println("Reversed Name: " + reversedName);
        }
    }

    public static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();

        String reversedName = "";

        for (int i = characters.length - 1; i >= 0; i--) {
            reversedName = reversedName + characters[i];
        }

        return reversedName;
    }
}
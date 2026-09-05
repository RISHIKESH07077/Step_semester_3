package string.class_problems;

import java.util.Scanner;

public class StringArray {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of names: ");
            int count = scanner.nextInt();
            scanner.nextLine();

            if (count <= 0) {
                System.out.println("Invalid number.");
                return;
            }

            String[] names = new String[count];

            readNames(scanner, names);
            displayNames(names);
        }
    }

    public static void readNames(Scanner scanner, String[] names) {
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
    }

    public static void displayNames(String[] names) {
        System.out.println("Names entered:");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
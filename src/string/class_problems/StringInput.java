package string.class_problems;

import java.util.Scanner;

public class StringInput {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your city: ");
            String city = scanner.nextLine();

            printDetails(name, city);
        }
    }

    public static void printDetails(String name, String city) {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
    }
}
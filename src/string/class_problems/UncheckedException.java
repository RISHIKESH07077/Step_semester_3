package string.class_problems;

import java.util.Scanner;
import java.util.InputMismatchException;

public class UncheckedException {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            try {
                int result = divideNumber(100, number);
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer.");
        }
    }

    public static int divideNumber(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}
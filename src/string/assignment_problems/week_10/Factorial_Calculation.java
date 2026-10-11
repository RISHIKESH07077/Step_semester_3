package string.assignment_problems.week_10;

import java.util.Scanner;

public class Factorial_Calculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number < 0 || number > 20) {
            System.out.println("Enter a number between 0 and 20");
        } else {
            long factorial = 1;

            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println(factorial);
        }

        sc.close();
    }
}
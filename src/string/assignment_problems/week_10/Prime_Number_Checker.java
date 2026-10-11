package string.assignment_problems.week_10;

import java.util.Scanner;

public class Prime_Number_Checker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        boolean prime = number > 1;

        for (int i = 2; i <= number / i && prime; i++) {
            if (number % i == 0) {
                prime = false;
            }
        }

        if (prime) {
            System.out.println(number + " is prime");
        } else {
            System.out.println(number + " is not prime");
        }

        sc.close();
    }
}
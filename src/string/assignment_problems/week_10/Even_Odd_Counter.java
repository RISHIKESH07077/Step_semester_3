package string.assignment_problems.week_10;

import java.util.Scanner;

public class Even_Odd_Counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int even = 0;
        int odd = 0;

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();

            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
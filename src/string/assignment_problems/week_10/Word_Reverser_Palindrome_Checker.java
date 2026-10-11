package string.assignment_problems.week_10;

import java.util.Scanner;

public class Word_Reverser_Palindrome_Checker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }

        sc.close();
    }
}
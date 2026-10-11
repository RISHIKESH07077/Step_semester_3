package string.assignment_problems.week9;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Library_Late_Fine_Counter {

    static abstract class LibraryItem {
        String title;
        int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double calculateFine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() {
            return daysLate * 2.0;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() {
            return Math.min(daysLate * 5.0, 50.0);
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() {
            return daysLate;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");

            switch (p[0]) {
                case "BOOK":
                    items.add(new Book(p[1],
                            Integer.parseInt(p[2])));
                    break;
                case "DVD":
                    items.add(new DVD(p[1],
                            Integer.parseInt(p[2])));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(p[1],
                            Integer.parseInt(p[2])));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid item type");
            }
        }

        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            total += fine;
            System.out.printf(Locale.US, "%s: %.2f%n", item.title, fine);
        }

        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
        sc.close();
    }
}
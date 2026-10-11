package string.assignment_problems.week_9;

import java.util.Scanner;
import java.util.Locale;

public class Movie_Ticket_Counter {

    static abstract class Ticket {
        private static final double CONVENIENCE_FEE = 20.0;
        private final int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract double getPrice();

        double calculateAmount() {
            return count * (getPrice() + CONVENIENCE_FEE);
        }
    }

    static class Regular extends Ticket {
        Regular(int count) {
            super(count);
        }

        double getPrice() {
            return 150.0;
        }
    }

    static class Premium extends Ticket {
        Premium(int count) {
            super(count);
        }

        double getPrice() {
            return 250.0;
        }
    }

    static class Recliner extends Ticket {
        Recliner(int count) {
            super(count);
        }

        double getPrice() {
            return 400.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String seat = p[0];
            int count = Integer.parseInt(p[1]);

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new Regular(count);
                    break;
                case "PREMIUM":
                    ticket = new Premium(count);
                    break;
                case "RECLINER":
                    ticket = new Recliner(count);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid seat type");
            }

            double amount = ticket.calculateAmount();
            total += amount;

            System.out.printf(Locale.US, "%s: %.2f%n", seat, amount);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
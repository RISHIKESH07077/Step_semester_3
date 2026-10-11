package string.assignment_problems.week8_assignment;

import java.util.Scanner;
import java.util.Locale;

public class The_Canteen_Billing_Counter {

    interface Customer {
        double calculateAmount(double amount);
        String getType();
    }

    static class Student implements Customer {
        public double calculateAmount(double amount) {
            return amount * 0.90;
        }

        public String getType() {
            return "STUDENT";
        }
    }

    static class Staff implements Customer {
        public double calculateAmount(double amount) {
            return amount * 0.95;
        }

        public String getType() {
            return "STAFF";
        }
    }

    static class Guest implements Customer {
        public double calculateAmount(double amount) {
            return amount + 10;
        }

        public String getType() {
            return "GUEST";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new Student();
                    break;
                case "STAFF":
                    customer = new Staff();
                    break;
                case "GUEST":
                    customer = new Guest();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid customer type");
            }

            double finalAmount = customer.calculateAmount(amount);
            total += finalAmount;

            System.out.printf(Locale.US, "%s: %.2f%n",
                    customer.getType(), finalAmount);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
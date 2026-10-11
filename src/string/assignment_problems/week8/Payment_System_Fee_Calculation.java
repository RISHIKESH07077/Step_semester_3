package string.assignment_problems.week8;

import java.util.Scanner;
import java.util.Locale;

public class Payment_System_Fee_Calculation {

    interface Payment {
        double calculateAmount(double amount);
        String getType();
    }

    static class CardPayment implements Payment {
        public double calculateAmount(double amount) {
            return amount * 1.02;
        }

        public String getType() {
            return "CARD";
        }
    }

    static class WalletPayment implements Payment {
        public double calculateAmount(double amount) {
            return amount * 1.01;
        }

        public String getType() {
            return "WALLET";
        }
    }

    static class BankTransferPayment implements Payment {
        public double calculateAmount(double amount) {
            return amount;
        }

        public String getType() {
            return "BANKTRANSFER";
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

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment();
                    break;
                case "WALLET":
                    payment = new WalletPayment();
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransferPayment();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid payment type");
            }

            double adjusted = payment.calculateAmount(amount);
            total += adjusted;

            System.out.printf(Locale.US, "%s: %.2f%n",
                    payment.getType(), adjusted);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
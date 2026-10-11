package string.assignment_problems.week8;

import java.util.Scanner;
import java.util.Locale;

public class Delivery_Fee_Calculator {

    interface Delivery {
        double calculateFee();
        String getType();
    }

    static class StandardDelivery implements Delivery {
        double weight, distance;

        StandardDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double calculateFee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }

        public String getType() {
            return "STANDARD";
        }
    }

    static class ExpressDelivery implements Delivery {
        double weight, distance;

        ExpressDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double calculateFee() {
            return 15 + weight + 0.20 * distance;
        }

        public String getType() {
            return "EXPRESS";
        }
    }

    static class InternationalDelivery implements Delivery {
        double weight, distance, customsFee;

        InternationalDelivery(double weight, double distance,
                             double customsFee) {
            this.weight = weight;
            this.distance = distance;
            this.customsFee = customsFee;
        }

        public double calculateFee() {
            return 25 + 2 * weight + 0.50 * distance + customsFee;
        }

        public String getType() {
            return "INTERNATIONAL";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double weight = Double.parseDouble(p[1]);
            double distance = Double.parseDouble(p[2]);

            Delivery delivery;

            switch (type) {
                case "STANDARD":
                    delivery = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    delivery = new ExpressDelivery(weight, distance);
                    break;
                case "INTERNATIONAL":
                    double customsFee = Double.parseDouble(p[3]);
                    delivery = new InternationalDelivery(
                            weight, distance, customsFee);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid delivery type");
            }

            double fee = delivery.calculateFee();
            total += fee;

            System.out.printf(Locale.US, "%s: %.2f%n",
                    delivery.getType(), fee);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
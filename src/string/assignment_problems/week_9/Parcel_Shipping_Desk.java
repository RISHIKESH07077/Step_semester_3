package string.assignment_problems.week_9;

import java.util.Scanner;
import java.util.Locale;

public class Parcel_Shipping_Desk {

    interface Insurable {
        double calculateInsurance();
    }

    static abstract class Parcel {
        double weight;
        double declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double calculateCharge();

        double getInsurance() {
            if (this instanceof Insurable) {
                return ((Insurable) this).calculateInsurance();
            }
            return 0.0;
        }
    }

    static class Standard extends Parcel {
        Standard(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        double calculateCharge() {
            return 40 + 10 * weight;
        }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        double calculateCharge() {
            return 80 + 15 * weight;
        }

        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        double calculateCharge() {
            return 40 + 10 * weight + 50;
        }

        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double weight = Double.parseDouble(p[1]);
            double value = Double.parseDouble(p[2]);

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new Fragile(weight, value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid parcel type");
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.getInsurance();
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
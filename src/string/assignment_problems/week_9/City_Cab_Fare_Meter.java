package string.assignment_problems.week_9;

import java.util.Scanner;
import java.util.Locale;

public class City_Cab_Fare_Meter {

    interface NightService {
        double applyNightCharge(double fare);
    }

    static abstract class Cab {
        double km;

        Cab(double km) {
            this.km = km;
        }

        abstract double getRate();

        double calculateFare(boolean night) {
            double fare = Math.max(100.0, km * getRate());

            if (night && this instanceof NightService) {
                fare = ((NightService) this).applyNightCharge(fare);
            }

            return fare;
        }

        boolean supportsNightService() {
            return this instanceof NightService;
        }
    }

    static class Mini extends Cab {
        Mini(double km) {
            super(km);
        }

        double getRate() {
            return 10.0;
        }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double km) {
            super(km);
        }

        double getRate() {
            return 14.0;
        }

        public double applyNightCharge(double fare) {
            return fare * 1.20;
        }
    }

    static class SUV extends Cab implements NightService {
        SUV(double km) {
            super(km);
        }

        double getRate() {
            return 18.0;
        }

        public double applyNightCharge(double fare) {
            return fare * 1.20;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double km = Double.parseDouble(p[1]);
            boolean night = p[2].equals("NIGHT");

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }

            if (night && !cab.supportsNightService()) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(night);
            total += fare;

            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
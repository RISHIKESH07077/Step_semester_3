package string.assignment_problems.week8;

import java.util.Scanner;
import java.util.Locale;

public class Public_Transport_Fare_Calculator {

    interface Transport {
        double calculateFare();
        String getType();
    }

    static class Bus implements Transport {
        double distance;

        Bus(double distance) {
            this.distance = distance;
        }

        public double calculateFare() {
            return Math.min(10, 2 + 0.10 * distance);
        }

        public String getType() {
            return "BUS";
        }
    }

    static class Train implements Transport {
        double distance;

        Train(double distance) {
            this.distance = distance;
        }

        public double calculateFare() {
            return 3 + 0.15 * distance;
        }

        public String getType() {
            return "TRAIN";
        }
    }

    static class Metro implements Transport {
        double distance, peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            this.distance = distance;
            this.peakHourFactor = peakHourFactor;
        }

        public double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }

        public String getType() {
            return "METRO";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double distance = Double.parseDouble(p[1]);

            Transport transport;

            switch (type) {
                case "BUS":
                    transport = new Bus(distance);
                    break;
                case "TRAIN":
                    transport = new Train(distance);
                    break;
                case "METRO":
                    double factor = Double.parseDouble(p[2]);
                    transport = new Metro(distance, factor);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid transport type");
            }

            double fare = transport.calculateFare();
            total += fare;

            System.out.printf(Locale.US, "%s: %.2f%n",
                    transport.getType(), fare);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
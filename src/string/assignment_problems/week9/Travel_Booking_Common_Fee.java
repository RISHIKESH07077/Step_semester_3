package string.assignment_problems.week9;

import java.util.Scanner;
import java.util.Locale;

public class Travel_Booking_Common_Fee {

    static abstract class Travel {
        private static final double BOOKING_FEE = 50.0;
        double distance;

        Travel(double distance) {
            this.distance = distance;
        }

        abstract double calculateBaseFare();

        double calculateTotal() {
            return calculateBaseFare() + BOOKING_FEE;
        }
    }

    static class Bus extends Travel {
        Bus(double distance) {
            super(distance);
        }

        double calculateBaseFare() {
            return distance * 2.0;
        }
    }

    static class Train extends Travel {
        Train(double distance) {
            super(distance);
        }

        double calculateBaseFare() {
            return distance * 1.5;
        }
    }

    static class Flight extends Travel {
        Flight(double distance) {
            super(distance);
        }

        double calculateBaseFare() {
            return 2500 + distance * 4.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String mode = p[0];
            double distance = Double.parseDouble(p[1]);

            Travel travel;

            switch (mode) {
                case "BUS":
                    travel = new Bus(distance);
                    break;
                case "TRAIN":
                    travel = new Train(distance);
                    break;
                case "FLIGHT":
                    travel = new Flight(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }

            System.out.printf(Locale.US, "%s: %.2f%n",
                    mode, travel.calculateTotal());
        }

        sc.close();
    }
}
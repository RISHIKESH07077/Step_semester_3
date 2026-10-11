package string.assignment_problems.week8_assignment;

import java.util.Scanner;
import java.util.Locale;

public class The_Campus_Parking_Charge_Calculator {

    interface Vehicle {
        double calculateCharge();
        String getType();
    }

    static class Bike implements Vehicle {
        int hours;

        Bike(int hours) {
            this.hours = hours;
        }

        public double calculateCharge() {
            return hours * 10.0;
        }

        public String getType() {
            return "BIKE";
        }
    }

    static class Car implements Vehicle {
        int hours;

        Car(int hours) {
            this.hours = hours;
        }

        public double calculateCharge() {
            return 30 + (hours - 1) * 20.0;
        }

        public String getType() {
            return "CAR";
        }
    }

    static class Truck implements Vehicle {
        int hours;

        Truck(int hours) {
            this.hours = hours;
        }

        public double calculateCharge() {
            return Math.max(100, hours * 50.0);
        }

        public String getType() {
            return "TRUCK";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            Vehicle vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;
                case "CAR":
                    vehicle = new Car(hours);
                    break;
                case "TRUCK":
                    vehicle = new Truck(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid vehicle type");
            }

            double charge = vehicle.calculateCharge();
            total += charge;

            System.out.printf(Locale.US, "%s: %.2f%n",
                    vehicle.getType(), charge);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
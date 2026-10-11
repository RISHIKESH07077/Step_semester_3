package string.assignment_problems.week8_assignment;

import java.util.Scanner;
import java.util.Locale;

public class The_Hostel_Electricity_Bill {

    interface Room {
        double calculateBill();
        String getType();
    }

    static class SingleRoom implements Room {
        int units;

        SingleRoom(int units) {
            this.units = units;
        }

        public double calculateBill() {
            return units * 8.0;
        }

        public String getType() {
            return "SINGLE";
        }
    }

    static class SharedRoom implements Room {
        int units;
        int occupants;

        SharedRoom(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }

        public double calculateBill() {
            return units * 6.0 / occupants;
        }

        public String getType() {
            return "SHARED";
        }
    }

    static class ACRoom implements Room {
        int units;

        ACRoom(int units) {
            this.units = units;
        }

        public double calculateBill() {
            return units * 10.0 + 200;
        }

        public String getType() {
            return "AC";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = Integer.parseInt(parts[2]);
                    room = new SharedRoom(units, occupants);
                    break;
                case "AC":
                    room = new ACRoom(units);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid room type");
            }

            double bill = room.calculateBill();
            total += bill;

            System.out.printf(Locale.US, "%s: %.2f%n",
                    room.getType(), bill);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
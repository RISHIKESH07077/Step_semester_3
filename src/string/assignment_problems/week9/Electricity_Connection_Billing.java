package string.assignment_problems.week9;

import java.util.Scanner;
import java.util.Locale;

public class Electricity_Connection_Billing {

    static abstract class Connection {
        int units;

        Connection(int units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class Home extends Connection {
        Home(int units) {
            super(units);
        }

        double calculateBill() {
            if (units <= 100) {
                return units * 5.0;
            }

            return 100 * 5.0 + (units - 100) * 7.0;
        }
    }

    static class Shop extends Connection {
        Shop(int units) {
            super(units);
        }

        double calculateBill() {
            return units * 8.0 + 100;
        }
    }

    static class Factory extends Connection {
        Factory(int units) {
            super(units);
        }

        double calculateBill() {
            return Math.max(units * 6.0, 1000.0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            int units = Integer.parseInt(p[1]);

            Connection connection;

            switch (type) {
                case "HOME":
                    connection = new Home(units);
                    break;
                case "SHOP":
                    connection = new Shop(units);
                    break;
                case "FACTORY":
                    connection = new Factory(units);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid connection type");
            }

            double bill = connection.calculateBill();
            total += bill;

            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
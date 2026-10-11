package string.assignment_problems.week_9;

import java.util.Scanner;
import java.util.Locale;

public class Home_Appliance_Energy_Report {

    interface SaverMode {
        double getSaverFactor();
    }

    static abstract class Appliance {
        double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double getPowerWatts();

        boolean supportsSaver() {
            return this instanceof SaverMode;
        }

        double calculateUnits(boolean saver) {
            double units = getPowerWatts() * hours / 1000.0;

            if (saver && this instanceof SaverMode) {
                units *= ((SaverMode) this).getSaverFactor();
            }

            return units;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }

        double getPowerWatts() {
            return 150.0;
        }
    }

    static class AC extends Appliance implements SaverMode {
        AC(double hours) {
            super(hours);
        }

        double getPowerWatts() {
            return 1500.0;
        }

        public double getSaverFactor() {
            return 0.75;
        }
    }

    static class TV extends Appliance {
        TV(double hours) {
            super(hours);
        }

        double getPowerWatts() {
            return 100.0;
        }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) {
            super(hours);
        }

        double getPowerWatts() {
            return 500.0;
        }

        public double getSaverFactor() {
            return 0.75;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double hours = Double.parseDouble(p[1]);
            boolean saver = p.length > 2 && p[2].equals("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid appliance type");
            }

            if (saver && !appliance.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(saver);
            double cost = units * 8.0;
            totalCost += cost;

            System.out.printf(Locale.US,
                    "%s: Units=%.2f Cost=%.2f%n", type, units, cost);
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
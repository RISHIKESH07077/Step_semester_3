package string.assignment_problems.week9;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Weekly_Staff_Pay {

    static abstract class Staff {
        String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double calculatePay();
    }

    static class FullTime extends Staff {
        double salary;

        FullTime(String name, double salary) {
            super(name);
            this.salary = salary;
        }

        double calculatePay() {
            return salary;
        }
    }

    static class Hourly extends Staff {
        double hours, rate;

        Hourly(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double calculatePay() {
            return Math.min(hours, 40) * rate
                    + Math.max(0, hours - 40) * rate * 1.5;
        }
    }

    static class Intern extends Staff {
        double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double calculatePay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Staff> staffList = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");

            switch (p[0]) {
                case "FULLTIME":
                    staffList.add(new FullTime(p[1],
                            Double.parseDouble(p[2])));
                    break;
                case "HOURLY":
                    staffList.add(new Hourly(p[1],
                            Double.parseDouble(p[2]),
                            Double.parseDouble(p[3])));
                    break;
                case "INTERN":
                    staffList.add(new Intern(p[1],
                            Double.parseDouble(p[2])));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid staff type");
            }
        }

        for (Staff staff : staffList) {
            double pay = staff.calculatePay();
            total += pay;
            System.out.printf(Locale.US, "%s: %.2f%n", staff.name, pay);
        }

        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
        sc.close();
    }
}
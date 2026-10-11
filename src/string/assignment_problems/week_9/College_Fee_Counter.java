package string.assignment_problems.week_9;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class College_Fee_Counter {

    interface BusUser {
        double getTransportFee();
    }

    static abstract class Student {
        String name;

        Student(String name) {
            this.name = name;
        }

        abstract double calculateTuition();

        double calculateTotalFee() {
            double transport = this instanceof BusUser
                    ? ((BusUser) this).getTransportFee() : 0.0;

            return calculateTuition() + transport;
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        double calculateTuition() {
            return 40000.0;
        }

        public double getTransportFee() {
            return 12000.0;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        double calculateTuition() {
            return 100000.0;
        }
    }

    static class Scholar extends Student implements BusUser {
        Scholar(String name) {
            super(name);
        }

        double calculateTuition() {
            return 20000.0;
        }

        public double getTransportFee() {
            return 12000.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Student> students = new ArrayList<>();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");

            switch (p[0]) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(p[1]));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(p[1]));
                    break;
                case "SCHOLAR":
                    students.add(new Scholar(p[1]));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }
        }

        for (Student student : students) {
            double fee = student.calculateTotalFee();
            totalCollected += fee;

            System.out.printf(Locale.US, "%s: %.2f%n", student.name, fee);
        }

        System.out.printf(Locale.US,
                "Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
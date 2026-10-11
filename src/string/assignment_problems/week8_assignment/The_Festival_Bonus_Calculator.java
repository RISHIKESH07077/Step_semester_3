package string.assignment_problems.week8_assignment;

import java.util.Scanner;
import java.util.Locale;

public class The_Festival_Bonus_Calculator {

    interface Employee {
        double calculateBonus();
        String getName();
    }

    static class FullTimeEmployee implements Employee {
        String name;
        double salary;

        FullTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double calculateBonus() {
            return salary * 0.10;
        }

        public String getName() {
            return name;
        }
    }

    static class PartTimeEmployee implements Employee {
        String name;
        double salary;

        PartTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double calculateBonus() {
            return salary * 0.05;
        }

        public String getName() {
            return name;
        }
    }

    static class Intern implements Employee {
        String name;

        Intern(String name, double salary) {
            this.name = name;
        }

        public double calculateBonus() {
            return 2000.0;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            Employee employee;

            switch (type) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    employee = new Intern(name, salary);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid employee type");
            }

            double bonus = employee.calculateBonus();
            total += bonus;

            System.out.printf(Locale.US, "%s: %.2f%n",
                    employee.getName(), bonus);
        }

        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
        sc.close();
    }
}
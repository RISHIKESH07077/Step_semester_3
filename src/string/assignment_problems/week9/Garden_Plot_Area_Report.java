package string.assignment_problems.week9;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Garden_Plot_Area_Report {

    static abstract class Plot {
        String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract double calculateArea();

        abstract String getShape();
    }

    static class Circle extends Plot {
        double radius;

        Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        double calculateArea() {
            return Math.PI * radius * radius;
        }

        String getShape() {
            return "CIRCLE";
        }
    }

    static class Rectangle extends Plot {
        double length, width;

        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        double calculateArea() {
            return length * width;
        }

        String getShape() {
            return "RECTANGLE";
        }
    }

    static class Triangle extends Plot {
        double base, height;

        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        double calculateArea() {
            return 0.5 * base * height;
        }

        String getShape() {
            return "TRIANGLE";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plot> plots = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");

            switch (p[0]) {
                case "CIRCLE":
                    plots.add(new Circle(p[1],
                            Double.parseDouble(p[2])));
                    break;
                case "RECTANGLE":
                    plots.add(new Rectangle(p[1],
                            Double.parseDouble(p[2]),
                            Double.parseDouble(p[3])));
                    break;
                case "TRIANGLE":
                    plots.add(new Triangle(p[1],
                            Double.parseDouble(p[2]),
                            Double.parseDouble(p[3])));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid shape");
            }
        }

        for (Plot plot : plots) {
            double area = plot.calculateArea();
            total += area;

            System.out.printf(Locale.US, "%s (%s): %.2f%n",
                    plot.owner, plot.getShape(), area);
        }

        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
        sc.close();
    }
}
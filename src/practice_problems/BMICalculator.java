package practice_problems;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        final int people = 3;

        double[] heights = new double[people];
        double[] weights = new double[people];

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < people; i++) {
                System.out.print("Enter height of person " + (i + 1) + " in meters: ");
                heights[i] = scanner.nextDouble();

                System.out.print("Enter weight of person " + (i + 1) + " in kg: ");
                weights[i] = scanner.nextDouble();
            }
        }

        printWellnessReport(heights, weights);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println();
        System.out.println("Person | Height | Weight | BMI | Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%d      | %.2f m | %.2f kg | %.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }
}
package string.assignment_problems.week_10;

import java.util.Scanner;
import java.util.Locale;

public class Student_Result_Card_Generator {

    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double calculateAverage() {
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            return total / (double) marks.length;
        }

        String calculateGrade(double average) {
            if (average >= 75) {
                return "B";
            } else if (average >= 60) {
                return "C";
            } else if (average >= 40) {
                return "D";
            } else {
                return "F";
            }
        }

        void displayResult() {
            double average = calculateAverage();
            String grade = calculateGrade(average);

            System.out.printf(
                    Locale.US,
                    "%s: Average %.1f, Grade %s%n",
                    name.toUpperCase(Locale.ROOT),
                    average,
                    grade
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String name = sc.next();
            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                marks[i] = sc.nextInt();
            }

            Student student = new Student(name, marks);
            student.displayResult();
        }

        sc.close();
    }
}
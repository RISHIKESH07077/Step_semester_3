package string.assignment_problems;

public class Simple_Student_Record {

    static class Student {
        String name;
        int marks;
    }

    public static void main(String[] args) {

        Student student = new Student();

        student.name = "RISHIKESH";
        student.marks = 99;

        System.out.println("Name: " + student.name + " | Marks: " + student.marks);
    }
}
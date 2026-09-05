package string.class_problems;

public class ArrayException {
    public static void main(String[] args) {
        String[] languages = {"Java", "Python", "C"};

        try {
            System.out.println(languages[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of range.");
        }
    }
}
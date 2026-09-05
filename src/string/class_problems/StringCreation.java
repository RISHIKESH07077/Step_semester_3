package string.class_problems;

public class StringCreation {
    public static void main(String[] args) {
        String firstString = "Hello Java";
        String secondString = new String("Welcome");

        char[] letters = {'J', 'a', 'v', 'a'};
        String thirdString = new String(letters);

        System.out.println(firstString);
        System.out.println(secondString);
        System.out.println(thirdString);
    }
}
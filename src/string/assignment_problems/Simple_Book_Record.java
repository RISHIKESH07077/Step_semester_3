package string.assignment_problems;

public class Simple_Book_Record {

    static class Book {
        String title;
        double price;
    }

    public static void main(String[] args) {
        Book book = new Book();

        book.title = "Clean Code";
        book.price = 650.0;

        System.out.println("Title: " + book.title + " | Price: Rs " + book.price);
    }
}
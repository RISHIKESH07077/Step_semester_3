package string.assignment_problems.week8;

import java.time.LocalDate;
import java.util.Scanner;

public class Library_Item_Due_Date_Calculator {

    interface LibraryItem {
        int getBorrowingDays();
    }

    static class Book implements LibraryItem {
        public int getBorrowingDays() {
            return 14;
        }
    }

    static class DVD implements LibraryItem {
        public int getBorrowingDays() {
            return 7;
        }
    }

    static class Magazine implements LibraryItem {
        public int getBorrowingDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book();
                    break;
                case "DVD":
                    item = new DVD();
                    break;
                case "MAGAZINE":
                    item = new Magazine();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid item type");
            }

            LocalDate dueDate =
                    currentDate.plusDays(item.getBorrowingDays());

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}
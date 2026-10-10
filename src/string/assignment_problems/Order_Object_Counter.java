package string.assignment_problems;

public class Order_Object_Counter {

    static class Order {
        static int totalOrders = 0;

        Order() {
            totalOrders++;
        }
    }

    public static void main(String[] args) {
        new Order();
        new Order();
        new Order();
        new Order();

        System.out.println("Total orders: " + Order.totalOrders);
    }
}
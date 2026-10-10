package string.assignment_problems;

public class Product_Constructor {

    static class Product {
        String productId;
        String productName;

        Product(String productId, String productName) {
            this.productId = productId;
            this.productName = productName;
        }
    }

    public static void main(String[] args) {
        Product product = new Product("P-1042", "Wireless Mouse");

        System.out.println(product.productId + " - " + product.productName);
    }
}
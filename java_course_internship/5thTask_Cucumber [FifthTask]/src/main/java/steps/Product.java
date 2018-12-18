package steps;

public class Product {
    private static int productID;

    public Product(int product) {
        this.productID = product;
    }

    public static void getData() {
        System.out.println("Product " + productID + " was ordered");
    }
}

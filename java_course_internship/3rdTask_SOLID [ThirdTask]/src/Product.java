public class Product {
    private static int productID;

    public Product(int product) {
        this.productID = product;
    }

    public static void getProductID() {
        System.out.println("Product " + productID + " was ordered");
    }
}

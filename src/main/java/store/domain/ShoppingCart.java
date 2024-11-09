package store.domain;

public class ShoppingCart {
    private String productName;
    private int quantity;

    ShoppingCart(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}

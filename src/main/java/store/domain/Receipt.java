package store.domain;

public class Receipt {
    private String productName;
    private int productPrice;
    private int productQuantity;
    private int promotionQuantity;

    public Receipt(String productName, int productPrice, int productQuantity, int promotionQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.promotionQuantity = promotionQuantity;
    }
}

package store.domain;

import java.text.NumberFormat;
import java.util.HashSet;

public class Product {
    private final String name;
    private final int price;
    private final int quantity;
    private final String promotion;

    public Product(String name, int price, int quantity, String promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPromotion() {
        return !promotion.equals("null") ? promotion : "";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String formattedPrice = numberFormat.format(price);

        String quantityString = String.valueOf(quantity) + "개";
        if (quantity == 0) quantityString = "재고 없음 ";

        return name + " " + formattedPrice + "원 " + quantityString + (promotion.equals("null") ? "" : " " + promotion);
    }
}

package store.domain;

import java.text.NumberFormat;

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

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String formattedPrice = numberFormat.format(price);

        return name + " " + formattedPrice + "원 " + quantity + "개 " + promotion;
    }
}

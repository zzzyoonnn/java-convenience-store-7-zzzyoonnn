package store.domain;

import java.util.HashMap;

public class ReceiptManagement {
    private HashMap<String, Receipt> receiptMap;

    public void ReceiptManager() {
        receiptMap = new HashMap<>();
    }

    public void addReceipt(String productName, int productPrice, int productQuantity, int promotionQuantity) {
        Receipt newReceipt = new Receipt(productName, productPrice, productQuantity, promotionQuantity);
        receiptMap.put(productName, newReceipt);
    }

    public Receipt getReceipt(String productName) {
        return receiptMap.get(productName);
    }
}

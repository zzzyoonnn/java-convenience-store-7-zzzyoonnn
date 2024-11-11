package store.domain;

import java.util.HashMap;

public class ReceiptManagement {
    private HashMap<String, Receipt> receiptMap;

    public void ReceiptManager() {
        receiptMap = new HashMap<>();
    }

    public void addOrUpdateReceipt(String productName, int productPrice, int productQuantity, int promotionQuantity) {
        if (receiptMap.containsKey(productName)) {
            // 기존 데이터를 수정
            Receipt existingReceipt = receiptMap.get(productName);
            existingReceipt.setProductPrice(productPrice);
            existingReceipt.setProductQuantity(productQuantity);
            existingReceipt.setPromotionQuantity(promotionQuantity);
        } else {
            // 새로운 데이터를 추가
            Receipt newReceipt = new Receipt(productName, productPrice, productQuantity, promotionQuantity);
            receiptMap.put(productName, newReceipt);
        }
    }

    public Receipt getReceipt(String productName) {
        return receiptMap.get(productName);
    }
}

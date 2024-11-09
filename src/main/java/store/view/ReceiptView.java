package store.view;

import static store.message.ReceiptMessage.RECEIPT_BONUS;
import static store.message.ReceiptMessage.RECEIPT_BOUNDARY;
import static store.message.ReceiptMessage.RECEIPT_TITLE;

public class ReceiptView {
    public static void displayReceiptTitle() {
        System.out.println(RECEIPT_TITLE.getMessage());
    }

    public static void displayReceiptBonus() {
        System.out.println(RECEIPT_BONUS.getMessage());
    }

    public static void displayReceiptBoundary() {
        System.out.println(RECEIPT_BOUNDARY.getMessage());
    }
}

package store.view;

import static store.message.StaffMessage.ASK_ADD_PROMOTIONAL_ITEM;
import static store.message.StaffMessage.ASK_NO_PROMOTION_PAYMENT;
import static store.message.StaffMessage.REQUEST_PRODUCT_NAME_AND_QUANTITY;
import static store.message.StaffMessage.WELCOME_GREETING;

public class StaffView {
    public static void displayWelcomeGreeting() {
        System.out.println(WELCOME_GREETING.getMessage());
    }

    public static void displayRequestProductNameAndQuantity() {
        System.out.println(REQUEST_PRODUCT_NAME_AND_QUANTITY.getMessage());
    }

    public static void displayAskNoPromotionPayment() {
        System.out.println(ASK_NO_PROMOTION_PAYMENT.getMessage());
    }

    public static void displayAskAddPromotionalItem() {
        System.out.println(ASK_ADD_PROMOTIONAL_ITEM.getMessage());
    }
}

package store.view;

import static store.message.StaffMessage.REQUEST_PRODUCT_NAME_AND_QUANTITY;
import static store.message.StaffMessage.WELCOME_GREETING;

public class StaffView {
    public static void displayWelcomeGreeting() {
        System.out.println(WELCOME_GREETING.getMessage());
    }

    public static void displayRequestProductNameAndQuantity() {
        System.out.println(REQUEST_PRODUCT_NAME_AND_QUANTITY.getMessage());
    }
}

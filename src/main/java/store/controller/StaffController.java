package store.controller;

import store.domain.User;
import store.view.PosMachineView;
import store.view.StaffView;

public class StaffController {
    private static User user;

    public StaffController() {
    }

    public StaffController(User user) {
        this.user = user;
    }

    public static void welcomeCustomer() {
        StaffView.displayWelcomeGreeting();
        PosMachineView.getInventoryInformation();
    }

    public static void requestProductNameAndQuantity() {
        StaffView.displayRequestProductNameAndQuantity();
        user = User.enterUser();
    }

    public static boolean listenUserAnswer() {
        return (User.answerQuestion().equals("Y"));
    }

    public static boolean askCancelPromotion() {
        StaffView.displayAskNoPromotionPayment();
        return listenUserAnswer();
    }

    public static boolean askAddPromotionalItem() {
        StaffView.displayAskAddPromotionalItem();
        return listenUserAnswer();
    }
}

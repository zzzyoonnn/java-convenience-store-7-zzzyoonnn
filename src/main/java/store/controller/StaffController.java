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

    public static void askCancelPromotion() {
        StaffView.displayAskNoPromotionPayment();
        listenUserAnswer();
        // true -> 일반 결제
        // false -> 제거
    }

    public static void askAddPromotionalItem() {
        StaffView.displayAskAddPromotionalItem();
        listenUserAnswer();
        // true -> 증정품 추가
        // false -> 추가 X
    }
}

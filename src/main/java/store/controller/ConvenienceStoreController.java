package store.controller;

import store.view.ReceiptView;

public class ConvenienceStoreController {
    static PosMachineController posMachineController = new PosMachineController();
    static StaffController staffController = new StaffController();

    public static void open() {
        posMachineController.initialize();
        // 재구매 요청 시
        staffController.welcomeCustomer();
        staffController.requestProductNameAndQuantity();
        posMachineController.findPromotionProduct();
        // 영수증 출력하기
    }
}

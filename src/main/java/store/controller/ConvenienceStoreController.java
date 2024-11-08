package store.controller;

public class ConvenienceStoreController {
    static PosMachineController posMachineController = new PosMachineController();
    static StaffController staffController = new StaffController();

    public static void open() {
        // 재고 관리하기
        posMachineController.initialize();
        staffController.welcomeCustomer();
        // 영수증 출력하기
    }
}

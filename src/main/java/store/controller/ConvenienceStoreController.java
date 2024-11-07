package store.controller;

import store.view.ConvenienceStoreView;

public class ConvenienceStoreController {
    static PosMachineController posMachineController = new PosMachineController();

    public static void open() {
        // 재고 관리하기
        posMachineController.initialize();
        ConvenienceStoreView.displayWelcomeGreeting();
        // 손님 받기
        // 영수증 출력하기
    }
}

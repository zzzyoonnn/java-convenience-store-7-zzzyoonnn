package store.controller;

import store.view.ConvenienceStoreView;
import store.view.PosMachineView;

public class ConvenienceStoreController {
    static PosMachineController posMachineController = new PosMachineController();

    public static void open() {
        // 재고 관리하기
        posMachineController.initialize();
        ConvenienceStoreView.displayWelcomeGreeting();
        PosMachineView.getInventoryInformation();
        // 손님 받기
        // 영수증 출력하기
    }
}

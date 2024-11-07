package store.controller;

import store.view.ConvenienceStoreView;

public class ConvenienceStoreController {
    static InventoryController inventoryController = new InventoryController();

    public static void open() {
        // 재고 관리하기
        inventoryController.createInventory();
        ConvenienceStoreView.displayWelcomeGreeting();
        // 손님 받기
        // 영수증 출력하기
    }
}

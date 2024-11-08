package store.controller;

import store.view.ConvenienceStoreView;
import store.view.PosMachineView;

public class StaffController {
    public static void welcomeCustomer() {
        ConvenienceStoreView.displayWelcomeGreeting();
        PosMachineView.getInventoryInformation();
    }
}

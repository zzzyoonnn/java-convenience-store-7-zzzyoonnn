package store.controller;

import camp.nextstep.edu.missionutils.Console;
import store.view.StaffView;
import store.view.PosMachineView;

public class StaffController {
    public static void welcomeCustomer() {
        StaffView.displayWelcomeGreeting();
        PosMachineView.getInventoryInformation();
    }

    public static void requestProductNameAndQuantity() {
        StaffView.displayRequestProductNameAndQuantity();

        String buyingList = Console.readLine();
    }
}

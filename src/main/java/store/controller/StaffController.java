package store.controller;

import camp.nextstep.edu.missionutils.Console;
import store.domain.User;
import store.view.StaffView;
import store.view.PosMachineView;

public class StaffController {
    public static void welcomeCustomer() {
        StaffView.displayWelcomeGreeting();
        PosMachineView.getInventoryInformation();
    }

    public static void requestProductNameAndQuantity() {
        while (true) {
            try {
                StaffView.displayRequestProductNameAndQuantity();
                User user = new User(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

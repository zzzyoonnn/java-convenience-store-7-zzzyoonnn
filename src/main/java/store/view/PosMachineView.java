package store.view;

import store.controller.PosMachineController;

public class PosMachineView {
    public static void getInventoryInformation() {
        System.out.println(PosMachineController.getInventoryInformation());
    }
}

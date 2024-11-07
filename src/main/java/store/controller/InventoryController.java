package store.controller;

import java.io.File;

public class InventoryController {
    public static void createInventory(){
        String filePath = "src/main/resources/products.md";
        System.out.println(hasProductsFile(filePath));
        // Inventory 객체 생성하기
    }

    private static boolean hasProductsFile(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
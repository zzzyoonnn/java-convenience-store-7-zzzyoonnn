package store.inventory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.controller.InventoryController;

public class InventoryTest {
    @Test
    @DisplayName("products.md 파일이 존재하는지 확인된다.")
    public void testIsExistenceOfProductsFile() {
        String filePath = "src/main/resources/products.md";
        assertTrue(InventoryController.hasProductsFile(filePath));
    }

    @Test
    @DisplayName("products.md 파일이 존재하는지 확인되지 않는다.")
    public void testIsNotExistenceOfProductsFile() {
        String filePath = "src/main/resources/product.md";
        assertFalse(InventoryController.hasProductsFile(filePath));
    }
}

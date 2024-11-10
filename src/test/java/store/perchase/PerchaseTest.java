package store.perchase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.controller.PosMachineController;

public class PerchaseTest {
    @BeforeEach
    public void setUp() {
        // Clear and set up productSet before each test
        PosMachineController.productSet.clear();
        PosMachineController.productSet.add("콜라");
        PosMachineController.productSet.add("사이다");
        PosMachineController.productSet.add("팝콘");
    }

    @Test
    @DisplayName("보유하고 있는 제품을 확인할 수 있다.")
    public void testIsExistProduct() {
        String userProduct = "콜라";
        assertDoesNotThrow(() -> PosMachineController.isExistProduct(userProduct));
    }
}

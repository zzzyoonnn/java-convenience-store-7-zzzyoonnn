package store.perchase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static store.controller.PromotionController.productSet;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.controller.PromotionController;

public class PerchaseTest {
    private PromotionController promotionController;

    @BeforeEach
    public void setUp() {
        productSet = new HashSet<>();
        productSet.add("콜라");
        productSet.add("사이다");
        productSet.add("팝콘");

        promotionController = new PromotionController(List.of(), List.of(), productSet);
    }

    @Test
    @DisplayName("보유하고 있는 제품을 확인할 수 있다.")
    public void testIsExistProduct() {
        String userProduct = "콜라";
        assertDoesNotThrow(() -> PromotionController.isExistProduct(userProduct, 0));
    }
}

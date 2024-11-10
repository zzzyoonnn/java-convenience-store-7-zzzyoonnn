package store.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import store.domain.Product;
import store.domain.Promotion;

public class ConvenienceStoreController {
    static HashSet<String> productSet = new HashSet<>();
    static List<Product> products = new ArrayList<>();
    static List<Promotion> promotions = new ArrayList<>();

    static PosMachineController posMachineController = new PosMachineController(products, promotions, productSet);
    static StaffController staffController = new StaffController();
    static PromotionController promotionController = new PromotionController(products, promotions, productSet);

    public static void open() {
        posMachineController.initialize();
        // 재구매 요청 시
        staffController.welcomeCustomer();
        staffController.requestProductNameAndQuantity();
        promotionController.findPromotionProduct();
        // 영수증 출력하기
    }
}

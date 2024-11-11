package store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import store.domain.Product;
import store.domain.Promotion;
import store.domain.Receipt;

public class ConvenienceStoreController {
    static HashSet<String> productSet = new HashSet<>();
    static List<Product> products = new ArrayList<>();
    static List<Promotion> promotions = new ArrayList<>();
    static HashMap<String, Receipt> receiptMap = new HashMap<>();

    static PosMachineController posMachineController = new PosMachineController(products, promotions, productSet, receiptMap);
    static StaffController staffController = new StaffController();
    static PromotionController promotionController = new PromotionController(products, promotions, productSet, receiptMap);

    public static void open() {
        posMachineController.initialize();
        // 재구매 요청 시
        staffController.welcomeCustomer();
        staffController.requestProductNameAndQuantity();
        promotionController.findPromotionProduct();
        // 영수증 출력하기
    }
}

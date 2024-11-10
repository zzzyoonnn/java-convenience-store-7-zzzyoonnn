package store.controller;

import static store.controller.ConvenienceStoreController.posMachineController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import store.domain.Product;
import store.domain.Promotion;
import store.domain.ShoppingCart;
import store.domain.User;
import store.message.StaffErrorMessage;

public class PromotionController {
    private User user;
    public static List<Product> products;
    public static HashSet<String> productSet;
    private static List<Promotion> promotions;

    public PromotionController(List<Product> products, List<Promotion> promotions, HashSet<String> productSet) {
        this.products = products;
        this.promotions = promotions;
        this.productSet = productSet;
    }

    private static void meetsPromotionCriteria(int userQuantity, Promotion promotion) {
        System.out.println("meetsPromotionCriteria");
        if (promotion.getBuy() > userQuantity) {
            StaffController.askCancelPromotion();
        }
        // 구매하기
    }

    private static void isPromotionApplicable(String userProduct, int userQuantity, Product product,
                                              Promotion promotion) {
        System.out.println("isPromotionApplicable");
        if (promotion.getBuy() <= product.getQuantity()) {
            meetsPromotionCriteria(userQuantity, promotion);
        }
        // 일반 구매 및 제품 제거 중 선택하기
    }

    private static void findPromotion(String userProduct, int userQuantity, Product product) {
        System.out.println("findPromotion");

        for (Promotion promotion : promotions) {
            if (product.getName().equals(userProduct) && product.getPromotion().equals(promotion.getName())) {
                System.out.println("findPromotion");
                isPromotionApplicable(userProduct, userQuantity, product, promotion);
            }
        }
    }

    private static void isPromotionProduct(String userProduct, int userQuantity) {
        System.out.println("isPromotionProduct");
        System.out.println(products.size());

        for (Product product : products) {
            System.out.println(product.getPromotion());
            if (!product.getPromotion().isEmpty()) {
                findPromotion(userProduct, userQuantity, product);
            }
        }
        // 결제하기
    }

    public static void isExistProduct(String userProduct, int userQuantity) {
        try {
            if (!productSet.contains(userProduct)) {
                throw new IllegalArgumentException(StaffErrorMessage.IS_NOT_EXIST.getFormattedMessage());
            }
            isPromotionProduct(userProduct, userQuantity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            User.enterUser();
        }
    }

    public static void findPromotionProduct() {
        User user = User.getUser();
        ArrayList<ShoppingCart> userItems = user.userBuyingMemo();
        for (int i = 0; i < userItems.size(); i++) {
            String userProduct = userItems.get(i).getProductName();
            int userQuantity = userItems.get(i).getQuantity();
            isExistProduct(userProduct, userQuantity);
            for (Product product : products) {
            }
        }
    }
}

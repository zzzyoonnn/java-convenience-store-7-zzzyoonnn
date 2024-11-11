package store.controller;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import store.domain.Product;
import store.domain.Promotion;
import store.domain.ShoppingCart;
import store.domain.User;
import store.message.StaffErrorMessage;
import store.view.StaffView;

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

    private static void hasTakenPromotionalItem(String userProduct, int userQuantity, Product product,
                                                Promotion promotion) {
        if (userQuantity == promotion.getBuy()) {
            StaffController.askAddPromotionalItem();
        }
        // Recipt에 추가하기
    }

    private static void hasSufficientPromotionStock(String userProduct, int userQuantity, Product product,
                                                    Promotion promotion) {
        if (promotion.getBuy() + promotion.getGet() <= product.getQuantity()) {
            // hasTakenPromotionalItem
        }

        if (promotion.getBuy() + promotion.getGet() > product.getQuantity()) {
            StaffController.askCancelPromotion();
        }
    }

    private static void isPromotionApplicable(String userProduct, int userQuantity, Product product,
                                              Promotion promotion) {
        //while (userQuantity > 0) {
        hasSufficientPromotionStock(userProduct, userQuantity, product, promotion);
        //}
    }

    private static boolean compareDates(String nowDate, String promotionStartDate, String promotionEndDate) {
        return nowDate.compareTo(promotionStartDate) >= 0 && nowDate.compareTo(promotionEndDate) <= 0;
    }

    private static boolean checkDate(Promotion promotion) {
        String nowDate = DateTimes.now().toString().split("T")[0];
        String promotionStartDate = promotion.getStart_date();
        String promotionEndDate = promotion.getEnd_date();
        return compareDates(nowDate, promotionStartDate, promotionEndDate);
    }

    private static void findPromotion(String userProduct, int userQuantity, Product product) {
        for (Promotion promotion : promotions) {
            if (checkDate(promotion) && product.getName().equals(userProduct) && product.getPromotion().equals(promotion.getName())) {
                isPromotionApplicable(userProduct, userQuantity, product, promotion);
            }
        }
    }

    private static void isPromotionProduct(String userProduct, int userQuantity) {
        for (Product product : products) {
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

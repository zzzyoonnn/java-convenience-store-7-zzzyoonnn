package store.controller;

import camp.nextstep.edu.missionutils.DateTimes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import store.domain.Product;
import store.domain.Promotion;
import store.domain.Receipt;
import store.domain.ShoppingCart;
import store.domain.User;
import store.message.StaffErrorMessage;

public class PromotionController {
    private User user;
    public static List<Product> products;
    public static HashSet<String> productSet;
    private static List<Promotion> promotions;
    private static HashMap<String, Receipt> receiptMap;

    public PromotionController(List<Product> products, List<Promotion> promotions, HashSet<String> productSet, HashMap<String, Receipt> receiptMap) {
        this.products = products;
        this.promotions = promotions;
        this.productSet = productSet;
        this.receiptMap = receiptMap;
    }

    private static boolean isInReceipt(String userProduct) {
        return receiptMap.containsKey(userProduct);
    }

    private static void hasTakenPromotionalItem(String userProduct, int userQuantity, Product product,
                                                Promotion promotion, boolean isInReceipt) {
        if (userQuantity == promotion.getBuy()) {
            if (StaffController.askAddPromotionalItem()) {
//                int promotionQuantity = promotion.getGet();
//                userQuantity -= promotionQuantity;
//                product.setQuantity(product.getQuantity() - promotionQuantity);
                // 증정품 추가
            }
            // 증정품 추가 X
        }
        // Recipt에 추가하기
    }

    private static boolean hasSufficientPromotionStock(Product product,
                                                    Promotion promotion) {
        return promotion.getBuy() + promotion.getGet() <= product.getQuantity();
    }

    private static void isPromotionApplicable(String userProduct, int userQuantity, Product product,
                                              Promotion promotion, boolean isInReceipt) {
        //while (userQuantity > 0) {
        if (hasSufficientPromotionStock(product, promotion)) {
            hasTakenPromotionalItem(userProduct, userQuantity, product, promotion, isInReceipt);
        }
        if (!hasSufficientPromotionStock(product, promotion)) {
            StaffController.askCancelPromotion();
            // 일반 결제
            // return;
        }
        userQuantity = 0;
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

    private static void findPromotion(String userProduct, int userQuantity, Product product, boolean isInReceipt) {
        for (Promotion promotion : promotions) {
            if (checkDate(promotion) && product.getName().equals(userProduct) && product.getPromotion()
                    .equals(promotion.getName())) {
                isPromotionApplicable(userProduct, userQuantity, product, promotion, isInReceipt);
            }
        }
    }

    private static void isPromotionProduct(String userProduct, int userQuantity, boolean isInReceipt) {
        for (Product product : products) {
            if (!product.getPromotion().isEmpty()) {
                findPromotion(userProduct, userQuantity, product, isInReceipt);
            }
        }
        // 결제하기
    }

    public static void isExistProduct(String userProduct, int userQuantity, boolean isInReceipt) {
        try {
            if (!productSet.contains(userProduct)) {
                throw new IllegalArgumentException(StaffErrorMessage.IS_NOT_EXIST.getFormattedMessage());
            }
            isPromotionProduct(userProduct, userQuantity, isInReceipt(userProduct));
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

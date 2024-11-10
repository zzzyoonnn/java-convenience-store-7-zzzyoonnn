package store.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import store.domain.Filepath;
import store.domain.Product;
import store.domain.Promotion;
import store.domain.ShoppingCart;
import store.domain.User;
import store.message.RegistrationErrorMessage;
import store.message.StaffErrorMessage;

public class PosMachineController {
    private User user;
    public static List<Product> products;
    private static HashSet<String> productSet = new HashSet<>();
    private static List<Promotion> promotions;

    public PosMachineController() {
    }

    public PosMachineController(List<Product> products, List<Promotion> promotions) {
        PosMachineController.products = products;
        PosMachineController.promotions = promotions;
    }

//    private static boolean meetsPromotionCriteria(String userProduct, int userQuantity, Product product,
//                                                  List<Promotion> promotion) {
//        if (product.getPromotion().equals("탄산2+1") && userQuantity >= 3 && product.getQuantity() >= 3) {  // 총 3개 필요
//            System.out.println(product.getName());
//        }
//
//        if (!product.getPromotion().equals("탄산2+1")) {  // 총 2개 필요
//            System.out.println(product.getName());
//        }
//
//        return false;
////    }
////
////    private static void isPromotionProduct(String userProduct, int userQuantity, Product product,
////                                           List<Promotion> promotion) {
////        if (!product.getPromotion().isEmpty()) {
////            meetsPromotionCriteria(userProduct, userQuantity, product, promotion);
////        }
////    }

    private static void isExistProduct(String userProduct) {
        try {
            if (!productSet.contains(userProduct)) {
                throw new IllegalArgumentException(StaffErrorMessage.IS_NOT_EXIST.getFormattedMessage());
            }
            // 프로모션 적용 가능한지 확인하기
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
            isExistProduct(userProduct);
            for (Product product : products) {
            }
        }
    }

    public static void initialize() {
        Filepath filepath = new Filepath("src/main/resources/products.md", "src/main/resources/promotions.md");

        products = createProductInformation(filepath.getProductPath());
        promotions = createPromotionInformation(filepath.getPromotionPath());
    }

    public static String getInventoryInformation() {
        StringBuilder sb = new StringBuilder();
        products.forEach(product -> sb.append("- ").append(product).append("\n"));
        return sb.toString();
    }

    public static List<Promotion> registerPromotion(List<String> lines) {
        List<Promotion> promotions = new ArrayList<>();

        try {
            for (int currentLine = 1; currentLine < lines.size(); currentLine++) {
                String[] content = lines.get(currentLine).trim().split(",");
                Promotion promotion = new Promotion(content[0], Integer.parseInt(content[1]),
                        Integer.parseInt(content[2]), content[3], content[4]);
                promotions.add(promotion);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(RegistrationErrorMessage.IS_INVALID_FORMAT.getFormattedMessage());
        }

        return promotions;
    }

    public static List<Product> registerProduct(List<String> lines) {
        List<Product> products = new ArrayList<>();

        try {
            for (int currentLine = 1; currentLine < lines.size(); currentLine++) {
                String[] content = lines.get(currentLine).trim().split(",");
                Product product = new Product(content[0], Integer.parseInt(content[1]),
                        Integer.parseInt(content[2]), content[3]);
                products.add(product);
                productSet.add(content[0]);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(RegistrationErrorMessage.IS_INVALID_FORMAT.getFormattedMessage());
        }

        return products;
    }

    public static List<Promotion> createPromotionInformation(String productsPath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(productsPath));
            return registerPromotion(lines);
        } catch (IOException e) {
            throw new RuntimeException(RegistrationErrorMessage.CANNOT_READ_FILE.getFormattedMessage());
        }
    }

    public static List<Product> createProductInformation(String productsPath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(productsPath));
            return registerProduct(lines);
        } catch (IOException e) {
            throw new RuntimeException(RegistrationErrorMessage.CANNOT_READ_FILE.getFormattedMessage());
        }
    }
}
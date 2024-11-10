package store.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import store.domain.Filepath;
import store.domain.Product;
import store.domain.Promotion;
import store.domain.User;
import store.message.RegistrationErrorMessage;

public class PosMachineController {
    private User user;
    public static List<Product> products;
    private static HashSet<String> productSet;
    private static List<Promotion> promotions;

    public PosMachineController(List<Product> products, List<Promotion> promotions, HashSet<String> productSet) {
        this.products = products;
        this.promotions = promotions;
        this.productSet = productSet;
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
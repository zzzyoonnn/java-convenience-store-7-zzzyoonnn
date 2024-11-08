package store.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import store.domain.Filepath;
import store.domain.Product;
import store.domain.Promotion;
import store.message.RegistrationErrorMessage;

public class PosMachineController {

    public static void initialize() {
        Filepath filepath = new Filepath("src/main/resources/products.md", "src/main/resources/promotions.md");

        //createPromotionInformation(filepath.getPromotionPath());
        List<Product> products = createProductInformation(filepath.getProductPath());
    }

    public static List<Product> registerProduct(List<String> lines) {
        List<Product> products = new ArrayList<>();

        try {
            for (int currentLine = 1; currentLine < lines.size(); currentLine++) {
                String[] content = lines.get(currentLine).split(",");
                Product product = new Product(content[0], Integer.parseInt(content[1].trim()),
                        Integer.parseInt(content[2].trim()), content[3].trim());
                products.add(product);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(RegistrationErrorMessage.IS_INVALID_FORMAT.getMessage());
        }

        return products;
    }

    public static List<Promotion> createPromotionInformation(String productsPath) {
        List<Promotion> promotions = new ArrayList<>();

        // md파일 읽는 과정

        return promotions;
    }

    public static List<Product> createProductInformation(String productsPath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(productsPath));
            return registerProduct(lines);
        } catch (IOException e) {
            throw new RuntimeException(RegistrationErrorMessage.CANNOT_READ_FILE.getMessage());
        }
    }
}
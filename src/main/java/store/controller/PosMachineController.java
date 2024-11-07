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

        createProductInformation(filepath.getProductPath());
    }

    public static List<Product> createProductInformation(String productsPath) {
        List<Product> products = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(productsPath));

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                System.out.println(line);
                String[] fields = line.split(",");

                String name = fields[0];
                int price = Integer.parseInt(fields[1].trim());
                int quantity = Integer.parseInt(fields[2].trim());
                String promotion = fields[3].trim();

                Product product = new Product(name, price, quantity, promotion);
                products.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(RegistrationErrorMessage.IS_INVALID_FORMAT.getMessage());
        }

        return products;
    }
}
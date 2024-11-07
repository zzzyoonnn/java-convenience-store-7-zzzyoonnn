package store.domain;

import static store.message.ErrorMessage.IS_NOT_EXISTENCE_OF_PRODUCTS_FILE;

import java.io.File;

public class Filepath {
    private final String productPath;
    private final String promotionPath;

    Filepath(String productPath, String promotionPath) {
        this.productPath = "src/main/resources/products.md";
        this.promotionPath = "src/main/resources/promotions.md";
    }

    public String getProductPath() {
        if (!hasProductsFile(productPath)) {
            throw new RuntimeException(IS_NOT_EXISTENCE_OF_PRODUCTS_FILE.getMessage());
        }
        return productPath;
    }

    public String getPromotionPath() {
        if (!hasProductsFile(promotionPath)) {
            throw new RuntimeException(IS_NOT_EXISTENCE_OF_PRODUCTS_FILE.getMessage());
        }
        return promotionPath;
    }

    private boolean hasProductsFile(String productPath) {
        File file = new File(productPath);
        return file.exists();
    }

    private boolean hasPromotionsFile(String promotionPath) {
        File file = new File(promotionPath);
        return file.exists();
    }
}

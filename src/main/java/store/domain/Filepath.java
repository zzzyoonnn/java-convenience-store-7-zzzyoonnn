package store.domain;

import java.io.File;
import store.message.PathErrorMessage;

public class Filepath {
    private final String productPath;
    private final String promotionPath;

    public Filepath(String productPath, String promotionPath) {
        this.productPath = productPath;
        this.promotionPath = promotionPath;
    }

    public String getProductPath() {
        if (!hasProductsFile(productPath)) {
            throw new RuntimeException(PathErrorMessage.IS_NOT_EXISTENCE_OF_PRODUCTS_FILE.getFormattedMessage());
        }
        return productPath;
    }

    public String getPromotionPath() {
        if (!hasPromotionsFile(promotionPath)) {
            throw new RuntimeException(PathErrorMessage.IS_NOT_EXISTENCE_OF_PROMOTIONS_FILE.getFormattedMessage());
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

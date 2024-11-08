package store.filepath;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.domain.Filepath;

public class FilepathTest {
    @Test
    @DisplayName("products.md 파일이 존재하는지 확인된다.")
    public void testIsExistenceOfProductsFile() {
        Filepath filepath = new Filepath("src/main/resources/products.md", "");
        assertDoesNotThrow(filepath::getProductPath);
    }

    @Test
    @DisplayName("products.md 파일이 존재하는지 확인되지 않는다.")
    public void testIsNotExistenceOfProductsFile() {
        Filepath filepath = new Filepath("", "src/main/resources/promotions.md");
        assertThrows(RuntimeException.class, filepath::getProductPath);
    }

    @Test
    @DisplayName("promotions.md 파일이 존재하는지 확인된다.")
    public void testIsExistenceOfPromotionsFile() {
        Filepath filepath = new Filepath("src/main/resources/products.md", "src/main/resources/promotions.md");
        assertDoesNotThrow(filepath::getPromotionPath);
    }

    @Test
    @DisplayName("promotions.md 파일이 존재하는지 확인되지 않는다.")
    public void testIsNotExistenceOfPromotionsFile() {
        Filepath filepath = new Filepath("src/main/resources/products.md", "");
        assertThrows(RuntimeException.class, filepath::getPromotionPath);
    }
}

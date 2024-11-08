package store.posMachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.controller.PosMachineController;
import store.domain.Filepath;
import store.domain.Product;

public class PosMachineTest {
    @Test
    @DisplayName("productsTest.md 파일을 통해 재고를 확인할 수 있다.")
    public void testDisplayInventoryInformation() {
        Filepath filepath = new Filepath("src/test/java/store/posMachine/productsTest.md", "");
        List<Product> products = PosMachineController.createProductInformation(filepath.getProductPath());
        PosMachineController.products = products;

        String productsList = PosMachineController.getInventoryInformation();

        assertThat(productsList.split("\n")).containsExactly(
                "- 콜라 1,000원 10개 탄산2+1",
                "- 콜라 1,000원 10개",
                "- 사이다 1,000원 8개 탄산2+1"
        );
    }

    @Test
    @DisplayName("productsErrorTest.md 파일을 통해 재고를 확인할 수 없다.")
    public void testCanNotDisplayInventoryInformation() throws IOException {
        Filepath filepath = new Filepath("src/test/java/store/posMachine/productsErrorTest.md", "");
        List<String> fileContent = Files.readAllLines(Paths.get(filepath.getProductPath()));

        assertThrows(IllegalArgumentException.class, () -> PosMachineController.registerProduct(fileContent));
    }
}
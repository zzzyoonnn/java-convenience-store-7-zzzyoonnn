package store.posMachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.controller.PosMachineController;
import store.domain.Filepath;
import store.domain.Product;
import store.domain.ReceiptManagement;

public class PosMachineTest {
    @Test
    @DisplayName("productsTest.md 파일을 통해 재고를 확인할 수 있다.")
    public void testDisplayInventoryInformation() {
        Filepath filepath = new Filepath("src/test/java/store/posMachine/productsTest.md", "");
        List<Product> products = PosMachineController.createProductInformation(filepath.getProductPath());
        PosMachineController posMachineController = new PosMachineController(products, List.of(), new HashSet<>(), new ReceiptManagement());

        String productsList = PosMachineController.getInventoryInformation();
        assertThat(productsList.split("\n")).containsExactly(
                "- 콜라 1,000원 10개 탄산2+1",
                "- 콜라 1,000원 10개",
                "- 사이다 1,000원 8개 탄산2+1",
                "- 사이다 1,000원 7개",
                "- 오렌지주스 1,800원 9개 MD추천상품",
                "- 탄산수 1,200원 5개 탄산2+1",
                "- 물 500원 10개"
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

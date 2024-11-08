package store.view;

import java.util.List;
import store.domain.Product;

public class PosMachineView {
    public static void getInventoryInformation(List<Product> products) {
        products.forEach(product -> System.out.println("- " + product));
    }
}

package store.domain;

import java.util.ArrayList;
import store.message.StaffErrorMessage;

public class User {
    private String buyingInput;
    private ArrayList<ShoppingCart> arrangedBuyingMemo;

    public User() {

    }

    public User(String buyingInput) {
        isValidBuyingInput(buyingInput);
        this.buyingInput = buyingInput;
        this.arrangedBuyingMemo = arrangeBuyingItems();
    }

    public ArrayList<ShoppingCart> arrangeBuyingItems() {
        String[] splitProducts = this.buyingInput.replaceAll("[\\[\\]]", "").split(",");

        arrangedBuyingMemo = new ArrayList<>();
        for (int index = 0; index < splitProducts.length; index++) {
            String[] splitProductAndQuantity = splitProducts[index].split("-");
            String productName = splitProductAndQuantity[0];
            int quantity = Integer.parseInt(splitProductAndQuantity[1]);
            arrangedBuyingMemo.add(new ShoppingCart(productName, quantity));
        }

        return arrangedBuyingMemo;
    }

    public boolean isValidBuyingInput(String buyingInput) {
        String regex = "^\\[([가-힣]+-\\d+)\\]+(,\\[([가-힣]+-\\d+)\\])*$";
        if (!buyingInput.matches(regex)) {
            throw new IllegalArgumentException(StaffErrorMessage.IS_INVALID_STRING.getFormattedMessage());
        }

        return true;
    }
}

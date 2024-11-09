package store.domain;

import java.util.ArrayList;
import java.util.Arrays;
import store.message.StaffErrorMessage;

public class User {
    private String buyingInput;
    private ArrayList<ShoppingCart>[] arrangeBuyingInput;

    public User() {

    }

    public User(String buyingInput) {
        isValidBuyingInput(buyingInput);
        this.buyingInput = buyingInput;
        this.arrangeBuyingInput = arrangeBuyingItems();
    }

    public ArrayList<ShoppingCart>[] arrangeBuyingItems() {
        String arrangedBuyingInput = this.buyingInput.replaceAll("[\\[\\]]", "");
        String[] splitProducts = arrangedBuyingInput.split(",");

        arrangeBuyingInput = new ArrayList[splitProducts.length];
        for (int index = 0; index < splitProducts.length; index++) {
            String[] splitProductAndQuantity = splitProducts[index].split("-");
            String productName = splitProductAndQuantity[0];
            int quantity = Integer.parseInt(splitProductAndQuantity[1]);
            arrangeBuyingInput[index] = new ArrayList<>();
            arrangeBuyingInput[index].add(new ShoppingCart(productName, quantity));
        }

        return arrangeBuyingInput;
    }

    public boolean isValidBuyingInput(String buyingInput) {
        String regex = "^\\[([가-힣]+-\\d+)\\]+(,\\[([가-힣]+-\\d+)\\])*$";
        if (!buyingInput.matches(regex)) {
            throw new IllegalArgumentException(StaffErrorMessage.IS_INVALID_STRING.getFormattedMessage());
        }

        return true;
    }
}

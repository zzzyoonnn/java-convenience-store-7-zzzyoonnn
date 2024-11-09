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

        for (int i = 0; i < arrangedBuyingMemo.size(); i++) {
            System.out.println(
                    arrangedBuyingMemo.get(i).getProductName() + " " + arrangedBuyingMemo.get(i).getQuantity());
        }
    }

    public String[] splitProductAndQuantity(String productNameAndQuantity) {
        String[] splitedHyphen = productNameAndQuantity.split("-");
        return splitedHyphen;
    }

    public ArrayList<ShoppingCart> arrangeBuyingItems() {
        String[] splitProducts = this.buyingInput.replaceAll("[\\[\\]]", "").split(",");

        arrangedBuyingMemo = new ArrayList<>();
        for (int index = 0; index < splitProducts.length; index++) {
            String[] productAndQuantity = splitProductAndQuantity(splitProducts[index]);
            arrangedBuyingMemo.add(new ShoppingCart(productAndQuantity[0], Integer.parseInt(productAndQuantity[1])));
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

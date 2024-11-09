package store.domain;

import store.message.StaffErrorMessage;

public class User {
    private String buyingInput;

    public User() {

    }

    public User(String buyingInput) {
        isValidBuyingInput(buyingInput);
        this.buyingInput = buyingInput;
    }

    public boolean isValidBuyingInput(String buyingInput) {
        String regex = "^\\[([가-힣]+-\\d+)\\]+(,\\[([가-힣]+-\\d+)\\])*$";
        if (!buyingInput.matches(regex)) {
            throw new IllegalArgumentException(StaffErrorMessage.IS_INVALID_STRING.getFormattedMessage());
        }

        return true;
    }
}

package store.domain;

import store.message.StaffErrorMessage;

public class User {
    private String userCart;

    public User() {

    }

    public User(String userCart) {
        isValidString(userCart);
        this.userCart = userCart;
    }

    private void isValidString(String userCart) {
        String regex = "^\\[([가-힣]+-\\d+)\\]+(,\\[([가-힣]+-\\d+)\\])*$";
        if (!userCart.matches(regex)) {
            throw new IllegalArgumentException(StaffErrorMessage.IS_INVALID_STRING.getFormattedMessage());
        }
    }
}

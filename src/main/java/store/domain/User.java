package store.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import store.message.StaffErrorMessage;

public class User {
    private static User user;
    private String buyingInput;
    private ArrayList<ShoppingCart> arrangedBuyingMemo;

    public User() {
    }

    public User(String buyingInput) {
        isValidBuyingInput(buyingInput);
        this.buyingInput = buyingInput;
        this.arrangedBuyingMemo = arrangeBuyingItems();
    }

    public static String answerQuestion() {
        String answerQuestion = "";
        while (true) {
            try {
                answerQuestion = Console.readLine();
                if (isValidAnswer(answerQuestion)) break;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
        return answerQuestion;
    }

    private static boolean isValidAnswer(String answerQuestion) {
        if (!answerQuestion.equals("Y") && !answerQuestion.equals("N")) {
            throw new IllegalStateException(StaffErrorMessage.IS_OTHER_ERROR.getFormattedMessage());
        }
        return true;
    }

    public static User getUser() {
        return user;
    }

    public static User enterUser() {
        while (true) {
            try {
                user = new User(Console.readLine());
                return user;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ArrayList<ShoppingCart> userBuyingMemo() {
        return arrangedBuyingMemo;
    }

    private String[] splitProductAndQuantity(String productNameAndQuantity) {
        return productNameAndQuantity.split("-");
    }

    private ArrayList<ShoppingCart> arrangeBuyingItems() {
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

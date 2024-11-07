package store.view;

import static store.message.ConvenienceStoreMessage.WELCOME_GREETING;

public class ConvenienceStoreView {
    public static void displayWelcomeGreeting() {
        System.out.println(WELCOME_GREETING.getMessage());
    }
}

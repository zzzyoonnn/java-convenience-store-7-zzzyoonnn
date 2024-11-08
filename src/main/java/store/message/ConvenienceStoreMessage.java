package store.message;

public enum ConvenienceStoreMessage {
    WELCOME_GREETING("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n");

    private final String message;

    ConvenienceStoreMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

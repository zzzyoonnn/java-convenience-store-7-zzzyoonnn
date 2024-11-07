package store.message;

public enum ConvenienceStoreMessage {
    WELCOME_GREETING("안녕하세요. W편의점입니다.");

    private final String message;

    ConvenienceStoreMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

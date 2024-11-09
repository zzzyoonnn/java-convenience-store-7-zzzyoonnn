package store.message;

public enum ReceiptMessage {
    RECEIPT_TITLE("==============W 편의점================\n상품명\t\t\t\t수량\t\t금액\n"),
    RECEIPT_BONUS("==============증\t\t정===============\n"),
    RECEIPT_BOUNDARY("=====================================");

    private final String message;

    ReceiptMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

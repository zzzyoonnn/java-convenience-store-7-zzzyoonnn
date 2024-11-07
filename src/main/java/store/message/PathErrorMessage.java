package store.message;

public enum PathErrorMessage implements ErrorMessage {
    IS_NOT_EXISTENCE_OF_PRODUCTS_FILE("products.md 파일이 존재하는지 확인되지 않습니다."),
    IS_NOT_EXISTENCE_OF_PROMOTIONS_FILE("promotions.md 파일이 존재하는지 확인되지 않습니다."),
    IS_NOT_CONFIRM_INVENTORY("재고가 확인되지 않습니다."),
    REQUEST_RESTART("파일 경로를 확인 후, 재실행 해주세요.");

    private final String message;

    PathErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + REQUEST_RESTART.message;
    }
}

package store.message;

public enum StaffErrorMessage implements ErrorMessage {
    IS_INVALID_STRING("올바르지 않은 형식으로 입력했습니다. "),
    IS_NOT_EXIST("존재하지 않는 상품입니다. "),
    EXCEED_QUANTITY("재고 수량을 초과하여 구매할 수 없습니다. "),
    IS_OTHER_ERROR("잘못된 입력입니다. "),
    REQUEST_INPUT("다시 입력해 주세요.");

    private final String message;

    StaffErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + REQUEST_INPUT.message;
    }
}

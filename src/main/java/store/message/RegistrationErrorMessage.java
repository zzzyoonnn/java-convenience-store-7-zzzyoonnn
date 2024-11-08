package store.message;

public enum RegistrationErrorMessage implements ErrorMessage {
    IS_INVALID_FORMAT("양식에 맞지 않은 파일입니다.\n"),
    CANNOT_READ_FILE("파일을 읽을 수 없습니다.\n"),
    VERIFY_CONTENT("파일 내용을 확인 후, 재실행 해주세요.\n");

    private final String message;

    RegistrationErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + VERIFY_CONTENT.message;
    }
}

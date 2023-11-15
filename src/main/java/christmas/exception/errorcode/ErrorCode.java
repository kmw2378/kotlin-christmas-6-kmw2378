package christmas.exception.errorcode;

public enum ErrorCode {
    INVALID_VISIT_DATE("유효하지 않은 날짜입니다."),
    INVALID_ORDER("유효하지 않은 주문입니다.");
    private static final String PREFIX = "[ERROR] ";
    private static final String SUFFIX = " 다시 입력해 주세요.";
    private final String message;

    ErrorCode(final String message) {
        this.message = PREFIX + message + SUFFIX;
    }

    public String getMessage() {
        return message;
    }
}

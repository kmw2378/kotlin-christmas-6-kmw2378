package christmas.exception;

import christmas.exception.errorcode.ErrorCode;

public class InputException extends IllegalArgumentException {
    private final ErrorCode errorCode;

    public InputException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}

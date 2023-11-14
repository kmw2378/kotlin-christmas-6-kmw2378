package christmas.validator;

import christmas.exception.InputException;
import christmas.exception.errorcode.ErrorCode;

public interface Validator<T> {
    void validate(T target);

    default void validateIsNull(final T target, final ErrorCode errorCode) {
        if (target == null) {
            throw new InputException(errorCode);
        }
    }
}

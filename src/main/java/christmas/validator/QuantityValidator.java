package christmas.validator;

import christmas.exception.InputException;

import static christmas.config.PromotionConfig.MIN_ORDER_QUANTITY;
import static christmas.exception.errorcode.ErrorCode.INVALID_ORDER;

public class QuantityValidator implements Validator<Integer> {
    @Override
    public void validate(final Integer quantity) {
        validateIsNull(quantity, INVALID_ORDER);
        if (quantity < MIN_ORDER_QUANTITY) {
            throw new InputException(INVALID_ORDER);
        }
    }
}

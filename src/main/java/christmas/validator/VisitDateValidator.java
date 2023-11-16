package christmas.validator;

import christmas.exception.InputException;

import static christmas.config.PromotionConfig.PROMOTION_END_DAY;
import static christmas.config.PromotionConfig.PROMOTION_START_DAY;
import static christmas.exception.errorcode.ErrorCode.INVALID_VISIT_DATE;

public class VisitDateValidator implements Validator<Integer> {
    @Override
    public void validate(final Integer visitDay) {
        validateIsNull(visitDay, INVALID_VISIT_DATE);
        if (PROMOTION_START_DAY > visitDay || PROMOTION_END_DAY < visitDay) {
            throw new InputException(INVALID_VISIT_DATE);
        }
    }
}

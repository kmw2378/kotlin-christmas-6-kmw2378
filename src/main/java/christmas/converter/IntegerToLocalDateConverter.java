package christmas.converter;

import christmas.validator.Validator;
import christmas.validator.VisitDateValidator;
import java.time.LocalDate;

import static christmas.config.PromotionConfig.PROMOTION_MONTH;
import static christmas.config.PromotionConfig.PROMOTION_YEAR;

public class IntegerToLocalDateConverter implements Converter<Integer, LocalDate> {
    @Override
    public LocalDate convert(final Integer visitDay) {
        final Validator<Integer> validator = new VisitDateValidator();
        validator.validate(visitDay);
        return LocalDate.of(PROMOTION_YEAR, PROMOTION_MONTH, visitDay);
    }
}

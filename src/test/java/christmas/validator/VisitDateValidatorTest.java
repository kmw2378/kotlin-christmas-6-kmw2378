package christmas.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.exception.errorcode.ErrorCode.INVALID_VISIT_DATE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VisitDateValidatorTest {
    @DisplayName("방문일이 프로모션 적용 월에 포함되지 않는 경우 예외가 발생한다")
    @Test
    public void validateDayNotContainPromotionDays() throws Exception {
        // given
        final int day = 40;
        final Validator<Integer> validator = new VisitDateValidator();

        // when, then
        assertThatThrownBy(() -> validator.validate(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_VISIT_DATE.getMessage());
    }
}
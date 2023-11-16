package christmas.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.exception.errorcode.ErrorCode.INVALID_ORDER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuValidatorTest {
    @DisplayName("문자열이 Menu 객체에 포함되지 않는 경우 예외가 발생한다")
    @Test
    public void validateNotConvertMenu() throws Exception {
        // given
        final String name = "123";
        final Validator<String> validator = new MenuValidator();

        // when, then
        assertThatThrownBy(() -> validator.validate(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER.getMessage());
    }
}
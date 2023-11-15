package christmas.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.exception.errorcode.ErrorCode.INVALID_ORDER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QuantityValidatorTest {
    @DisplayName("수량이 최소 주문 수보다 작으면 예외가 발생한다")
    @Test
    public void validateQuantityLessThanMinQuantity() throws Exception {
        // given
        final int quantity = -1;
        final Validator<Integer> validator = new QuantityValidator();

        // when, then
        assertThatThrownBy(() -> validator.validate(quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER.getMessage());
    }
}
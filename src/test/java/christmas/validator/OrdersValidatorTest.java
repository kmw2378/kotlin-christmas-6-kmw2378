package christmas.validator;

import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static christmas.exception.errorcode.ErrorCode.INVALID_ORDER;
import static christmas.fixture.OrderFixture.디저트_아이스크림_1개;
import static christmas.fixture.OrderFixture.디저트_아이스크림_20개;
import static christmas.fixture.OrderFixture.음료_샴페인_1개;
import static christmas.fixture.OrderFixture.음료_콜라_1개;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrdersValidatorTest {
    @DisplayName("메뉴 이름이 중복되는 경우 예외가 발생한다")
    @Test
    public void validateDuplicateMenuName() throws Exception {
        // given
        final List<Order> orders = List.of(디저트_아이스크림_1개.생성(), 디저트_아이스크림_1개.생성());
        final Validator<List<Order>> validator = new OrdersValidator();

        // when, then
        assertThatThrownBy(() -> validator.validate(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER.getMessage());
    }

    @DisplayName("총 수량이 최대 주문수를 넘으면 예외가 발생한다")
    @Test
    public void validateTotalQuantity() throws Exception {
        // given
        final List<Order> orders = List.of(디저트_아이스크림_20개.생성(), 음료_샴페인_1개.생성());
        final Validator<List<Order>> validator = new OrdersValidator();

        // when, then
        assertThatThrownBy(() -> validator.validate(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER.getMessage());
    }

    @DisplayName("음료만 주문된 경우 예외가 발생한다")
    @Test
    public void validateBeverageOnly() throws Exception {
        // given
        final List<Order> orders = List.of(음료_콜라_1개.생성(), 음료_샴페인_1개.생성());
        final Validator<List<Order>> validator = new OrdersValidator();

        // when, then
        assertThatThrownBy(() -> validator.validate(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER.getMessage());
    }
}
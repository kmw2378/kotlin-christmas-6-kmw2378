package christmas.validator;

import christmas.domain.order.Order;
import christmas.exception.InputException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static christmas.config.PromotionConfig.MAX_ORDER_QUANTITY;
import static christmas.domain.menu.MenuType.BEVERAGE;
import static christmas.exception.errorcode.ErrorCode.INVALID_ORDER;

public class OrdersValidator implements Validator<List<Order>> {
    @Override
    public void validate(final List<Order> orders) {
        validateIsNull(orders, INVALID_ORDER);
        validateDuplicate(orders);
        validateTotalQuantity(orders);
        validateMenuType(orders);
    }

    private void validateDuplicate(final List<Order> orders) {
        final Set<Order> distinctOrders = new HashSet<>(orders);
        if (distinctOrders.size() != orders.size()) {
            throw new InputException(INVALID_ORDER);
        }
    }

    private void validateTotalQuantity(final List<Order> orders) {
        final int totalQuantity = orders.stream()
                .map(Order::getQuantity)
                .mapToInt(i -> i)
                .sum();

        if (totalQuantity > MAX_ORDER_QUANTITY) {
            throw new InputException(INVALID_ORDER);
        }
    }

    private void validateMenuType(final List<Order> orders) {
        final boolean isAllBeverage = orders.stream()
                .allMatch(o -> o.equalsMenuType(BEVERAGE));

        if (isAllBeverage) {
            throw new InputException(INVALID_ORDER);
        }
    }
}

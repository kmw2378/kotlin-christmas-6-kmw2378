package christmas.fixture;

import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.order.OrderQuantity;

import static christmas.domain.menu.Menu.CHAMPAGNE;
import static christmas.domain.menu.Menu.ICE_CREAM;
import static christmas.domain.menu.Menu.ZERO_COKE;

public enum OrderFixture {
    디저트_아이스크림_1개(ICE_CREAM, 1),
    디저트_아이스크림_0개(ICE_CREAM, 0),
    디저트_아이스크림_20개(ICE_CREAM, 20),
    음료_콜라_1개(ZERO_COKE, 1),
    음료_샴페인_1개(CHAMPAGNE, 1);

    private final Menu menu;
    private final int quantity;

    OrderFixture(final Menu menu, final int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Order 생성() {
        return new Order(menu, new OrderQuantity(quantity));
    }
}

package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;

import java.util.Objects;

public class Order {
    private final Menu menu;
    private final OrderQuantity quantity;

    public Order(final Menu menu, final OrderQuantity quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public boolean equalsMenu(final Menu menu) {
        return this.menu.equals(menu);
    }

    public boolean equalsMenuType(final MenuType menuType) {
        return menu.getType().equals(menuType);
    }

    public long getTotalAmount() {
        return menu.getAmount() * quantity.getQuantity();
    }

    public int getQuantity() {
        return quantity.getQuantity();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Order order)) {
            return false;
        }

        return menu == order.menu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }
}

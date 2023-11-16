package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;

import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders(final List<Order> orders) {
        this.orders = orders;
    }

    public boolean existMenu(final Menu menu) {
        return orders.stream()
                .anyMatch(o -> o.equalsMenu(menu));
    }

    public long getTotalAmount() {
        return orders.stream()
                .map(Order::getTotalAmount)
                .mapToLong(l -> l)
                .sum();
    }

    public long getTotalQuantityFromMenuType(final MenuType menuType) {
        return orders.stream()
                .filter(o -> o.equalsMenuType(menuType))
                .count();
    }

    public int getTotalQuantityFromMenu(final Menu menu) {
        return orders.stream()
                .filter(o -> o.equalsMenu(menu))
                .findAny()
                .orElseThrow(() -> new IllegalStateException())
                .getQuantity();
    }
}

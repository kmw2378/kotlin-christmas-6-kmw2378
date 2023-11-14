package christmas.mapper;

import christmas.domain.menu.Menu;
import christmas.domain.user.User;
import christmas.dto.menu.response.MenuResponse;
import christmas.dto.order.response.OrderResponse;
import java.util.Arrays;
import java.util.List;

public class OrderResponseMapper implements ResponseMapper<User, OrderResponse> {
    @Override
    public OrderResponse map(final User user) {
        final List<MenuResponse> menuResponses = getMenuResponses(user);
        final long totalOrderAmount = user.getTotalOrderAmount();
        return new OrderResponse(menuResponses, totalOrderAmount);
    }

    private List<MenuResponse> getMenuResponses(final User user) {
        return Arrays.stream(Menu.values())
                .filter(user::existMenu)
                .map(m -> new MenuResponse(m.getName(), user.getQuantityFromMenu(m)))
                .toList();
    }
}

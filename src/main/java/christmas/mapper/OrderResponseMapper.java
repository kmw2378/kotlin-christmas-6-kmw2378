package christmas.mapper;

import christmas.domain.menu.Menu;
import christmas.domain.reservation.Reservation;
import christmas.dto.menu.response.MenuResponse;
import christmas.dto.order.response.OrderResponse;
import java.util.Arrays;
import java.util.List;

public class OrderResponseMapper implements ResponseMapper<Reservation, OrderResponse> {
    @Override
    public OrderResponse map(final Reservation reservation) {
        final List<MenuResponse> menuResponses = getMenuResponses(reservation);
        final long totalOrderAmount = reservation.getTotalOrderAmount();
        return new OrderResponse(menuResponses, totalOrderAmount);
    }

    private List<MenuResponse> getMenuResponses(final Reservation reservation) {
        return Arrays.stream(Menu.values())
                .filter(reservation::existMenu)
                .map(m -> new MenuResponse(m.getName(), reservation.getQuantityFromMenu(m)))
                .toList();
    }
}

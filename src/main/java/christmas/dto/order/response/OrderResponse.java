package christmas.dto.order.response;

import christmas.dto.menu.response.MenuResponse;

import java.util.List;

public record OrderResponse(List<MenuResponse> menus, long totalAmount) {
}

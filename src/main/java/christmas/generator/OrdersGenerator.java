package christmas.generator;

import christmas.converter.Converter;
import christmas.converter.StringToMenuConverter;
import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import christmas.domain.order.OrderQuantity;
import christmas.domain.order.Orders;
import christmas.dto.order.request.OrderRequest;
import christmas.validator.OrdersValidator;
import christmas.validator.QuantityValidator;
import christmas.validator.Validator;
import java.util.List;

public class OrdersGenerator implements Generator<List<OrderRequest>, Orders> {
    @Override
    public Orders generate(List<OrderRequest> orderRequests) {
        final Validator<List<Order>> validator = new OrdersValidator();
        final List<Order> orders = generateOrders(orderRequests);
        validator.validate(orders);
        return new Orders(orders);
    }

    private List<Order> generateOrders(final List<OrderRequest> orderRequests) {
        return orderRequests.stream()
                .map(this::createOrder)
                .toList();
    }

    private Order createOrder(final OrderRequest orderRequest) {
        final Converter<String, Menu> converter = new StringToMenuConverter();
        final Menu menu = converter.convert(orderRequest.name());
        return new Order(menu, createQuantity(orderRequest));
    }

    private OrderQuantity createQuantity(final OrderRequest orderRequest) {
        final Validator<Integer> validator = new QuantityValidator();
        validator.validate(orderRequest.count());
        return new OrderQuantity(orderRequest.count());
    }
}

package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.order.request.OrderRequest;
import christmas.dto.reservaiton.request.VisitDateRequest;
import christmas.exception.InputException;
import christmas.exception.errorcode.ErrorCode;
import java.util.Arrays;
import java.util.List;

import static christmas.exception.errorcode.ErrorCode.INVALID_ORDER;
import static christmas.exception.errorcode.ErrorCode.INVALID_VISIT_DATE;

public class ConsoleInputView implements InputView {
    @Override
    public VisitDateRequest requestVisitDay() {
        System.out.println(VISIT_DATE_QUESTION_MESSAGE);
        final int visitDay = getVisitDay(Console.readLine());
        return new VisitDateRequest(visitDay);
    }

    @Override
    public List<OrderRequest> requestOrders() {
        System.out.println(ORDERS_QUESTION_MESSAGE);
        final List<String> orders = getOrders(Console.readLine());
        return orders.stream()
                .map(this::getOrderRequest)
                .toList();
    }

    private int getVisitDay(final String visitDay) {
        validateVisitDayNumeric(visitDay);
        return Integer.parseInt(visitDay);
    }

    private List<String> getOrders(final String orders) {
        return Arrays.stream(orders.split(ORDER_INPUT_SEPARATOR))
                .toList();
    }

    private OrderRequest getOrderRequest(final String order) {
        final List<String> menus = getMenus(order);
        final String quantity = menus.get(MENU_QUANTITY_INDEX);
        validateMenuQuantityNumeric(quantity);
        return new OrderRequest(menus.get(MENU_NAME_INDEX), Integer.parseInt(quantity));
    }

    private List<String> getMenus(String order) {
        validateOrderContainSeparator(order);
        validateSeparatedOrderSize(order);
        return Arrays.stream(order.split(MENU_NAME_QUANTITY_SEPARATOR))
                .toList();
    }

    private void validateOrderContainSeparator(final String order) {
        if (!order.contains(MENU_NAME_QUANTITY_SEPARATOR)) {
            throw new InputException(INVALID_ORDER);
        }
    }

    private void validateSeparatedOrderSize(final String order) {
        if (order.split(MENU_NAME_QUANTITY_SEPARATOR).length != SEPARATED_ORDER_SIZE) {
            throw new InputException(INVALID_ORDER);
        }
    }

    private void validateVisitDayNumeric(final String input) {
        validateNumeric(input, INVALID_VISIT_DATE);
    }

    private void validateMenuQuantityNumeric(final String input) {
        validateNumeric(input, INVALID_ORDER);
    }

    private void validateNumeric(final String input, final ErrorCode errorCode) {
        try {
            Integer.parseInt(input);
        } catch (final NumberFormatException e) {
            throw new InputException(errorCode);
        }
    }
}

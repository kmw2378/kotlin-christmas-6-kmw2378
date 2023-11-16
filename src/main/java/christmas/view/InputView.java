package christmas.view;

import christmas.dto.order.request.OrderRequest;
import christmas.dto.reservaiton.request.VisitDateRequest;
import java.util.List;

public interface InputView {
    String VISIT_DATE_QUESTION_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    String ORDERS_QUESTION_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    String ORDER_INPUT_SEPARATOR = ",";
    String MENU_NAME_QUANTITY_SEPARATOR = "-";
    int MENU_NAME_INDEX = 0;
    int MENU_QUANTITY_INDEX = 1;
    int SEPARATED_ORDER_SIZE = 2;
    VisitDateRequest requestVisitDay();
    List<OrderRequest> requestOrders();
}

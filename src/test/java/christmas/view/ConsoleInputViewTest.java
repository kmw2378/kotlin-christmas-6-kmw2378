package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static christmas.exception.errorcode.ErrorCode.INVALID_ORDER;
import static christmas.exception.errorcode.ErrorCode.INVALID_VISIT_DATE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleInputViewTest {
    private InputStream inputStream;
    private final InputView inputView = new ConsoleInputView();

    @AfterEach
    public void afterEach() throws IOException {
        Console.close();
    }

    @DisplayName("방문일이 숫자가 아니면 예외가 발생한다")
    @Test
    public void requestVisitDayNotNumeric() throws Exception {
        initInputStream("asb");
        assertThatThrownBy(inputView::requestVisitDay)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_VISIT_DATE.getMessage());
    }

    @DisplayName("주문 내역에 메뉴 이름, 수량 구분자(-)가 포함되지 않는 경우 예외 발생")
    @Test
    public void requestOrdersNotContainMenuNameAndQuantitySeparator() throws Exception {
        initInputStream("adfdsaf");
        assertThatThrownBy(inputView::requestOrders)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER.getMessage());
    }

    @DisplayName("주문 내역 수량이 숫자가 아닌 경우 예외 발생")
    @Test
    public void requestOrdersQuantityNotNumeric() throws Exception {
        initInputStream("초코케이크-ab,바비큐립-1");
        assertThatThrownBy(inputView::requestOrders)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER.getMessage());
    }

    private void initInputStream(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
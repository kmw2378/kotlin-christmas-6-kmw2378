package christmas.view;

import christmas.dto.badge.response.BadgeResponse;
import christmas.dto.benefit.response.AmountResponse;
import christmas.dto.benefit.response.BenefitRecordResponse;
import christmas.dto.benefit.response.BenefitResponse;
import christmas.dto.menu.response.MenuResponse;
import christmas.dto.order.response.OrderResponse;
import christmas.dto.reservaiton.response.VisitDateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

import static christmas.config.PromotionConfig.PROMOTION_MONTH;
import static christmas.domain.menu.Menu.ICE_CREAM;
import static christmas.domain.menu.Menu.ZERO_COKE;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleOutputViewTest {
    private OutputStream outputStream;
    private final OutputView outputView = new ConsoleOutputView();

    @BeforeEach
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("방문 날짜를 포함한 메시지를 출력한다")
    @Test
    public void printPromotionResultMessage() throws Exception {
        // given
        final int visitDay = 7;
        final VisitDateResponse visitDateResponse = new VisitDateResponse(visitDay);

        // when
        outputView.printPromotionResultMessage(visitDateResponse);
        final String actual = outputStream.toString();

        // then
        assertThat(actual).contains(PROMOTION_MONTH + "월 " + visitDay + "일");
    }

    @DisplayName("주문 내역을 출력한다")
    @Test
    public void printOrderMessage() throws Exception {
        // given
        final OrderResponse orderResponse = getOrderResponse();

        // when
        outputView.printOrderMessage(orderResponse);
        final String actual = outputStream.toString();

        // then
        assertThat(actual).contains(ICE_CREAM.getName() + " 1개", ZERO_COKE.getName() + " 1개");
    }

    @DisplayName("적용 혜택 내역을 출력한다")
    @Test
    public void printBenefitMessage() throws Exception {
        // given
        final BenefitResponse benefitResponse = getBenefitResponse();

        // when
        outputView.printBenefitMessage(benefitResponse);
        final String actual = outputStream.toString();

        // then
        assertThat(actual).contains(String.format("평일 할인: -%,d", 2023));
    }

    @DisplayName("부여받은 배지를 출력한다")
    @Test
    public void printBadgeMessage() throws Exception {
        // given
        final BadgeResponse badgeResponse = new BadgeResponse("산타");

        // when
        outputView.printBadgeMessage(badgeResponse);
        final String actual = outputStream.toString();

        // then
        assertThat(actual).contains(badgeResponse.name());
    }

    private OrderResponse getOrderResponse() {
        return new OrderResponse(List.of(new MenuResponse(ICE_CREAM.getName(), 1), new MenuResponse(ZERO_COKE.getName(), 1)),
                ICE_CREAM.getAmount() + ZERO_COKE.getAmount());
    }

    private BenefitResponse getBenefitResponse() {
        final long totalBenefitAmount = 2023;
        final long totalOrderAmount = ICE_CREAM.getAmount() + ZERO_COKE.getAmount();
        return new BenefitResponse(Collections.emptyList(),
                List.of(new BenefitRecordResponse("평일 할인", totalBenefitAmount)),
                new AmountResponse(totalBenefitAmount,totalOrderAmount - totalBenefitAmount));
    }
}
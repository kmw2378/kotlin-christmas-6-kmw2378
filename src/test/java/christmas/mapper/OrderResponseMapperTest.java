package christmas.mapper;

import christmas.domain.reservation.Reservation;
import christmas.dto.menu.response.MenuResponse;
import christmas.dto.order.response.OrderResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static christmas.domain.menu.Menu.ICE_CREAM;
import static christmas.domain.menu.Menu.ZERO_COKE;
import static christmas.fixture.ReservationFixture.월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개;
import static org.assertj.core.api.Assertions.assertThat;

class OrderResponseMapperTest {
    @DisplayName("예약 내역을 통해 출력에 필요한 주문 내역을 가져온다")
    @Test
    public void mapReservationToOrderResponse() throws Exception {
        // given
        final ResponseMapper<Reservation, OrderResponse> mapper = new OrderResponseMapper();
        final Reservation reservation = 월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개.생성();
        final OrderResponse expect = getOrderResponse();

        // when
        final OrderResponse actual = mapper.map(reservation);

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expect);
    }

    private OrderResponse getOrderResponse() {
        return new OrderResponse(List.of(new MenuResponse(ICE_CREAM.getName(), 1), new MenuResponse(ZERO_COKE.getName(), 1)),
                ICE_CREAM.getAmount() + ZERO_COKE.getAmount());
    }
}
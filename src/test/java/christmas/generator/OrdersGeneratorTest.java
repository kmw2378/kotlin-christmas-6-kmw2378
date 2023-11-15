package christmas.generator;

import christmas.domain.order.Orders;
import christmas.dto.order.request.OrderRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static christmas.domain.menu.Menu.ICE_CREAM;
import static christmas.domain.menu.Menu.ZERO_COKE;
import static christmas.fixture.OrderFixture.디저트_아이스크림_1개;
import static christmas.fixture.OrderFixture.음료_콜라_1개;
import static org.assertj.core.api.Assertions.assertThat;

class OrdersGeneratorTest {
    @DisplayName("주문 내역을 통해 주문 일급 컬렉션 객체를 생성한다")
    @Test
    public void createOrders() throws Exception {

        // given
        final Generator<List<OrderRequest>, Orders> generator = new OrdersGenerator();
        final List<OrderRequest> orderRequests = getOrderRequests();
        final Orders expect = new Orders(List.of(디저트_아이스크림_1개.생성(), 음료_콜라_1개.생성()));

        // when
        final Orders actual = generator.generate(orderRequests);

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expect);
    }

    private List<OrderRequest> getOrderRequests() {
        return List.of(new OrderRequest(ICE_CREAM.getName(), 1), new OrderRequest(ZERO_COKE.getName(), 1));
    }
}
package christmas.fixture;

import christmas.domain.benefit.Benefits;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import christmas.domain.reservation.Reservation;
import christmas.domain.reservation.VisitDate;
import java.util.List;

import static christmas.fixture.BenefitsFixture.증정X_평일_할인;
import static christmas.fixture.OrderFixture.디저트_아이스크림_1개;
import static christmas.fixture.OrderFixture.음료_콜라_1개;
import static christmas.fixture.VisitDateFixture.월_26일;

public enum ReservationFixture {
    월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개(증정X_평일_할인.생성(), List.of(디저트_아이스크림_1개.생성(), 음료_콜라_1개.생성()), 월_26일.생성());

    private final Benefits benefits;
    private final List<Order> orders;
    private final VisitDate visitDate;

    ReservationFixture(final Benefits benefits, final List<Order> orders, final VisitDate visitDate) {
        this.benefits = benefits;
        this.orders = orders;
        this.visitDate = visitDate;
    }

    public Reservation 생성() {
        return new Reservation(benefits, new Orders(orders), visitDate);
    }
}

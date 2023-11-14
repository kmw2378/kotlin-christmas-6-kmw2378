package christmas.domain.reservation;

import christmas.domain.benefit.BenefitType;
import christmas.domain.benefit.Benefits;
import christmas.domain.menu.Menu;
import christmas.domain.order.Orders;

public class Reservation {
    private final Benefits benefits;
    private final Orders orders;
    private final VisitDate visitDate;

    public Reservation(final Benefits benefits, final Orders orders, final VisitDate visitDate) {
        this.benefits = benefits;
        this.orders = orders;
        this.visitDate = visitDate;
    }

    public boolean existBenefitType(final BenefitType benefitType) {
        return benefits.existFromType(benefitType);
    }

    public boolean existMenu(final Menu menu) {
        return orders.existMenu(menu);
    }

    public long getTotalBenefitAmount() {
        return benefits.getTotalAmount(orders, visitDate);
    }

    public long getTotalBenefitAmountFromType(final BenefitType benefitType) {
        return benefits.getTotalAmountFromType(benefitType, orders, visitDate);
    }

    public long getTotalOrderAmount() {
        return orders.getTotalAmount();
    }

    public int getQuantityFromMenu(final Menu menu) {
        return orders.getTotalQuantityFromMenu(menu);
    }
}

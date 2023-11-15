package christmas.domain.benefit.sale;

import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.time.LocalDate;

public abstract class Sale {
    private final SaleType type;

    protected Sale(final SaleType type) {
        this.type = type;
    }

    public abstract boolean support(final LocalDate visitDate);
    public abstract long getAmount(final Orders orders, final VisitDate visitDate);

    public boolean equalsType(final SaleType type) {
        return this.type.equals(type);
    }
}

package christmas.domain.benefit;

import christmas.domain.benefit.gift.Gift;
import christmas.domain.benefit.gift.GiftType;
import christmas.domain.benefit.sale.Sale;
import christmas.domain.benefit.sale.SaleType;
import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.util.List;

public class Benefits {
    private final List<Benefit> benefits;

    public Benefits(final List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public String getGiftNameFromType(final GiftType giftType) {
        return getGiftFromType(giftType).getProductName();
    }

    public long getTotalAmount(final Orders orders, final VisitDate visitDate) {
        return benefits.stream()
                .map(b -> b.getAmount(orders, visitDate))
                .mapToLong(l -> l)
                .sum();
    }

    public long getGiftAmount() {
        return gifts.stream()
                .map(Gift::getAmount)
                .mapToLong(l -> l)
                .sum();
    }

    private long getSaleAmount(final Orders orders, final VisitDate visitDate) {
        return sales.stream()
                .map(s -> s.getAmount(orders, visitDate))
                .mapToLong(l -> l)
                .sum();
    }
}

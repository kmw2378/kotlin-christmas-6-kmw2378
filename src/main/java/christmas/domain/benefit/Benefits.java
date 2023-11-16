package christmas.domain.benefit;

import christmas.domain.benefit.gift.Gift;
import christmas.domain.benefit.gift.GiftType;
import christmas.domain.benefit.sale.Sale;
import christmas.domain.benefit.sale.SaleType;
import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.util.List;

public class Benefits {
    private final List<Gift> gifts;
    private final List<Sale> sales;

    public Benefits(final List<Gift> gifts, final List<Sale> sales) {
        this.gifts = gifts;
        this.sales = sales;
    }

    public boolean existFromType(final GiftType giftType) {
        return gifts.stream()
                .anyMatch(g -> g.equalsType(giftType));
    }

    public boolean existFromType(final SaleType saleType) {
        return sales.stream()
                .anyMatch(s -> s.equalsType(saleType));
    }

    public String getGiftNameFromType(final GiftType giftType) {
        return getGiftFromType(giftType).getProductName();
    }

    public int getGiftQuantityFromType(final GiftType giftType) {
        return getGiftFromType(giftType).getQuantity();
    }

    public long getTotalAmount(final Orders orders, final VisitDate visitDate) {
        return getGiftAmount() + getSaleAmount(orders, visitDate);
    }

    public long getTotalAmountFromType(final SaleType saleType,
                                       final Orders orders,
                                       final VisitDate visitDate) {
        return sales.stream()
                .filter(s -> s.equalsType(saleType))
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

    private Gift getGiftFromType(final GiftType giftType) {
        return gifts.stream()
                .filter(g -> g.equalsType(giftType))
                .findAny()
                .orElseThrow(() -> new IllegalStateException());
    }
}

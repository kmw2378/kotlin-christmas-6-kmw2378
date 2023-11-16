package christmas.domain.reservation;

import christmas.domain.benefit.Benefits;
import christmas.domain.benefit.gift.GiftType;
import christmas.domain.benefit.sale.SaleType;
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

    public boolean existMenu(final Menu menu) {
        return orders.existMenu(menu);
    }

    public String getGiftNameFromType(final GiftType giftType) {
        return benefits.getGiftNameFromType(giftType);
    }

    public int getGiftQuantityFromType(final GiftType giftType) {
        return benefits.getGiftQuantityFromType(giftType);
    }

    public long getTotalBenefitAmount() {
        return benefits.getTotalAmount(orders, visitDate);
    }

    public long getTotalBenefitAmountFromType(final SaleType saleType) {
        return benefits.getTotalAmountFromType(saleType, orders, visitDate);
    }

    public long getGiftAmount() {
        return benefits.getGiftAmount();
    }

    public long getTotalOrderAmount() {
        return orders.getTotalAmount();
    }

    public int getQuantityFromMenu(final Menu menu) {
        return orders.getTotalQuantityFromMenu(menu);
    }

    public boolean existGiftType(final GiftType giftType) {
        return benefits.existFromType(giftType);
    }
}

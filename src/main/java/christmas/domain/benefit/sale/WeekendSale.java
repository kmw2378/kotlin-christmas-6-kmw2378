package christmas.domain.benefit.sale;

import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.time.LocalDate;

import static christmas.config.PromotionConfig.WEEKEND_DATES;
import static christmas.config.PromotionConfig.WEEKEND_PER_SALE_AMOUNT;
import static christmas.domain.benefit.sale.SaleType.WEEKEND;
import static christmas.domain.menu.MenuType.MAIN;

public class WeekendSale extends Sale {
    public WeekendSale() {
        super(WEEKEND);
    }

    @Override
    public boolean support(final LocalDate visitDate) {
        return WEEKEND_DATES.contains(visitDate);
    }

    @Override
    public long getAmount(final Orders orders, final VisitDate visitDate) {
        return orders.getTotalQuantityFromMenuType(MAIN) * WEEKEND_PER_SALE_AMOUNT;
    }
}

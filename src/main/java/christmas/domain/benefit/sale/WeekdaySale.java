package christmas.domain.benefit.sale;

import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.time.LocalDate;

import static christmas.config.PromotionConfig.WEEKDAY_PER_SALE_AMOUNT;
import static christmas.config.PromotionConfig.WEEKEND_DATES;
import static christmas.domain.benefit.sale.SaleType.WEEKDAY;
import static christmas.domain.menu.MenuType.DESERT;

public class WeekdaySale extends Sale {
    public WeekdaySale() {
        super(WEEKDAY);
    }

    @Override
    public boolean support(final LocalDate visitDate) {
        return !WEEKEND_DATES.contains(visitDate);
    }

    @Override
    public long getAmount(final Orders orders, final VisitDate visitDate) {
        return orders.getTotalQuantityFromMenuType(DESERT) * WEEKDAY_PER_SALE_AMOUNT;
    }
}

package christmas.domain.benefit.sale;

import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.config.PromotionConfig.WEEKDAY_PER_SALE_AMOUNT;
import static christmas.domain.benefit.sale.SaleType.WEEKDAY;
import static christmas.domain.menu.MenuType.DESERT;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;

public class WeekdaySale extends Sale {
    public WeekdaySale() {
        super(WEEKDAY);
    }

    @Override
    public boolean support(final LocalDate visitDate) {
        final DayOfWeek convertedWeek = localDateToWeekConverter.convert(visitDate);
        final int weekValue = convertedWeek.getValue();
        return SUNDAY <= weekValue && weekValue <= THURSDAY;
    }

    @Override
    public long getAmount(final Orders orders, final VisitDate visitDate) {
        return orders.getTotalQuantityFromMenuType(DESERT) * WEEKDAY_PER_SALE_AMOUNT;
    }
}

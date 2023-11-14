package christmas.domain.benefit.sale;

import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.config.PromotionConfig.WEEKEND_PER_SALE_AMOUNT;
import static christmas.domain.benefit.BenefitType.WEEKEND;
import static christmas.domain.menu.MenuType.MAIN;
import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.SATURDAY;

public class WeekendSale extends Sale {
    public WeekendSale() {
        super(WEEKEND);
    }

    @Override
    public boolean support(final LocalDate visitDate) {
        final DayOfWeek convertedWeek = localDateToWeekConverter.convert(visitDate);
        final int weekValue = convertedWeek.getValue();
        return FRIDAY <= weekValue && weekValue <= SATURDAY;
    }

    @Override
    public long getAmount(final Orders orders, final VisitDate visitDate) {
        return orders.getTotalQuantityFromMenuType(MAIN) * WEEKEND_PER_SALE_AMOUNT;
    }
}

package christmas.domain.benefit;

import christmas.domain.order.Orders;
import christmas.converter.Converter;
import christmas.converter.LocalDateToWeekConverter;
import christmas.domain.reservation.VisitDate;
import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class Benefit {
    protected static final Converter<LocalDate, DayOfWeek> localDateToWeekConverter = new LocalDateToWeekConverter();
    private final BenefitType type;

    protected Benefit(final BenefitType type) {
        this.type = type;
    }

    public abstract long getAmount(final Orders orders, final VisitDate visitDate);

    public boolean equalsType(final BenefitType type) {
        return this.type.equals(type);
    }
}

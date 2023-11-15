package christmas.domain.benefit.sale;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;

import java.time.LocalDate;

public abstract class Sale {
    protected static final Converter<LocalDate, DayOfWeek> localDateToWeekConverter = new LocalDateToWeekConverter();
    private final SaleType type;

    protected Sale(final SaleType type) {
        this.type = type;
    }

    public abstract boolean support(final LocalDate visitDate);
}

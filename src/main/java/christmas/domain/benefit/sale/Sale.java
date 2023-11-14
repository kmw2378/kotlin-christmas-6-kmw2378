package christmas.domain.benefit.sale;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;

import java.time.LocalDate;

public abstract class Sale extends Benefit {
    protected Sale(final BenefitType type) {
        super(type);
    }

    public abstract boolean support(final LocalDate visitDate);
}

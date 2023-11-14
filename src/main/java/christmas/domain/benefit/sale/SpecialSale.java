package christmas.domain.benefit.sale;

import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.time.LocalDate;

import static christmas.config.PromotionConfig.SPECIAL_DATES;
import static christmas.config.PromotionConfig.SPECIAL_SALE_AMOUNT;
import static christmas.domain.benefit.BenefitType.SPECIAL;

public class SpecialSale extends Sale {
    public SpecialSale() {
        super(SPECIAL);
    }

    @Override
    public boolean support(final LocalDate visitDate) {
        return SPECIAL_DATES.contains(visitDate);
    }

    @Override
    public long getAmount(final Orders orders, final VisitDate visitDate) {
        return SPECIAL_SALE_AMOUNT;
    }
}

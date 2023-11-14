package christmas.domain.benefit.sale;

import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.time.LocalDate;

import static christmas.config.PromotionConfig.D_DAY_SALE_AMOUNT_INCREMENT;
import static christmas.config.PromotionConfig.D_DAY_SALE_END_DAY;
import static christmas.config.PromotionConfig.D_DAY_SALE_START_AMOUNT;
import static christmas.config.PromotionConfig.D_DAY_SALE_START_DAY;
import static christmas.domain.benefit.BenefitType.D_DAY;

public class DDaySale extends Sale {
    public DDaySale() {
        super(D_DAY);
    }

    @Override
    public boolean support(final LocalDate visitDate) {
        final int visitDay = visitDate.getDayOfMonth();
        return D_DAY_SALE_START_DAY <= visitDay && visitDay <= D_DAY_SALE_END_DAY;
    }

    @Override
    public long getAmount(final Orders orders, final VisitDate visitDate) {
        return (visitDate.getDate().getDayOfMonth() - D_DAY_SALE_START_DAY) * D_DAY_SALE_AMOUNT_INCREMENT + D_DAY_SALE_START_AMOUNT;
    }
}

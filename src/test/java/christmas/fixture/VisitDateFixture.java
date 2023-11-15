package christmas.fixture;

import christmas.domain.reservation.VisitDate;

import java.time.LocalDate;

import static christmas.config.PromotionConfig.PROMOTION_MONTH;
import static christmas.config.PromotionConfig.PROMOTION_YEAR;

public enum VisitDateFixture {
    월_26일(26);

    private final int day;

    VisitDateFixture(final int day) {
        this.day = day;
    }

    public VisitDate 생성() {
        return new VisitDate(LocalDate.of(PROMOTION_YEAR, PROMOTION_MONTH, day));
    }
}

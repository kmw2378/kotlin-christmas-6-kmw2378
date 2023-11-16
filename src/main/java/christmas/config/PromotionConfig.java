package christmas.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class PromotionConfig {
    public static final int PROMOTION_YEAR = 2023;
    public static final int PROMOTION_MONTH = 12;
    public static final int PROMOTION_START_DAY = 1;
    public static final int PROMOTION_END_DAY = 31;
    public static final int MIN_ORDER_QUANTITY = 1;
    public static final int MAX_ORDER_QUANTITY = 20;
    public static final int MENU_GIFT_QUANTITY = 1;
    public static final long MIN_AVAILABLE_MENU_GIFT_AMOUNT = 120_000L;
    public static final long MIN_AVAILABLE_BENEFIT_AMOUNT = 10_000L;
    public static final long WEEKDAY_PER_SALE_AMOUNT = 2_023L;
    public static final long WEEKEND_PER_SALE_AMOUNT = 2_023L;
    public static final long SPECIAL_SALE_AMOUNT = 1_000L;
    public static final int D_DAY_SALE_START_DAY = 1;
    public static final int D_DAY_SALE_END_DAY = 25;
    public static final long D_DAY_SALE_START_AMOUNT = 1_000L;
    public static final long D_DAY_SALE_AMOUNT_INCREMENT = 100L;
    public static final List<LocalDate> SPECIAL_DATES = createSpecialDates();
    public static final List<LocalDate> WEEKEND_DATES = createWeekendDates();

    private PromotionConfig() {}

    private static List<LocalDate> createSpecialDates() {
        final List<LocalDate> specialDates = new ArrayList<>();
        for (int i = 3; i <= PROMOTION_END_DAY; i += 7) {
            specialDates.add(LocalDate.of(PROMOTION_YEAR, PROMOTION_MONTH, i));
        }

        specialDates.add(LocalDate.of(PROMOTION_YEAR, PROMOTION_MONTH, 25));
        return specialDates;
    }

    private static List<LocalDate> createWeekendDates() {
        final List<LocalDate> weekendDates = new ArrayList<>();
        for (int i = 1; i <= PROMOTION_END_DAY; i += 7) {
            weekendDates.add(LocalDate.of(PROMOTION_YEAR, PROMOTION_MONTH, i));
            weekendDates.add(LocalDate.of(PROMOTION_YEAR, PROMOTION_MONTH, i + 1));
        }

        return weekendDates;
    }
}

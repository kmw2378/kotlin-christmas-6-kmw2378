package christmas.fixture;

import christmas.domain.benefit.Benefits;
import christmas.domain.benefit.gift.Gift;
import christmas.domain.benefit.sale.Sale;
import christmas.domain.benefit.sale.WeekdaySale;

import java.util.Collections;
import java.util.List;

public enum BenefitsFixture {
    증정X_평일_할인(Collections.emptyList(), List.of(new WeekdaySale())),
    혜택X(Collections.emptyList(), Collections.emptyList());

    private final List<Gift> gifts;
    private final List<Sale> sales;

    BenefitsFixture(final List<Gift> gifts, final List<Sale> sales) {
        this.gifts = gifts;
        this.sales = sales;
    }

    public Benefits 생성() {
        return new Benefits(gifts, sales);
    }
}

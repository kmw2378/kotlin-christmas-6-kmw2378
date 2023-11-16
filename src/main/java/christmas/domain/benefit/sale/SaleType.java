package christmas.domain.benefit.sale;

public enum SaleType {
    D_DAY("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인");

    private final String name;

    SaleType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

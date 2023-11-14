package christmas.domain.benefit;

public enum BenefitType {
    D_DAY("크리스마스 디데이 할인", true),
    WEEKDAY("평일 할인", true),
    WEEKEND("주말 할인", true),
    SPECIAL("특별 할인", true),
    GIFT("증정 이벤트", false);

    private final String name;
    private final boolean reflectedBenefitAmount;

    BenefitType(final String name, final boolean reflectedBenefitAmount) {
        this.name = name;
        this.reflectedBenefitAmount = reflectedBenefitAmount;
    }

    public String getName() {
        return name;
    }

    public boolean isReflectedBenefitAmount() {
        return reflectedBenefitAmount;
    }
}

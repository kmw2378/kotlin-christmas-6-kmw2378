package christmas.domain.benefit.gift;

import christmas.domain.benefit.Benefit;

import static christmas.domain.benefit.BenefitType.GIFT;

public abstract class Gift extends Benefit {
    private final String productName;
    private final GiftQuantity quantity;

    protected Gift(final String productName,
                   final GiftQuantity quantity) {
        super(GIFT);
        this.productName = productName;
        this.quantity = quantity;
    }

    public abstract boolean support(final long totalOrderAmount);

    public String getProductName() {
        return productName;
    }

    protected GiftQuantity getQuantity() {
        return quantity;
    }
}

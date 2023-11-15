package christmas.domain.benefit.gift;

import christmas.domain.benefit.Benefit;

import static christmas.domain.benefit.BenefitType.GIFT;

public abstract class Gift extends Benefit {
    private final String productName;
    private final int quantity;
    private final GiftType type;

    protected Gift(final String productName,
                   final int quantity,
                   final GiftType type) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public abstract boolean support(final long totalOrderAmount);

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}

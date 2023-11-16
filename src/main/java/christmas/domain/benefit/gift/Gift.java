package christmas.domain.benefit.gift;

public abstract class Gift {
    private final String productName;
    private final int quantity;
    private final GiftType type;

    protected Gift(final String productName,
                   final int quantity,
                   final GiftType type) {
        this.productName = productName;
        this.quantity = quantity;
        this.type = type;
    }

    public abstract boolean support(final long totalOrderAmount);
    public abstract long getAmount();

    public boolean equalsType(final GiftType type) {
        return this.type.equals(type);
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}

package christmas.domain.order;

public class OrderQuantity {
    private final int quantity;

    public OrderQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}

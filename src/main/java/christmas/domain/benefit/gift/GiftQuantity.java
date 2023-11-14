package christmas.domain.benefit.gift;

import christmas.exception.InputException;

import static christmas.config.PromotionConfig.MIN_MENU_GIFT_QUANTITY;
import static christmas.exception.errorcode.ErrorCode.INVALID_GIFT_QUANTITY;

public class GiftQuantity {
    private final int quantity;

    public GiftQuantity(final int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    public void validateQuantity(final long quantity) {
        if (quantity < MIN_MENU_GIFT_QUANTITY) {
            throw new InputException(INVALID_GIFT_QUANTITY);
        }
    }
    
    public long calculateTotalAmount(final long amount) {
        return amount * quantity;
    }
}

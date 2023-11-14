package christmas.domain.benefit.gift;

import christmas.domain.menu.Menu;
import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;

import static christmas.config.PromotionConfig.MIN_AVAILABLE_MENU_GIFT_AMOUNT;

public class MenuGift extends Gift {
    private final Menu menu;
    public MenuGift(final Menu menu, final GiftQuantity quantity) {
        super(menu.name(), quantity);
        this.menu = menu;
    }

    @Override
    public boolean support(final long totalOrderAmount) {
        return totalOrderAmount >= MIN_AVAILABLE_MENU_GIFT_AMOUNT;
    }

    @Override
    public long getAmount(final Orders orders, final VisitDate visitDate) {
        return getQuantity().calculateTotalAmount(menu.getAmount());
    }
}

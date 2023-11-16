package christmas.generator;

import christmas.domain.benefit.Benefits;
import christmas.domain.benefit.gift.Gift;
import christmas.domain.benefit.gift.MenuGift;
import christmas.domain.benefit.sale.DDaySale;
import christmas.domain.benefit.sale.Sale;
import christmas.domain.benefit.sale.SpecialSale;
import christmas.domain.benefit.sale.WeekdaySale;
import christmas.domain.benefit.sale.WeekendSale;
import christmas.dto.reservaiton.request.ReservationRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static christmas.config.PromotionConfig.MENU_GIFT_QUANTITY;
import static christmas.config.PromotionConfig.MIN_AVAILABLE_BENEFIT_AMOUNT;
import static christmas.domain.menu.Menu.CHAMPAGNE;

public class BenefitsGenerator implements Generator<ReservationRequest, Benefits> {
    private static final List<Sale> SALES = initSales();
    private static final List<Gift> GIFTS = initGifts();

    @Override
    public Benefits generate(final ReservationRequest reservationRequest) {
        if (!available(reservationRequest)) {
            return new Benefits(Collections.emptyList(), Collections.emptyList());
        }

        final List<Gift> gifts = createGifts(reservationRequest);
        final List<Sale> sales = createSales(reservationRequest);
        return new Benefits(gifts, sales);
    }

    private boolean available(final ReservationRequest reservationRequest) {
        return reservationRequest.totalOrderAmount() >= MIN_AVAILABLE_BENEFIT_AMOUNT;
    }

    private List<Gift> createGifts(final ReservationRequest reservationRequest) {
        return GIFTS.stream()
                .filter(e -> e.support(reservationRequest.totalOrderAmount()))
                .toList();
    }

    private List<Sale> createSales(final ReservationRequest reservationRequest) {
        final LocalDate visitDate = reservationRequest.visitDate();
        return SALES.stream()
                .filter(s -> s.support(visitDate))
                .toList();
    }

    private static List<Sale> initSales() {
        final List<Sale> sales = new ArrayList<>();
        sales.add(new WeekdaySale());
        sales.add(new WeekendSale());
        sales.add(new SpecialSale());
        sales.add(new DDaySale());
        return sales;
    }

    private static List<Gift> initGifts() {
        final List<Gift> gifts = new ArrayList<>();
        gifts.add(new MenuGift(CHAMPAGNE, MENU_GIFT_QUANTITY));
        return gifts;
    }
}

package christmas.generator;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.Benefits;
import christmas.domain.benefit.gift.Gift;
import christmas.domain.benefit.gift.MenuGift;
import christmas.domain.benefit.gift.GiftQuantity;
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
        final List<Benefit> benefits = createBenefits(reservationRequest);
        return new Benefits(benefits);
    }

    private List<Benefit> createBenefits(final ReservationRequest reservationRequest) {
        if (!available(reservationRequest)) {
            return Collections.emptyList();
        }

        final List<Benefit> benefits = new ArrayList<>();
        benefits.addAll(createSales(reservationRequest));
        benefits.addAll(createEvents(reservationRequest));
        return benefits;
    }

    private boolean available(final ReservationRequest reservationRequest) {
        return reservationRequest.totalOrderAmount() > MIN_AVAILABLE_BENEFIT_AMOUNT;
    }

    private List<Benefit> createSales(final ReservationRequest reservationRequest) {
        final LocalDate visitDate = reservationRequest.visitDate();
        return SALES.stream()
                .filter(s -> s.support(visitDate))
                .map(s -> (Benefit) s)
                .toList();
    }

    private List<Benefit> createEvents(final ReservationRequest reservationRequest) {
        return GIFTS.stream()
                .filter(e -> e.support(reservationRequest.totalOrderAmount()))
                .map(s -> (Benefit) s)
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
        gifts.add(new MenuGift(CHAMPAGNE, new GiftQuantity(MENU_GIFT_QUANTITY)));
        return gifts;
    }
}

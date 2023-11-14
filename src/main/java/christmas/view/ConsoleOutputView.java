package christmas.view;

import christmas.dto.badge.response.BadgeResponse;
import christmas.dto.benefit.response.AmountResponse;
import christmas.dto.benefit.response.BenefitRecordResponse;
import christmas.dto.benefit.response.BenefitResponse;
import christmas.dto.benefit.response.GiftResponse;
import christmas.dto.menu.response.MenuResponse;
import christmas.dto.order.response.OrderResponse;
import christmas.dto.reservaiton.response.VisitDateResponse;
import java.util.List;

import static christmas.domain.badge.Badge.NONE;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printPromotionStartMessage() {
        System.out.println(PROMOTION_START_MESSAGE);
    }

    @Override
    public void printPromotionResultMessage(final VisitDateResponse visitDateResponse) {
        System.out.println(String.format(PROMOTION_RESULT_FORMAT, visitDateResponse.day()));
        System.out.println();
    }

    @Override
    public void printOrderMessage(final OrderResponse orderResponse) {
        System.out.println(MENUS_TITLE);
        printMenus(orderResponse);
        printAmountMessage(ORDER_AMOUNT_TITLE, ORDER_AMOUNT_FORMAT, orderResponse.totalAmount());
    }

    @Override
    public void printBenefitMessage(final BenefitResponse benefitResponse) {
        System.out.println(GIFT_TITLE);
        printGiftMessage(benefitResponse.gifts());
        printBenefitRecordMessage(benefitResponse.benefits());
        printAmountMessage(benefitResponse.amountResponse());
    }

    @Override
    public void printBadgeMessage(final BadgeResponse badgeResponse) {
        System.out.println(BADGE_TITLE);
        if (badgeResponse.name().equals(NONE.name())) {
            System.out.println(BADGE_NONE_MESSAGE);
            return;
        }

        System.out.println(badgeResponse.name());
    }

    @Override
    public void printErrorMessage(final IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    private void printMenus(OrderResponse orderResponse) {
        final List<MenuResponse> menus = orderResponse.menus();
        for (MenuResponse menu : menus) {
            System.out.println(String.format(ORDER_MENU_FORMAT, menu.name(), menu.quantity()));
        }

        System.out.println();
    }

    private void printGiftMessage(final List<GiftResponse> giftResponses) {
        for (GiftResponse giftResponse : giftResponses) {
            System.out.println(String.format(GIFT_FORMAT, giftResponse.name(), giftResponse.quantity()));
        }

        if (giftResponses.isEmpty()) {
            System.out.println(GIFT_EMPTY_MESSAGE);
        }

        System.out.println();
    }

    private void printBenefitRecordMessage(final List<BenefitRecordResponse> benefitRecordResponses) {
        System.out.println(BENEFIT_RECORD_TITLE);
        for (BenefitRecordResponse benefitRecordResponse : benefitRecordResponses) {
            System.out.println(String.format(BENEFIT_RECORD_FORMAT, benefitRecordResponse.benefitName(), benefitRecordResponse.totalAmount()));
        }

        if (benefitRecordResponses.isEmpty()) {
            System.out.println(BENEFIT_RECORD_EMPTY_MESSAGE);
        }

        System.out.println();
    }

    private void printAmountMessage(final AmountResponse amountResponse) {
        printAmountMessage(TOTAL_BENEFIT_AMOUNT_TITLE, TOTAL_BENEFIT_AMOUNT_FORMAT, - amountResponse.totalBenefitAmount());
        printAmountMessage(PAYMENT_AMOUNT_TITLE, PAYMENT_AMOUNT_FORMAT, amountResponse.totalPaymentAmount());
    }

    private void printAmountMessage(final String title, final String format, final long amount) {
        System.out.println(title);
        System.out.println(String.format(format, amount));
        System.out.println();
    }
}

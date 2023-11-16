package christmas.view;

import christmas.dto.badge.response.BadgeResponse;
import christmas.dto.benefit.response.BenefitResponse;
import christmas.dto.order.response.OrderResponse;
import christmas.dto.reservaiton.response.VisitDateResponse;

import static christmas.config.PromotionConfig.PROMOTION_MONTH;

public interface OutputView {
    String PROMOTION_START_MESSAGE = "안녕하세요! 우테코 식당 " + PROMOTION_MONTH + "월 이벤트 플래너입니다.";
    String PROMOTION_RESULT_FORMAT = PROMOTION_MONTH + "월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    String MENUS_TITLE = "<주문 메뉴>";
    String ORDER_MENU_FORMAT = "%s %d개";
    String ORDER_AMOUNT_TITLE = "<할인 전 총주문 금액>";
    String ORDER_AMOUNT_FORMAT = "%,d원";
    String GIFT_TITLE = "<증정 메뉴>";
    String GIFT_FORMAT = "%s %d개";
    String GIFT_EMPTY_MESSAGE = "없음";
    String BENEFIT_RECORD_TITLE = "<혜택 내역>";
    String BENEFIT_RECORD_FORMAT = "%s: -%,d원";
    String BENEFIT_RECORD_EMPTY_MESSAGE = "없음";
    String TOTAL_BENEFIT_AMOUNT_TITLE = "<총혜택 금액>";
    String TOTAL_BENEFIT_AMOUNT_FORMAT = "%,d원";
    String PAYMENT_AMOUNT_TITLE = "<할인 후 예상 결제 금액>";
    String PAYMENT_AMOUNT_FORMAT = "%,d원";
    String BADGE_TITLE = "<" + PROMOTION_MONTH + "월 이벤트 배지>";
    String BADGE_NONE_MESSAGE = "없음";

    void printPromotionStartMessage();
    void printPromotionResultMessage(final VisitDateResponse visitDateResponse);
    void printOrderMessage(final OrderResponse orderResponse);
    void printBenefitMessage(final BenefitResponse benefitResponse);
    void printBadgeMessage(final BadgeResponse badgeResponse);
    void printErrorMessage(final IllegalArgumentException exception);
}

package christmas.controller;

import christmas.domain.reservation.Reservation;
import christmas.domain.reservation.VisitDate;
import christmas.domain.user.User;
import christmas.dto.badge.response.BadgeResponse;
import christmas.dto.benefit.response.BenefitResponse;
import christmas.dto.order.request.OrderRequest;
import christmas.dto.order.response.OrderResponse;
import christmas.dto.reservaiton.request.VisitDateRequest;
import christmas.dto.reservaiton.response.VisitDateResponse;
import christmas.exception.InputException;
import christmas.service.PromotionService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PromotionService promotionService;

    public PromotionController(final InputView inputView,
                               final OutputView outputView,
                               final PromotionService promotionService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.promotionService = promotionService;
    }

    public void start() {
        outputView.printPromotionStartMessage();
        final VisitDate visitDate = getVisitDate();
        final Reservation reservation = getReservation(visitDate);
        final User user = getUser(reservation);

        final VisitDateResponse visitDateResponse = promotionService.createVisitDateResponse(visitDate);
        printResult(reservation, user, visitDateResponse);
    }

    private VisitDate getVisitDate() {
        try {
            final VisitDateRequest visitDateRequest = inputView.requestVisitDay();
            return promotionService.createVisitDate(visitDateRequest);
        } catch (InputException e) {
            outputView.printErrorMessage(e);
            return getVisitDate();
        }
    }

    private Reservation getReservation(final VisitDate visitDate) {
        try {
            final List<OrderRequest> orderRequests = inputView.requestOrders();
            return promotionService.createReservation(orderRequests, visitDate);
        } catch (InputException e) {
            outputView.printErrorMessage(e);
            return getReservation(visitDate);
        }
    }

    private User getUser(final Reservation reservation) {
        return promotionService.createUser(reservation);
    }

    private void printResult(final Reservation reservation,
                             final User user,
                             final VisitDateResponse visitDateResponse) {
        outputView.printPromotionResultMessage(visitDateResponse);
        printOrder(reservation);
        printBenefit(reservation);
        printBadge(user);
    }

    private void printOrder(final Reservation reservation) {
        final OrderResponse orderResponse = promotionService.createOrderResponse(reservation);
        outputView.printOrderMessage(orderResponse);
    }

    private void printBenefit(final Reservation reservation) {
        final BenefitResponse benefitResponse = promotionService.createBenefitResponse(reservation);
        outputView.printBenefitMessage(benefitResponse);
    }

    private void printBadge(final User user) {
        final BadgeResponse badgeResponse = promotionService.createBadgeResponse(user);
        outputView.printBadgeMessage(badgeResponse);
    }
}

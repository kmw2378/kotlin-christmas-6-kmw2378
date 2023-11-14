package christmas.service;

import christmas.domain.badge.Badge;
import christmas.domain.benefit.Benefits;
import christmas.domain.order.Orders;
import christmas.domain.reservation.Reservation;
import christmas.domain.reservation.VisitDate;
import christmas.domain.user.User;
import christmas.dto.badge.response.BadgeResponse;
import christmas.dto.benefit.response.BenefitResponse;
import christmas.dto.order.request.OrderRequest;
import christmas.dto.order.response.OrderResponse;
import christmas.dto.reservaiton.request.ReservationRequest;
import christmas.dto.reservaiton.request.VisitDateRequest;
import christmas.dto.reservaiton.response.VisitDateResponse;
import java.util.List;

public class PromotionService {
    private final GeneratorService generatorService;
    private final MapperService mapperService;

    public PromotionService(final GeneratorService generatorService,
                            final MapperService mapperService) {
        this.generatorService = generatorService;
        this.mapperService = mapperService;
    }

    public VisitDate createVisitDate(final VisitDateRequest visitDateRequest) {
        return generatorService.generateVisitDate(visitDateRequest);
    }

    public User createUser(final List<OrderRequest> orderRequests,
                           final VisitDate visitDate) {
        final Reservation reservation = createReservation(orderRequests, visitDate);
        final Badge badge = generatorService.generateBadge(reservation.getTotalBenefitAmount());
        return new User(badge, reservation);
    }

    public BadgeResponse createBadgeResponse(final User user) {
        return mapperService.mapBadgeResponse(user);
    }

    public BenefitResponse createBenefitResponse(final User user) {
        return mapperService.mapBenefitResponse(user);
    }

    public OrderResponse createOrderResponse(final User user) {
        return mapperService.mapOrderResponse(user);
    }

    public VisitDateResponse createVisitDateResponse(final VisitDate visitDate) {
        return mapperService.mapVisitDateResponse(visitDate);
    }

    private Reservation createReservation(final List<OrderRequest> orderRequests,
                                          final VisitDate visitDate) {
        final Orders orders = generatorService.generateOrders(orderRequests);
        final ReservationRequest reservationRequest = new ReservationRequest(visitDate.getDate(), orders.getTotalAmount());
        final Benefits benefits = generatorService.generateBenefits(reservationRequest);
        return new Reservation(benefits, orders, visitDate);
    }
}

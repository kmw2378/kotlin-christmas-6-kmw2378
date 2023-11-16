package christmas.service;

import christmas.domain.reservation.Reservation;
import christmas.domain.reservation.VisitDate;
import christmas.domain.user.User;
import christmas.dto.badge.response.BadgeResponse;
import christmas.dto.benefit.response.BenefitResponse;
import christmas.dto.order.response.OrderResponse;
import christmas.dto.reservaiton.response.VisitDateResponse;
import christmas.mapper.ResponseMapper;

public class MapperService {
    private final ResponseMapper<User, BadgeResponse> badgeResponseMapper;
    private final ResponseMapper<Reservation, BenefitResponse> benefitResponseMapper;
    private final ResponseMapper<Reservation, OrderResponse> orderResponseMapper;
    private final ResponseMapper<VisitDate, VisitDateResponse> visitDateResponseMapper;

    public MapperService(final ResponseMapper<User, BadgeResponse> badgeResponseMapper,
                         final ResponseMapper<Reservation, BenefitResponse> benefitResponseMapper,
                         final ResponseMapper<Reservation, OrderResponse> orderResponseMapper,
                         final ResponseMapper<VisitDate, VisitDateResponse> visitDateResponseMapper) {
        this.badgeResponseMapper = badgeResponseMapper;
        this.benefitResponseMapper = benefitResponseMapper;
        this.orderResponseMapper = orderResponseMapper;
        this.visitDateResponseMapper = visitDateResponseMapper;
    }

    public VisitDateResponse mapVisitDateResponse(final VisitDate visitDate) {
        return visitDateResponseMapper.map(visitDate);
    }

    public OrderResponse mapOrderResponse(final Reservation reservation) {
        return orderResponseMapper.map(reservation);
    }

    public BenefitResponse mapBenefitResponse(final Reservation reservation) {
        return benefitResponseMapper.map(reservation);
    }

    public BadgeResponse mapBadgeResponse(final User user) {
        return badgeResponseMapper.map(user);
    }
}

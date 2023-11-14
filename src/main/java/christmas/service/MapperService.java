package christmas.service;

import christmas.domain.reservation.VisitDate;
import christmas.domain.user.User;
import christmas.dto.badge.response.BadgeResponse;
import christmas.dto.benefit.response.BenefitResponse;
import christmas.dto.order.response.OrderResponse;
import christmas.dto.reservaiton.response.VisitDateResponse;
import christmas.mapper.ResponseMapper;

public class MapperService {
    private final ResponseMapper<User, BadgeResponse> badgeResponseMapper;
    private final ResponseMapper<User, BenefitResponse> benefitResponseMapper;
    private final ResponseMapper<User, OrderResponse> orderResponseMapper;
    private final ResponseMapper<VisitDate, VisitDateResponse> visitDateResponseMapper;

    public MapperService(final ResponseMapper<User, BadgeResponse> badgeResponseMapper,
                         final ResponseMapper<User, BenefitResponse> benefitResponseMapper,
                         final ResponseMapper<User, OrderResponse> orderResponseMapper,
                         final ResponseMapper<VisitDate, VisitDateResponse> visitDateResponseMapper) {
        this.badgeResponseMapper = badgeResponseMapper;
        this.benefitResponseMapper = benefitResponseMapper;
        this.orderResponseMapper = orderResponseMapper;
        this.visitDateResponseMapper = visitDateResponseMapper;
    }

    public VisitDateResponse mapVisitDateResponse(final VisitDate visitDate) {
        return visitDateResponseMapper.map(visitDate);
    }

    public OrderResponse mapOrderResponse(final User user) {
        return orderResponseMapper.map(user);
    }

    public BenefitResponse mapBenefitResponse(final User user) {
        return benefitResponseMapper.map(user);
    }

    public BadgeResponse mapBadgeResponse(final User user) {
        return badgeResponseMapper.map(user);
    }
}

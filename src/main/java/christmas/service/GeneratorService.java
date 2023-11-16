package christmas.service;

import christmas.domain.badge.Badge;
import christmas.domain.benefit.Benefits;
import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import christmas.dto.order.request.OrderRequest;
import christmas.dto.reservaiton.request.ReservationRequest;
import christmas.dto.reservaiton.request.VisitDateRequest;
import christmas.generator.Generator;
import java.util.List;

public class GeneratorService {
    private final Generator<Long, Badge> badgeGenerator;
    private final Generator<ReservationRequest, Benefits> benefitsGenerator;
    private final Generator<List<OrderRequest>, Orders> ordersGenerator;
    private final Generator<VisitDateRequest, VisitDate> visitDateGenerator;

    public GeneratorService(final Generator<Long, Badge> badgeGenerator,
                            final Generator<ReservationRequest, Benefits> benefitsGenerator,
                            final Generator<List<OrderRequest>, Orders> ordersGenerator,
                            final Generator<VisitDateRequest, VisitDate> visitDateGenerator) {
        this.badgeGenerator = badgeGenerator;
        this.benefitsGenerator = benefitsGenerator;
        this.ordersGenerator = ordersGenerator;
        this.visitDateGenerator = visitDateGenerator;
    }

    public Badge generateBadge(final Long totalBenefitAmount) {
        return badgeGenerator.generate(totalBenefitAmount);
    }

    public Benefits generateBenefits(final ReservationRequest reservationRequest) {
        return benefitsGenerator.generate(reservationRequest);
    }

    public Orders generateOrders(final List<OrderRequest> orderRequests) {
        return ordersGenerator.generate(orderRequests);
    }

    public VisitDate generateVisitDate(final VisitDateRequest visitDateRequest) {
        return visitDateGenerator.generate(visitDateRequest);
    }
}

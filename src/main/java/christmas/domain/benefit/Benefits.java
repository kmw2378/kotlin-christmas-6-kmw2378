package christmas.domain.benefit;

import christmas.domain.order.Orders;
import christmas.domain.reservation.VisitDate;
import java.util.List;

public class Benefits {
    private final List<Benefit> benefits;

    public Benefits(final List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public boolean existFromType(final BenefitType benefitType) {
        return benefits.stream()
                .anyMatch(b -> b.equalsType(benefitType));
    }

    public long getTotalAmount(final Orders orders, final VisitDate visitDate) {
        return benefits.stream()
                .map(b -> b.getAmount(orders, visitDate))
                .mapToLong(l -> l)
                .sum();
    }

    public long getTotalAmountFromType(final BenefitType type, final Orders orders, final VisitDate visitDate) {
        return benefits.stream()
                .filter(b -> b.equalsType(type))
                .map(b -> b.getAmount(orders, visitDate))
                .mapToLong(l -> l)
                .sum();
    }
}

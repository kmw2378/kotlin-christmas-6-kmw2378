package christmas.domain.user;

import christmas.domain.badge.Badge;
import christmas.domain.menu.Menu;
import christmas.domain.reservation.Reservation;

public class User {
    private final Badge badge;
    private final Reservation reservation;

    public User(final Badge badge, final Reservation reservation) {
        this.badge = badge;
        this.reservation = reservation;
    }

    public boolean equalsBadge(final Badge badge) {
        return this.badge.equals(badge);
    }

    public boolean existBenefitType(final BenefitType benefitType) {
        return reservation.existBenefitType(benefitType);
    }

    public boolean existMenu(final Menu menu) {
        return reservation.existMenu(menu);
    }

    public long getTotalOrderAmount() {
        return reservation.getTotalOrderAmount();
    }

    public long getTotalBenefitAmountFromType(final BenefitType benefitType) {
        return reservation.getTotalBenefitAmountFromType(benefitType);
    }

    public int getQuantityFromMenu(final Menu menu) {
        return reservation.getQuantityFromMenu(menu);
    }
}

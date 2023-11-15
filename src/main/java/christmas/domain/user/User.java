package christmas.domain.user;

import christmas.domain.badge.Badge;
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
}

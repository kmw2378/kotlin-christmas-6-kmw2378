package christmas.fixture;

import christmas.domain.badge.Badge;
import christmas.domain.reservation.Reservation;
import christmas.domain.user.User;

import static christmas.domain.badge.Badge.NONE;
import static christmas.domain.badge.Badge.SANTA;
import static christmas.fixture.ReservationFixture.월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개;

public enum UserFixture {
    월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개_배지X(NONE, 월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개.생성()),
    월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개_산타_배지(SANTA, 월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개.생성());

    private final Badge badge;
    private final Reservation reservation;

    UserFixture(final Badge badge, final Reservation reservation) {
        this.badge = badge;
        this.reservation = reservation;
    }

    public User 생성() {
        return new User(badge, reservation);
    }
}

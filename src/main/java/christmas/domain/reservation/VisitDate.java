package christmas.domain.reservation;

import java.time.LocalDate;

public class VisitDate {
    private final LocalDate date;

    public VisitDate(final LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}

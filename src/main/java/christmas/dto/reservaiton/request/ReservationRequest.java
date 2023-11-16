package christmas.dto.reservaiton.request;

import java.time.LocalDate;

public record ReservationRequest(LocalDate visitDate, long totalOrderAmount) {
}

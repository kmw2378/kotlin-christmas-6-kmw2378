package christmas.mapper;

import christmas.domain.reservation.VisitDate;
import christmas.dto.reservaiton.response.VisitDateResponse;

public class VisitDateResponseMapper implements ResponseMapper<VisitDate, VisitDateResponse> {
    @Override
    public VisitDateResponse map(final VisitDate visitDate) {
        return new VisitDateResponse(visitDate.getDate().getDayOfMonth());
    }
}

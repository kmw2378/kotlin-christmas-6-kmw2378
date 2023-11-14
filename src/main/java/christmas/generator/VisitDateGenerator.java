package christmas.generator;

import christmas.converter.Converter;
import christmas.converter.IntegerToLocalDateConverter;
import christmas.domain.reservation.VisitDate;
import christmas.dto.reservaiton.request.VisitDateRequest;
import java.time.LocalDate;

public class VisitDateGenerator implements Generator<VisitDateRequest, VisitDate> {
    @Override
    public VisitDate generate(final VisitDateRequest visitDateRequest) {
        final Converter<Integer, LocalDate> converter = new IntegerToLocalDateConverter();
        final LocalDate visitDate = converter.convert(visitDateRequest.day());
        return new VisitDate(visitDate);
    }
}

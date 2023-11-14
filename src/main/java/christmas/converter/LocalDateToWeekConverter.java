package christmas.converter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateToWeekConverter implements Converter<LocalDate, DayOfWeek> {
    @Override
    public DayOfWeek convert(final LocalDate visitDate) {
        return LocalDateTime.of(visitDate, LocalTime.now())
                .getDayOfWeek();
    }
}

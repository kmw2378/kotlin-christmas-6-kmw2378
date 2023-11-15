package christmas.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class LocalDateToWeekConverterTest {
    @DisplayName("LocalDate 객체를 DayOfWeek 객체로 변환한다")
    @Test
    public void createDayOfWeekFromLocalDate() throws Exception {
        // given
        final LocalDate date = LocalDate.now();
        final Converter<LocalDate, DayOfWeek> converter = new LocalDateToWeekConverter();
        final DayOfWeek expect = date.getDayOfWeek();

        // when
        final DayOfWeek actual = converter.convert(date);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
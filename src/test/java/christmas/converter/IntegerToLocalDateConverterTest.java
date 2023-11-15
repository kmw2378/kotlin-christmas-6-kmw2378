package christmas.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static christmas.config.PromotionConfig.PROMOTION_MONTH;
import static christmas.config.PromotionConfig.PROMOTION_YEAR;
import static org.assertj.core.api.Assertions.assertThat;

class IntegerToLocalDateConverterTest {
    @DisplayName("정수값을 날짜의 일로 하는 LocalDate 객체로 변환한다")
    @Test
    public void createLocalDateFromInteger() throws Exception {
        // given
        final int day = 5;
        final Converter<Integer, LocalDate> converter = new IntegerToLocalDateConverter();
        final LocalDate expect = LocalDate.of(PROMOTION_YEAR, PROMOTION_MONTH, day);

        // when
        final LocalDate actual = converter.convert(day);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
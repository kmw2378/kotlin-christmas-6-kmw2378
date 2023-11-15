package christmas.converter;

import christmas.domain.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.domain.menu.Menu.CAESAR_SALAD;
import static org.assertj.core.api.Assertions.assertThat;

class StringToMenuConverterTest {
    @DisplayName("문자열을 Menu 객체로 변환한다")
    @Test
    public void createMenuFromString() throws Exception {
        // given
        final String name = CAESAR_SALAD.getName();
        final Converter<String, Menu> converter = new StringToMenuConverter();
        final Menu expect = CAESAR_SALAD;

        // when
        final Menu actual = converter.convert(name);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
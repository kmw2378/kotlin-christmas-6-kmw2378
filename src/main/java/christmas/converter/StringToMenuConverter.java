package christmas.converter;

import christmas.domain.menu.Menu;
import christmas.validator.MenuValidator;
import christmas.validator.Validator;
import java.util.Arrays;

public class StringToMenuConverter implements Converter<String, Menu> {
    @Override
    public Menu convert(final String name) {
        final Validator<String> validator = new MenuValidator();
        validator.validate(name);
        return Arrays.stream(Menu.values())
                .filter(m -> m.getName().equals(name))  // getter 없앨 수 있을 것 같음
                .findAny()
                .get();
    }
}

package christmas.validator;

import christmas.domain.menu.Menu;
import christmas.exception.InputException;
import java.util.Arrays;

import static christmas.exception.errorcode.ErrorCode.INVALID_ORDER;

public class MenuValidator implements Validator<String> {
    @Override
    public void validate(final String name) {
        validateIsNull(name, INVALID_ORDER);
        Arrays.stream(Menu.values())
                .filter(m -> m.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new InputException(INVALID_ORDER));
    }
}

package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.reservaiton.request.VisitDateRequest;
import christmas.exception.InputException;
import christmas.exception.errorcode.ErrorCode;

import static christmas.exception.errorcode.ErrorCode.INVALID_VISIT_DATE;

public class ConsoleInputView implements InputView {
    @Override
    public VisitDateRequest requestVisitDay() {
        System.out.println(VISIT_DATE_QUESTION_MESSAGE);
        final int visitDay = getVisitDay(Console.readLine());
        return new VisitDateRequest(visitDay);
    }

    private int getVisitDay(final String visitDay) {
        validateVisitDayNumeric(visitDay);
        return Integer.parseInt(visitDay);
    }

    private void validateVisitDayNumeric(final String input) {
        validateNumeric(input, INVALID_VISIT_DATE);
    }

    private void validateNumeric(final String input, final ErrorCode errorCode) {
        try {
            Integer.parseInt(input);
        } catch (final NumberFormatException e) {
            throw new InputException(errorCode);
        }
    }
}

package christmas.view;

import christmas.dto.reservaiton.request.VisitDateRequest;

public interface InputView {
    String VISIT_DATE_QUESTION_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    VisitDateRequest requestVisitDay();
}

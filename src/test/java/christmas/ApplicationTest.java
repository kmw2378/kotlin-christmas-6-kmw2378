package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 모든_실행_과정_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "티본스테이크 1개",
                    "바비큐립 1개",
                    "초코케이크 2개",
                    "제로콜라 1개",
                    "<할인 전 총주문 금액>\n142,000원",
                    "<증정 메뉴>\n샴페인 1개",
                    "<혜택 내역>",
                    "크리스마스 디데이 할인: -1,200원",
                    "평일 할인: -2,023원",
                    "특별 할인: -1,000원",
                    "<총혜택 금액>\n-29,223원",
                    "<할인 후 예상 결제 금액>\n137,777원",
                    "<12월 이벤트 배지>\n산타"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("메뉴명이 중복되면 예외가 발생한다")
    @Test
    void 메뉴명_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-1,제로콜라-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("총 주문 수량이 20개가 넘으면 예외가 발생한다")
    @Test
    void 총_주문수량_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "아이스크림-1,바비큐립-20");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("음료만 주문시 예외가 발생한다")
    @Test
    void 음료만_주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-1,레드와인-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("총 주문 금액이 10,000원 미만이면 적용되는 혜택이 없다")
    @Test
    void 총_주문_금액_혜택_적용_최소금액_만족X() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-1,아이스크림-1");
            assertThat(output()).contains("<증정 메뉴>\n없음", "<혜택 내역>\n없음", "<총혜택 금액>\n0원");
        });
    }

    @DisplayName("총 주문 금액이 120,000원 이상이면 상품을 증정받는다")
    @Test
    void 총_주문_금액_증점_상품_최소금액_만족() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-15,바비큐립-5");
            assertThat(output()).contains("<증정 메뉴>\n샴페인 1개");
        });
    }

    @DisplayName("증정 상품은 총 혜택 가격엔 포함되나 예상 결제금액엔 고려되지 않는다")
    @Test
    void 증정_상품_혜택_가격_영향O_예상_결제금액_관여X() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-15,바비큐립-5");
            assertThat(output()).contains("<할인 전 총주문 금액>\n1,095,000원", "<총혜택 금액>\n-27,200원", "<할인 후 예상 결제 금액>\n1,092,800원");
        });
    }

    @DisplayName("달력 방문일에 별 표시가 있으면 디데이 할인을 받는다")
    @Test
    void 방문일_디데이_할인() {
        assertSimpleTest(() -> {
            runException("25", "티본스테이크-15,바비큐립-5");
            assertThat(output()).contains("<혜택 내역>\n크리스마스 디데이 할인: -3,400원");
        });
    }

    @DisplayName("방문일이 일요일 ~ 목요일이면 평일 할인을 받는다")
    @Test
    void 방문일_평일_할인() {
        assertSimpleTest(() -> {
            runException("26", "아이스크림-1,바비큐립-5");
            assertThat(output()).contains("<혜택 내역>\n평일 할인: -2,023");
        });
    }

    @DisplayName("방문일이 금요일, 토요일이면 주말 할인을 받는다")
    @Test
    void 방문일_주말_할인() {
        assertSimpleTest(() -> {
            runException("22", "아이스크림-1,바비큐립-1");
            assertThat(output()).contains("주말 할인: -2,023원");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

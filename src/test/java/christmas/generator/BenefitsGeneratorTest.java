package christmas.generator;

import christmas.domain.benefit.Benefits;
import christmas.dto.reservaiton.request.ReservationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static christmas.config.PromotionConfig.PROMOTION_MONTH;
import static christmas.fixture.BenefitsFixture.증정X_평일_할인;
import static christmas.fixture.BenefitsFixture.혜택X;
import static org.assertj.core.api.Assertions.assertThat;

class BenefitsGeneratorTest {
    @DisplayName("평일 할인만 적용되는 혜택을 반환한다")
    @Test
    public void createBenefits() throws Exception {

        // given
        final Generator<ReservationRequest, Benefits> generator = new BenefitsGenerator();
        final LocalDate visitDate = LocalDate.of(PROMOTION_MONTH, PROMOTION_MONTH, 26);
        final ReservationRequest reservationRequest = new ReservationRequest(visitDate, 12_000L);
        final Benefits expect = 증정X_평일_할인.생성();

        // when
        final Benefits actual = generator.generate(reservationRequest);

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expect);
    }

    @DisplayName("총 주문 금액이 10,000원 미만이므로 혜택이 없다")
    @Test
    public void createBenefitsWhenTotalAmountLessThan10000() throws Exception {

        // given
        final Generator<ReservationRequest, Benefits> generator = new BenefitsGenerator();
        final LocalDate visitDate = LocalDate.of(PROMOTION_MONTH, PROMOTION_MONTH, 26);
        final ReservationRequest reservationRequest = new ReservationRequest(visitDate, 8_000L);
        final Benefits expect = 혜택X.생성();

        // when
        final Benefits actual = generator.generate(reservationRequest);

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expect);
    }
}
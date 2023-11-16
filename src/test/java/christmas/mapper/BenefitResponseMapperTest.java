package christmas.mapper;

import christmas.domain.reservation.Reservation;
import christmas.dto.benefit.response.AmountResponse;
import christmas.dto.benefit.response.BenefitRecordResponse;
import christmas.dto.benefit.response.BenefitResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

import static christmas.domain.menu.Menu.ICE_CREAM;
import static christmas.domain.menu.Menu.ZERO_COKE;
import static christmas.fixture.ReservationFixture.월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개;
import static org.assertj.core.api.Assertions.assertThat;

class BenefitResponseMapperTest {
    @DisplayName("예약 내역을 통해 출력에 필요한 혜택 내역을 가져온다")
    @Test
    public void mapReservationToBenefitResponse() throws Exception {
        // given
        final ResponseMapper<Reservation, BenefitResponse> mapper = new BenefitResponseMapper();
        final Reservation reservation = 월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개.생성();
        final BenefitResponse expect = getBenefitResponse();

        // when
        final BenefitResponse actual = mapper.map(reservation);

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expect);
    }

    private BenefitResponse getBenefitResponse() {
        final long totalBenefitAmount = 2023;
        final long totalOrderAmount = ICE_CREAM.getAmount() + ZERO_COKE.getAmount();
        return new BenefitResponse(Collections.emptyList(),
                List.of(new BenefitRecordResponse("평일 할인", totalBenefitAmount)),
                new AmountResponse(totalBenefitAmount,totalOrderAmount - totalBenefitAmount));
    }
}
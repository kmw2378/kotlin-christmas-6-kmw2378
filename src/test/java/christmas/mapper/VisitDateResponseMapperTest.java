package christmas.mapper;

import christmas.domain.reservation.VisitDate;
import christmas.dto.reservaiton.response.VisitDateResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.fixture.VisitDateFixture.월_26일;
import static org.assertj.core.api.Assertions.assertThat;

class VisitDateResponseMapperTest {
    @DisplayName("방문 날짜 통해 출력에 필요한 방문일을 가져온다")
    @Test
    public void mapVisitDateToVisitDateResponse() throws Exception {
        // given
        final ResponseMapper<VisitDate, VisitDateResponse> mapper = new VisitDateResponseMapper();
        final VisitDate visitDate = 월_26일.생성();
        final VisitDateResponse expect = new VisitDateResponse(26);

        // when
        final VisitDateResponse actual = mapper.map(visitDate);

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expect);
    }
}
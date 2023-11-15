package christmas.mapper;

import christmas.domain.user.User;
import christmas.dto.badge.response.BadgeResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.fixture.UserFixture.월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개_배지X;
import static org.assertj.core.api.Assertions.assertThat;

class BadgeResponseMapperTest {
    @DisplayName("User 객체로 부터 배지 이름을 받아온다")
    @Test
    public void mapUserToBadgeResponse() throws Exception {
        // given
        final ResponseMapper<User, BadgeResponse> mapper = new BadgeResponseMapper();
        final User user = 월_26일_증정X_평일_할인_아이스크림_1개_콜라_1개_배지X.생성();
        final BadgeResponse expect = new BadgeResponse("없음");

        // when
        final BadgeResponse actual = mapper.map(user);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
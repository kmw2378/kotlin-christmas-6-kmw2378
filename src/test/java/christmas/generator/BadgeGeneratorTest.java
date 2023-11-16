package christmas.generator;

import christmas.domain.badge.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.domain.badge.Badge.NONE;
import static christmas.domain.badge.Badge.SANTA;
import static christmas.domain.badge.Badge.STAR;
import static christmas.domain.badge.Badge.TREE;
import static org.assertj.core.api.Assertions.assertThat;

class BadgeGeneratorTest {
    @DisplayName("총 혜택 금액이 0원이므로 배지를 생성하지 않는다")
    @Test
    public void createNoneBadge() throws Exception {

        // given
        final Generator<Long, Badge> generator = new BadgeGenerator();
        final long totalBenefitAmount = 0L;
        final Badge expect = NONE;

        // when
        final Badge actual = generator.generate(totalBenefitAmount);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("총 혜택 금액이 5,000원이므로 스타 배지를 생성한다")
    @Test
    public void createStarBadge() throws Exception {

        // given
        final Generator<Long, Badge> generator = new BadgeGenerator();
        final long totalBenefitAmount = 5000L;
        final Badge expect = STAR;

        // when
        final Badge actual = generator.generate(totalBenefitAmount);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("총 혜택 금액이 12,000원이므로 트리 배지를 생성한다.")
    @Test
    public void createTreeBadge() throws Exception {

        // given
        final Generator<Long, Badge> generator = new BadgeGenerator();
        final long totalBenefitAmount = 12_000L;
        final Badge expect = TREE;

        // when
        final Badge actual = generator.generate(totalBenefitAmount);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("총 혜택 금액이 25,000원이므로 산타 배지를 생성한다")
    @Test
    public void createSantaBadge() throws Exception {

        // given
        final Generator<Long, Badge> generator = new BadgeGenerator();
        final long totalBenefitAmount = 25_000L;
        final Badge expect = SANTA;

        // when
        final Badge actual = generator.generate(totalBenefitAmount);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
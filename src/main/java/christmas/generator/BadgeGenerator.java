package christmas.generator;

import christmas.domain.badge.Badge;
import java.util.Arrays;
import java.util.List;

public class BadgeGenerator implements Generator<Long, Badge> {
    @Override
    public Badge generate(final Long totalBenefitAmount) {
        final List<Badge> badges = createBadges();
        for (Badge badge : badges) {
            if (badge.getMinPrice() <= totalBenefitAmount) {
                return badge;
            }
        }

        return badges.get(badges.size() - 1);
    }

    private List<Badge> createBadges() {
        return Arrays.stream(Badge.values())
                .sorted((a, b) -> Long.compare(b.getMinPrice(), a.getMinPrice()))
                .toList();
    }
}

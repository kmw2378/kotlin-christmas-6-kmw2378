package christmas.generator;

import christmas.domain.badge.Badge;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BadgeGenerator implements Generator<Long, Badge> {
    @Override
    public Badge generate(final Long totalBenefitAmount) {
        final List<Badge> badges = createBadges();
        for (int i = 1; i < badges.size() - 1; i++) {
            if (badges.get(i).getMinPrice() > totalBenefitAmount) {
                return badges.get(i - 1);
            }
        }

        return badges.get(badges.size() - 1);
    }

    private List<Badge> createBadges() {
        return Arrays.stream(Badge.values())
                .sorted(Comparator.comparingLong(Badge::getMinPrice))
                .toList();
    }
}

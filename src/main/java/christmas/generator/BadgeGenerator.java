package christmas.generator;

import christmas.domain.badge.Badge;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class BadgeGenerator implements Generator<Long, Badge> {
    @Override
    public Badge generate(final Long totalBenefitAmount) {
        final List<Badge> badges = createBadges();
        final ListIterator<Badge> badgeIterator = badges.listIterator();
        while (badgeIterator.hasNext()) {
            final Badge badge = badgeIterator.next();
            if (badge.getMinPrice() > totalBenefitAmount) {
                return badgeIterator.previous();
            }
        }

        return badgeIterator.previous();
    }

    private List<Badge> createBadges() {
        return Arrays.stream(Badge.values())
                .sorted(Comparator.comparingLong(Badge::getMinPrice))
                .toList();
    }
}

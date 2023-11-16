package christmas.mapper;

import christmas.domain.badge.Badge;
import christmas.domain.user.User;
import christmas.dto.badge.response.BadgeResponse;
import java.util.Arrays;

import static christmas.domain.badge.Badge.NONE;

public class BadgeResponseMapper implements ResponseMapper<User, BadgeResponse> {
    @Override
    public BadgeResponse map(final User user) {
        final Badge badge = getBadge(user);
        return new BadgeResponse(badge.getName());
    }

    private Badge getBadge(final User user) {
        return Arrays.stream(Badge.values())
                .filter(user::equalsBadge)
                .findFirst()
                .orElse(NONE);
    }
}

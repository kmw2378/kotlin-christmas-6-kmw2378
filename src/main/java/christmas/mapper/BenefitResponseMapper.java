package christmas.mapper;

import christmas.domain.benefit.BenefitType;
import christmas.domain.user.User;
import christmas.dto.benefit.response.AmountResponse;
import christmas.dto.benefit.response.BenefitRecordResponse;
import christmas.dto.benefit.response.BenefitResponse;
import christmas.dto.benefit.response.GiftResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static christmas.domain.benefit.BenefitType.GIFT;

public class BenefitResponseMapper implements ResponseMapper<User, BenefitResponse> {
    @Override
    public BenefitResponse map(final User user) {
        final List<GiftResponse> giftResponses = getGiftResponses(user);
        final List<BenefitRecordResponse> benefitRecordResponses = getBenefitRecordResponses(user);
        final AmountResponse amountResponse = getAmountResponse(user, benefitRecordResponses);
        return new BenefitResponse(giftResponses, benefitRecordResponses, amountResponse);
    }

    private List<GiftResponse> getGiftResponses(final User user) {
        if (!user.existBenefitType(GIFT)) {
            return Collections.emptyList();
        }

        return List.of(new GiftResponse("샴페인", 1));
    }

    private List<BenefitRecordResponse> getBenefitRecordResponses(final User user) {
        return Arrays.stream(BenefitType.values())
                .filter(b -> user.getTotalBenefitAmountFromType(b) > 0)
                .map(b -> new BenefitRecordResponse(b.getName(), user.getTotalBenefitAmountFromType(b)))
                .toList();
    }

    private AmountResponse getAmountResponse(final User user,
                                             final List<BenefitRecordResponse> benefitRecordResponses) {
        final long totalBenefitAmount = getTotalBenefitAmount(benefitRecordResponses);
        final long totalPaymentAmount = getTotalPaymentAmount(user);
        return new AmountResponse(totalBenefitAmount, totalPaymentAmount);
    }

    private long getTotalBenefitAmount(final List<BenefitRecordResponse> benefitRecordResponses) {
        return benefitRecordResponses.stream()
                .map(BenefitRecordResponse::totalAmount)
                .mapToLong(l -> l)
                .sum();
    }

    private long getTotalPaymentAmount(final User user) {
        return Arrays.stream(BenefitType.values())
                .filter(BenefitType::isReflectedBenefitAmount)
                .map(user::getTotalBenefitAmountFromType)
                .mapToLong(l -> l)
                .sum();
    }
}

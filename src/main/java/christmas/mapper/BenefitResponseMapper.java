package christmas.mapper;

import christmas.domain.benefit.gift.GiftType;
import christmas.domain.benefit.sale.SaleType;
import christmas.domain.reservation.Reservation;
import christmas.dto.benefit.response.AmountResponse;
import christmas.dto.benefit.response.BenefitRecordResponse;
import christmas.dto.benefit.response.BenefitResponse;
import christmas.dto.benefit.response.GiftResponse;
import java.util.Arrays;
import java.util.List;

public class BenefitResponseMapper implements ResponseMapper<Reservation, BenefitResponse> {
    @Override
    public BenefitResponse map(final Reservation reservation) {
        final List<GiftResponse> giftResponses = getGiftResponses(reservation);
        final List<BenefitRecordResponse> benefitRecordResponses = getBenefitRecordResponses(reservation);
        final AmountResponse amountResponse = getAmountResponse(reservation);
        return new BenefitResponse(giftResponses, benefitRecordResponses, amountResponse);
    }

    private List<GiftResponse> getGiftResponses(final Reservation reservation) {
        return Arrays.stream(GiftType.values())
                .filter(reservation::existGiftType)
                .map(g -> new GiftResponse(reservation.getGiftNameFromType(g), reservation.getGiftQuantityFromType(g)))
                .toList();
    }

    private List<BenefitRecordResponse> getBenefitRecordResponses(final Reservation reservation) {
        return Arrays.stream(SaleType.values())
                .filter(s -> reservation.getTotalBenefitAmountFromType(s) > 0)
                .map(s -> new BenefitRecordResponse(s.getName(), reservation.getTotalBenefitAmountFromType(s)))
                .toList();
    }

    private AmountResponse getAmountResponse(final Reservation reservation) {
        final long totalBenefitAmount = reservation.getTotalBenefitAmount();
        final long totalPaymentAmount = reservation.getTotalOrderAmount() - reservation.getTotalBenefitAmount() + reservation.getGiftAmount();
        return new AmountResponse(totalBenefitAmount, totalPaymentAmount);
    }
}

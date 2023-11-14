package christmas.dto.benefit.response;

import java.util.List;

public record BenefitResponse(List<GiftResponse> gifts, List<BenefitRecordResponse> benefits, AmountResponse amountResponse) {
}

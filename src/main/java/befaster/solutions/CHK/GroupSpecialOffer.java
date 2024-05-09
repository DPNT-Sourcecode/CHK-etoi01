package befaster.solutions.CHK;

import java.util.List;
import java.util.Map;

public class GroupSpecialOffer implements ISpecialOffer {

    List<CountedSku> requiredSkus;
    Integer discountValue;

    public GroupSpecialOffer(List<CountedSku> requiredSkus, Integer discountValue) {
        this.requiredSkus = requiredSkus;
        this.discountValue = discountValue;
    }

    @Override
    public boolean canApplyOffer(Map<String, Integer> items) {
        return requiredSkus
                .stream()
                .allMatch(requiredItem -> items.getOrDefault(requiredItem.getSku(), 0) >= requiredItem.getQuantity());
    }

    private void adjustItemsForOffer(Map<String, Integer> items) {
        for (CountedSku requiredItem : requiredSkus) {
            items.compute(requiredItem.getSku(), (s, integer) -> integer - requiredItem.getQuantity());
        }
    }

    @Override
    public Integer applyDiscountAndGet(Map<String, Integer> items) {
        if (canApplyOffer(items)) {
            adjustItemsForOffer(items);
            return discountValue;
        }
        throw new IllegalArgumentException("Could not apply offer to specified items");
    }
}


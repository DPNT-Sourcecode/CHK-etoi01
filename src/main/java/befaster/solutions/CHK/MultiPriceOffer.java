package befaster.solutions.CHK;

import java.util.List;
import java.util.Map;

public class MultiPriceOffer implements ISpecialOffer {

    List<CountedSku> requiredSkus;
    Integer resultingDiscount;

    public MultiPriceOffer(List<CountedSku> requiredSkus, Integer resultingDiscount) {
        this.requiredSkus = requiredSkus;
        this.resultingDiscount = resultingDiscount;
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
    public Integer adjustItemsAndGetResultingDiscount(Map<String, Integer> items) {
        if (canApplyOffer(items)) {
            adjustItemsForOffer(items);
            return resultingDiscount;
        }
        throw new IllegalArgumentException("Could not apply offer to specified items");
    }
}


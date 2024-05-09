package befaster.solutions.CHK;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupDiscountOffer implements ISpecialOffer {

    List<Item> requiredSkus;

    Integer bundleValue;
    Integer bundleSize;

    public GroupDiscountOffer(List<Item> requiredSkus, Integer bundleValue, Integer bundleSize) {
        this.requiredSkus = requiredSkus.stream().sorted(Comparator.comparing(Item::price)).collect(Collectors.toList());
        this.bundleValue = bundleValue;
        this.bundleSize = bundleSize;
    }

    @Override
    public boolean canApplyOffer(Map<String, Integer> items) {
        return requiredSkus
                .stream()
                .mapToInt(sku -> items.getOrDefault(sku.sku(), 0))
                .sum() >= bundleSize;
    }

    @Override
    public Integer adjustItemsAndGetResultingDiscount(Map<String, Integer> items) {
        if (canApplyOffer(items)) {
            int bundleCounter = bundleSize;
            int priceOfGroupedItems = 0;

            skuLoop:
            for (Item sku : requiredSkus) {
                while (bundleCounter > 0) {
                    Integer itemCount = items.get(sku.sku());
                    if (itemCount == 0) {
                        continue skuLoop;
                    }
                    items.put(sku.sku(), itemCount - 1);
                    priceOfGroupedItems += sku.price();
                    bundleCounter--;
                }
            }
            return priceOfGroupedItems - bundleValue;
        }
        throw new IllegalArgumentException("Could not apply offer to specified items");
    }
}

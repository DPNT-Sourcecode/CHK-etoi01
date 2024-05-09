package befaster.solutions.CHK;

import java.util.List;
import java.util.Map;

public class SpecialOfferCalculator {

    private static final List<SpecialOffer> specialOffers = List.of(
            new SpecialOffer(
                    List.of(
                            new CountedSku("A", 5)
                    ),
                    50
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("E", 2),
                            new CountedSku("B", 1)
                    ),
                    30
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("A", 3)
                    ),
                    20
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("B", 2)
                    ),
                    15
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("F", 3)
                    ),
                    10
            )
    );

    public static Integer totalDiscounts(Cart cart) {
        Map<String, Integer> remainingItems = cart.getCountedItems();
        Integer totalDiscount = 0;
        for (SpecialOffer specialOffer : specialOffers) {
            List<CountedSku> requiredItems = specialOffer.requiredItems();
            boolean hasEnoughItems = hasEnoughItems(requiredItems, remainingItems);
            while (hasEnoughItems) {
                for (CountedSku requiredItem : requiredItems) {
                    remainingItems.compute(requiredItem.getSku(), (s, integer) -> integer - requiredItem.getQuantity());
                }
                totalDiscount += specialOffer.priceDiscount();
                hasEnoughItems = hasEnoughItems(requiredItems, remainingItems);
            }
        }
        return totalDiscount;
    }

    private static boolean hasEnoughItems(
            List<CountedSku> requiredItems,
            Map<String, Integer> remainingItems
    ) {
        return requiredItems
                .stream()
                .allMatch(requiredItem -> remainingItems.getOrDefault(requiredItem.getSku(), 0) >= requiredItem.getQuantity());
    }
}

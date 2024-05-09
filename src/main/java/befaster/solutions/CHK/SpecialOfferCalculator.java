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
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("H", 10)
                    ),
                    20
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("H", 5)
                    ),
                    5
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("K", 2)
                    ),
                    10
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("N", 3),
                            new CountedSku("M", 1)
                    ),
                    15
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("P", 5)
                    ),
                    50
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("R", 3),
                            new CountedSku("Q", 1)
                    ),
                    30
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("Q", 3)
                    ),
                    10
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("U", 4)
                    ),
                    40
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("V", 3)
                    ),
                    20
            ),
            new SpecialOffer(
                    List.of(
                            new CountedSku("V", 2)
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


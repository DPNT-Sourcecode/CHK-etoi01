package befaster.solutions.CHK;

import java.util.List;
import java.util.Map;

public class SpecialOfferCalculator {

    private static final List<ISpecialOffer> specialOffers = List.of(
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("A", 5)
                    ),
                    50
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("E", 2),
                            new CountedSku("B", 1)
                    ),
                    30
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("A", 3)
                    ),
                    20
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("B", 2)
                    ),
                    15
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("F", 3)
                    ),
                    10
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("H", 10)
                    ),
                    20
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("H", 5)
                    ),
                    5
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("K", 2)
                    ),
                    10
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("N", 3),
                            new CountedSku("M", 1)
                    ),
                    15
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("P", 5)
                    ),
                    50
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("R", 3),
                            new CountedSku("Q", 1)
                    ),
                    30
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("Q", 3)
                    ),
                    10
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("U", 4)
                    ),
                    40
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("V", 3)
                    ),
                    20
            ),
            new GroupSpecialOffer(
                    List.of(
                            new CountedSku("V", 2)
                    ),
                    10
            )
    );

    public static Integer totalDiscounts(Cart cart) {
        Map<String, Integer> remainingItems = cart.getCountedItems();
        Integer totalDiscount = 0;
        for (ISpecialOffer specialOffer : specialOffers) {
            boolean hasEnoughItems = specialOffer.canApplyOffer(remainingItems);
            while (hasEnoughItems) {
                totalDiscount += specialOffer.applyDiscountAndGet(remainingItems);
                hasEnoughItems = specialOffer.canApplyOffer(remainingItems);
            }
        }
        return totalDiscount;
    }
}


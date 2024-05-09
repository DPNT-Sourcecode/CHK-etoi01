package befaster.solutions.CHK;

import java.util.List;
import java.util.Map;

public class SpecialOfferCalculator {

    private static final ItemList itemList = new ItemList();

    private static final List<ISpecialOffer> specialOffers = List.of(
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("A", 5)
                    ),
                    50
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("E", 2),
                            new CountedSku("B", 1)
                    ),
                    30
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("A", 3)
                    ),
                    20
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("B", 2)
                    ),
                    15
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("F", 3)
                    ),
                    10
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("H", 10)
                    ),
                    20
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("H", 5)
                    ),
                    5
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("K", 2)
                    ),
                    10
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("N", 3),
                            new CountedSku("M", 1)
                    ),
                    15
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("P", 5)
                    ),
                    50
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("R", 3),
                            new CountedSku("Q", 1)
                    ),
                    30
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("Q", 3)
                    ),
                    10
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("U", 4)
                    ),
                    40
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("V", 3)
                    ),
                    20
            ),
            new MultiPriceOffer(
                    List.of(
                            new CountedSku("V", 2)
                    ),
                    10
            ),
            new GroupDiscountOffer(
                    List.of(
                            itemList.findItem("Z").get(),
                            itemList.findItem("Y").get(),
                            itemList.findItem("S").get(),
                            itemList.findItem("T").get(),
                            itemList.findItem("X").get()
                    ),
                    45,
                    3
            )
    );

    public static Integer totalDiscounts(Cart cart) {
        Map<String, Integer> remainingItems = cart.getCountedItems();
        Integer totalDiscount = 0;
        for (ISpecialOffer specialOffer : specialOffers) {
            boolean hasEnoughItems = specialOffer.canApplyOffer(remainingItems);
            while (hasEnoughItems) {
                totalDiscount += specialOffer.adjustItemsAndGetResultingDiscount(remainingItems);
                hasEnoughItems = specialOffer.canApplyOffer(remainingItems);
            }
        }
        return totalDiscount;
    }
}

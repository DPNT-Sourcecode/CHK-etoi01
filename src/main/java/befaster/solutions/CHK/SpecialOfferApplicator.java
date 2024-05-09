package befaster.solutions.CHK;

import java.util.LinkedList;
import java.util.List;

public class SpecialOfferApplicator {

    private ItemList itemList = new ItemList();

    private List<CountedItem> processedItems = new LinkedList<>();

    private List<CountedItem> initialItems = new LinkedList<>();

    private List<SpecialOffer> specialOffers = List.of(
            new SpecialOffer(
                    List.of(
                            new CountedItem(itemList.findItem("A").get(), 5)
                    ),
                    50
            ),
            new SpecialOffer(
                    List.of(
                            new CountedItem(itemList.findItem("E").get(), 2),
                            new CountedItem(itemList.findItem("B").get(), 1)
                    ),
                    30
            ),
            new SpecialOffer(
                    List.of(
                            new CountedItem(itemList.findItem("A").get(), 3)
                    ),
                    20
            ),
            new SpecialOffer(
                    List.of(
                            new CountedItem(itemList.findItem("B").get(), 2)
                    ),
                    15
            )
    );

    public SpecialOfferApplicator(
            Cart cart
    ) {
        this.initialItems = initialItems;

    }
}




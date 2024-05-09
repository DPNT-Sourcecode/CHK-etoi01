package befaster.solutions.CHK;

import java.util.LinkedList;
import java.util.List;

public class SpecialOfferApplicator {

    private List<CartItem> processedItems = new LinkedList<>();

    private List<CartItem> initialItems = new LinkedList<>();

    private List<SpecialOffer> specialOffers = List.of(

    );

    public SpecialOfferApplicator(
            List<CartItem> initialItems
    ) {
        this.initialItems = initialItems;
    }
}


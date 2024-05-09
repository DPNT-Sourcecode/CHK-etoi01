package befaster.solutions.CHK;

import java.util.Collections;
import java.util.List;

record Item(
        String sku,
        Integer price,
        List<SpecialOffer> specialOffers
) {

    public Item(
            String sku,
            Integer price
    ) {
        this(sku, price, Collections.emptyList());
    }

    public boolean hasSpecialOffer() {
        return !specialOffers.isEmpty();
    }

}


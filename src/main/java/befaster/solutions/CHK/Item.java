package befaster.solutions.CHK;

import java.util.Collections;
import java.util.List;

public record Item(
        String sku,
        Integer price
) {

    public Item(Item item) {
        this(item.sku, item.price);
    }

}




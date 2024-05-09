package befaster.solutions.CHK;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ItemList {
    List<Item> itemList = List.of(
            new Item("A", 50, new SpecialOffer(3, 130)),
            new Item("B", 30, new SpecialOffer(2, 45)),
            new Item("C", 20),
            new Item("D", 15)
    );

    public Optional<Item> findItem(String sku) {
        return itemList.stream()
                .filter(item -> Objects.equals(item.sku(), sku))
                .findFirst();
    }
}

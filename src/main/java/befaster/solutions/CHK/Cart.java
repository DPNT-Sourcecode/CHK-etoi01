package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cart {
    private ItemList itemList = new ItemList();
    private Map<String, Integer> countedItems = new HashMap<>();

    public Cart(String skus) {
        if (skus.isBlank()) {
            throw new IllegalArgumentException("Cannot have an empty string");
        }
        String[] individualSkus = skus.split("");
        for (String skuString : individualSkus) {
            Optional<Item> itemOpt = itemList.findItem(skuString);
            if (itemOpt.isEmpty()) {
                throw new IllegalArgumentException("Could not find required item");
            }
            countedItems.compute(skuString, (s, integer) -> integer == null ? 1 : integer + 1);
        }
    }

    public Map<String, Integer> getCountedItems() {
        return new HashMap<>(countedItems);
    }
}

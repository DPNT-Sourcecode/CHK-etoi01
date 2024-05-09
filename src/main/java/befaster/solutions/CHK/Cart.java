package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cart {
    private ItemList itemList = new ItemList();
    private Map<String, Integer> countedItems = new HashMap<>();

    public Cart(String skus) {
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


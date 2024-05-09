package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cart {
    private ItemList itemList;
    private Map<String, CountedItem> countedItems = new HashMap<>();

    public Cart(String skus) {
        String[] individualSkus = skus.split("");
        for (String skuString : individualSkus) {
            Optional<Item> itemOpt = itemList.findItem(skuString);
            if (itemOpt.isEmpty()) {
                continue;
            }
            countedItems.putIfAbsent(skuString, new CountedItem(itemOpt.get(), 0));
            CountedItem countedItem = countedItems.get(skuString);
            countedItem.incrementQuantity(); //mem reference should update this in the map
        }
    }

    //copy constructor to keep state of counted items in cart consistent
    public List<CountedItem> cartItems() {
        return countedItems.values()
                .stream()
                .map(CountedItem::new)
                .collect(Collectors.toList());
    }
}


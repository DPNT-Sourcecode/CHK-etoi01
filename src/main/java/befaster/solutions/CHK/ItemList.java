package befaster.solutions.CHK;

import java.util.*;
import java.util.stream.Collectors;

public class ItemList {

    Map<String, Item> items = new HashMap<>();

    public ItemList() {
        List<Item> itemList = List.of(
                new Item("A",50),
                new Item("B",30),
                new Item("C",20),
                new Item("D",15),
                new Item("E",40),
                new Item("F",10)
        );
        for (Item item : itemList) {
            items.put(item.sku(), item);
        }
    }

    public Optional<Item> findItem(String sku) {
        return Optional.ofNullable(items.get(sku));
    }

    public Map<String, Integer> priceList() {
        return items.entrySet()
                .stream()
                .map(entry -> Map.entry(entry.getKey(), entry.getValue().price()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}


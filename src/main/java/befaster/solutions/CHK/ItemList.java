package befaster.solutions.CHK;

import java.util.*;

public class ItemList {

    Map<String, Item> items = new HashMap<>();

    public ItemList() {
        items.put("A", new Item("A",50));
        items.put("B", new Item("B",30));
        items.put("C", new Item("C",20));
        items.put("D", new Item("D",15));
        items.put("E", new Item("E",40));
    }

    public Optional<Item> findItem(String sku) {
        return Optional.ofNullable(items.get(sku));
    }
}



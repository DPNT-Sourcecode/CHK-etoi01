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
                new Item("F",10),
                new Item("G",20),
                new Item("H",10),
                new Item("I",35),
                new Item("J",60),
                new Item("K",80),
                new Item("L",90),
                new Item("M",15),
                new Item("N",40),
                new Item("O",10),
                new Item("P",50),
                new Item("Q",30),
                new Item("R",50),
                new Item("S",30),
                new Item("T",20),
                new Item("U",40),
                new Item("V",50),
                new Item("W",20),
                new Item("X",90),
                new Item("Y",10),
                new Item("Z",50)
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

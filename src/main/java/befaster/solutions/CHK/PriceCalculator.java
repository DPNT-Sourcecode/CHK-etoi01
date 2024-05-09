package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class PriceCalculator {
    Map<String, Integer> priceList = new HashMap<>();

    public PriceCalculator() {
        priceList.put("A", 50);
        priceList.put("B", 30);
        priceList.put("C", 20);
        priceList.put("D", 15);
        priceList.put("E", 40);
    }

    public Integer getTotalGrossPrice(Cart cart) {
        Map<String, Integer> countedCartItems = cart.getCountedItems();
        return countedCartItems.entrySet()
                .stream()
                .mapToInt(entry -> priceList.get(entry.getKey()) * entry.getValue())
                .sum();

    }
}

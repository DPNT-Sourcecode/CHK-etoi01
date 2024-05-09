package befaster.solutions.CHK;

import java.util.Map;

public class GrossPriceCalculator {

    Map<String, Integer> priceList = new ItemList().priceList();


    public Integer getTotalGrossPrice(Cart cart) {
        Map<String, Integer> countedCartItems = cart.getCountedItems();
        return countedCartItems.entrySet()
                .stream()
                .mapToInt(entry -> priceList.get(entry.getKey()) * entry.getValue())
                .sum();

    }
}

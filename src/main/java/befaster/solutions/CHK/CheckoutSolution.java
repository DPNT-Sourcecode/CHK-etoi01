package befaster.solutions.CHK;

import java.util.*;

public class CheckoutSolution {

    ItemList itemList = new ItemList();

    /*
    notes/questions: are skus multiples of the same letter or with numerals, i.e. 3A or AAA?
     */
    public Integer checkout(String skus) {
        if (skus.isEmpty() || skus.isBlank()) {
            return 0;
        }
        String[] individualSkus = skus.split("");
        Map<Item, Integer> cartItems = new HashMap<>();
        for (String sku : individualSkus) {
            Optional<Item> itemOpt = itemList.findItem(sku);
            if (itemOpt.isEmpty()) {
                return -1;
            }
            cartItems.compute(
                    itemOpt.get(),
                    (item, integer) -> integer == null ? 1 : integer + 1
            );
        }

        Integer totalSum = 0;
        for (var skuEntry : cartItems.entrySet()) {
            /*
            for a regular item, the price is item price * quantity
            for an item with a special offer, we calculate the price by finding the amount of special offers,
                and the price of the remaining items
             */
            Item item = skuEntry.getKey();
            Integer itemQuantity = skuEntry.getValue();
            int amountOfSpecialOffers = 0;
            if (item.hasSpecialOffer()) {
                amountOfSpecialOffers = itemQuantity / item.specialOffer().quantity(); //int downcasting works in our favour here
                int remainingItems = itemQuantity % item.specialOffer().quantity();
                totalSum += (item.specialOffer().price() * amountOfSpecialOffers) + (item.price() * remainingItems);
            } else {
                totalSum += itemQuantity * item.price();
            }
        }
        return totalSum;
    }

}

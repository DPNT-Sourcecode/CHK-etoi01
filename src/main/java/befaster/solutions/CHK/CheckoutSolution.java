package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.*;

public class CheckoutSolution {

    //while we could use a map, at this size, it is faster to use a list (for now)
    List<Item> itemList = List.of(
            new Item("A", 50, new SpecialOffer(3, 130)),
            new Item("B", 30, new SpecialOffer(2, 45)),
            new Item("C", 20),
            new Item("D", 15)
    );

    /*
    notes/questions: are skus multiples of the same letter or with numerals, i.e. 3A or AAA?
     */
    public Integer checkout(String skus) {
        String[] individualSkus = skus.split("");
        Map<Item, Integer> cartItems = new HashMap<>();
        for (String sku : individualSkus) {
            Optional<Item> itemOpt = itemList.stream()
                    .filter(item -> Objects.equals(item.sku(), sku))
                    .findFirst();
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
            for an item with a special offer, the price is
                quantity divided by special offer amount (e.g. for 7 A, 7 / 3 = 2.333, int round down to 2
                special offer value = 2 * special offer value
                remainder items 7 % 3 = 1, 1 * price
                total 2*special offer + 1*price
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

    record Item(
            String sku,
            Integer price,
            SpecialOffer specialOffer
    ) {

        public Item(
                String sku,
                Integer price
        ) {
            this(sku, price, null);
        }

        public boolean hasSpecialOffer() {
            return specialOffer != null;
        }

    }

    record SpecialOffer(
            Integer quantity,
            Integer price
    ) {

    }
}

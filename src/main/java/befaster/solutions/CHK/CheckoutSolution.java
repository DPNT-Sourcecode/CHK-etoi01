package befaster.solutions.CHK;

import java.util.*;

public class CheckoutSolution {

    ItemList itemList = new ItemList();

    PriceCalculator priceCalculator = new PriceCalculator();

    /*
    notes/questions: are skus multiples of the same letter or with numerals, i.e. 3A or AAA?
     */
    public Integer checkout(String skus) {
        try {
            Cart cart = new Cart(skus);
            Integer totalGrossPrice = priceCalculator.getTotalGrossPrice(cart);
            Integer discountedPrice = SpecialOfferCalculator.totalDiscounts(cart);
            return totalGrossPrice - discountedPrice;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

}

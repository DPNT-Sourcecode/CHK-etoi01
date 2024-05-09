package befaster.solutions.CHK;

public class CheckoutSolution {

    ItemList itemList = new ItemList();

    GrossPriceCalculator priceCalculator = new GrossPriceCalculator();

    /*
    notes/questions: are skus multiples of the same letter or with numerals, i.e. 3A or AAA?
     */
    public Integer checkout(String skus) {
        if (skus.isBlank()) {
            return 0;
        }
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


package befaster.solutions.CHK;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {

    private final CheckoutSolution checkoutSolution = new CheckoutSolution();

    @Nested
    class ValidSolutions {

        @Test
        void valid_skus() {
            int actualPrice = checkoutSolution.checkout("ABCD");
            assertEquals(115, actualPrice);
        }

        @Test
        void valid_skus_with_offer() {
            int actualPrice = checkoutSolution.checkout("AAA");
            assertEquals(130, actualPrice);
        }

        @Test
        void valid_skus_with_multiple_offers() {
            int actualPrice = checkoutSolution.checkout("AAABB");
            assertEquals(175, actualPrice);
        }

        @Test
        void valid_with_no_skus() {
            int actualPrice = checkoutSolution.checkout("");
            assertEquals(0, actualPrice);
        }

        @Test
        void valid_skus_with_free_item_offer() {
            int actualPrice = checkoutSolution.checkout("BEE");
            assertEquals(80, actualPrice);
        }

        @Test
        void valid_skus_with_free_item_offer_and_other_offers() {
            int actualPrice = checkoutSolution.checkout("BBBEE");
            assertEquals(125, actualPrice);
        }
    }

    @Nested
    class InvalidSolutions {

        @Test
        void invalid_skus() {
            int actualPrice = checkoutSolution.checkout("Z");
            assertEquals(-1, actualPrice);
        }

        @Test
        void invalid_skus_mixed_with_valid_skus() {
            int actualPrice = checkoutSolution.checkout("ABCDZ");
            assertEquals(-1, actualPrice);
        }

    }

}


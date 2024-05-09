package befaster.solutions.CHK;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {

    private final CheckoutSolution checkoutSolution = new CheckoutSolution();

    @Nested
    class ValidSKUs {

        @Nested
        class WithNoOffers {

            @Test
            void some_skus() {
                int actualPrice = checkoutSolution.checkout("ABCD");
                assertEquals(115, actualPrice);
            }

            @Test
            void all_skus() {
                int actualPrice = checkoutSolution.checkout("ABCDEF");
                assertEquals(165, actualPrice);
            }

            @Test
            void no_skus() {
                int actualPrice = checkoutSolution.checkout("");
                assertEquals(0, actualPrice);
            }
        }

        @Nested
        class WithOffers {
            @Test
            void offer_A() {
                int actualPrice = checkoutSolution.checkout("AAA");
                assertEquals(130, actualPrice);
            }

            @Test
            void offer_A_and_B() {
                int actualPrice = checkoutSolution.checkout("AAABB");
                assertEquals(175, actualPrice);
            }


            @Test
            void offer_E() {
                int actualPrice = checkoutSolution.checkout("BEE");
                assertEquals(80, actualPrice);
            }

            @Test
            void offer_E_and_B() {
                int actualPrice = checkoutSolution.checkout("BBBEE");
                assertEquals(125, actualPrice);
            }

            @Test
            void offer_F() {
                int actualPrice = checkoutSolution.checkout("FFF");
                assertEquals(20, actualPrice);
            }

            @Test
            void offer_F_and_A() {
                int actualPrice = checkoutSolution.checkout("FFFFAAAAA");
                assertEquals(230, actualPrice);
            }

            @Test
            void many_offers() {
                int actualPrice = checkoutSolution.checkout("AAAAABBBBBEEEE");
                assertEquals(200+160+75, actualPrice);
            }
        }
    }

    @Nested
    class InvalidSolutions {

        @Test
        void invalid_skus() {
            int actualPrice = checkoutSolution.checkout("1");
            assertEquals(-1, actualPrice);
        }

        @Test
        void invalid_skus_mixed_with_valid_skus() {
            int actualPrice = checkoutSolution.checkout("ABCD1");
            assertEquals(-1, actualPrice);
        }

    }

}
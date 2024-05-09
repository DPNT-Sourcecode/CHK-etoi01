package befaster.solutions.CHK;

import java.util.List;

record SpecialOffer(
        List<CountedSku> requiredItems,
        Integer priceDiscount
) {

}

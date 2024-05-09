package befaster.solutions.CHK;

import java.util.Map;

public interface ISpecialOffer {

    boolean canApplyOffer(Map<String, Integer> items);

    Integer adjustItemsAndGetResultingDiscount(Map<String, Integer> items);

}



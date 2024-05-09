package befaster.solutions.CHK;

import java.util.List;
import java.util.Map;

public interface ISpecialOffer {

    boolean canApplyOffer(Map<String, Integer> items);

    Integer applyDiscountAndGet(Map<String, Integer> items);

}


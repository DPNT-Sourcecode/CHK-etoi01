package befaster.solutions.CHK;

public class CountedSku {
    private String sku;
    private Integer quantity;

    public CountedSku(
            String item,
            Integer quantity
    ) {
        this.sku = item;
        this.quantity = quantity;
    }

    public CountedSku(
            CountedSku countedSku
    ) {
        this.sku = countedSku.sku;
        this.quantity = countedSku.quantity;
    }

    public String getSku() {
        return sku;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

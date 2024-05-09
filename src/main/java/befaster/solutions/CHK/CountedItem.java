package befaster.solutions.CHK;

public class CountedItem {
    private Item item;
    private Integer quantity;

    public CountedItem(
            Item item,
            Integer quantity
    ) {
        this.item = item;
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }
}


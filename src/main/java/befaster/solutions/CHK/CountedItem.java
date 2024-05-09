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

    public CountedItem(
            CountedItem countedItem
    ) {
        this.item = new Item(countedItem.item);
        this.quantity = countedItem.quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }
}

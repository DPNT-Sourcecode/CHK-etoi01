package befaster.solutions.CHK;

record Item(
        String sku,
        Integer price,
        SpecialOffer specialOffer
) {

    public Item(
            String sku,
            Integer price
    ) {
        this(sku, price, null);
    }

    public boolean hasSpecialOffer() {
        return specialOffer != null;
    }

}


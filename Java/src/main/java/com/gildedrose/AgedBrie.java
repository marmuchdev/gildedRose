package com.gildedrose;

public class AgedBrie extends ItemInventory {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

    }

    @Override
    protected void handleExpired() {
        increaseQuality();
    }
}

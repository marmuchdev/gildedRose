package com.gildedrose;

public class AgedBrie extends ItemFactory {
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

package com.gildedrose;

public class Conjured extends ItemFactory {
    Conjured(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
    }

    @Override
    protected void handleExpired() {
        decreaseQuality();
    }

    @Override
    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality -= 2;
        }
    }
}

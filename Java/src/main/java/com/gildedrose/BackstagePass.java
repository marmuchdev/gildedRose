package com.gildedrose;

public class BackstagePass extends ItemFactory {
    BackstagePass(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (item.sellIn < 11) {
            increaseQuality();
        }
        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    protected void handleExpired() {
        item.quality = 0;
    }
}

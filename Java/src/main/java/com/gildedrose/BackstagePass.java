package com.gildedrose;

public class BackstagePass extends ItemFactory {
    BackstagePass(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        int firstIncreaseStageStart = 11;
        if (item.sellIn < firstIncreaseStageStart) {
            increaseQuality();
        }
        int secondIncreaseStageStart = 6;
        if (item.sellIn < secondIncreaseStageStart) {
            increaseQuality();
        }
    }

    @Override
    protected void handleExpired() {
        item.quality = 0;
    }
}

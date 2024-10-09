package com.gildedrose;

public class ItemFactory {
    protected final Item item;


    ItemFactory(Item item) {
        this.item = item;
    }

    public static ItemFactory createItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(item);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            case "Conjured":
                return new Conjured(item);
            default:
                return new ItemFactory(item);
        }
    }

    public void updateItem() {
        updateQuality();
        updateExpiration();
        if (isExpired()) {
            handleExpired();
        }
    }

    protected void updateQuality() {
        // default/standard item logic
        decreaseQuality();
    }

    protected void updateExpiration() {
        item.sellIn -= 1;
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }

    protected void handleExpired() {
        // default/standard item logic
        decreaseQuality();
    }

    protected void increaseQuality() {
        int maxQuality = 50;
        if (item.quality < maxQuality) {
            item.quality += 1;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}

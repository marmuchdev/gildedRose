package com.gildedrose;

public class ItemInventory {
    protected final Item item;

//    public static ItemInventory createInventoryItem(Item item) {
//        return new ItemInventory(item);
//    }

    ItemInventory(Item item) {
        this.item = item;
    }

    public static ItemInventory createItemInventory(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(item);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            default:
                return new ItemInventory(item);
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
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) item.sellIn -= 1;
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }

    protected void handleExpired() {
        // default/standard item logic
        decreaseQuality();
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}

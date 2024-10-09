package com.gildedrose;


class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        updateQuality(item);
        updateExpiration(item);
        if (isExpired(item)) {
            handleExpired(item);
        }
    }

    private static void updateQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                increaseQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                increaseQuality(item);

                if (item.sellIn < 11) {
                    increaseQuality(item);
                }

                if (item.sellIn < 6) {
                    increaseQuality(item);
                }
                break;
            case
                "Sulfuras, Hand of Ragnaros": //When you update Sulfuras Quality method does nothing as it is legendary product with 80 quality
                break;
            default: //                    Everything else logics Starts
                decreaseQuality(item);
                break;
        }
    }

    private static void updateExpiration(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) item.sellIn = item.sellIn - 1;
    }

    private static void handleExpired(Item item) {
        switch (item.name) {
            case "Aged Brie":
                increaseQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item.quality = 0;
                break;
            case
                "Sulfuras, Hand of Ragnaros": //When you update Sulfuras Quality method does nothing as it is legendary product with 80 quality
                break;
            default: //                    Everything else logics Starts
                decreaseQuality(item);
                break;
        }

    }

    private static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

}

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
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);

            updateExpiration(item);

            if (isExpired(item)) {
                increaseQuality(item);
            }
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }

            updateExpiration(item);
            //        updateSellIn();
            if (isExpired(item)) {
                item.quality = 0;
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {//When you update Sulfuras Quality method does nothing as it is legendary product with 80 quality
        } else {//                    Everything else logics Starts
            decreaseQuality(item);
            updateExpiration(item);
            if (isExpired(item)) {
                decreaseQuality(item);
            }
        }
    }

    private static void updateExpiration(Item item) {
        item.sellIn = item.sellIn - 1;
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

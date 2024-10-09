package com.gildedrose;


class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void dailyInventoryUpdate() {
        for (Item item : items) {
            ItemInventory itemInventory = ItemInventory.createItemInventory(item);
            itemInventory.updateItem();
        }
    }

}

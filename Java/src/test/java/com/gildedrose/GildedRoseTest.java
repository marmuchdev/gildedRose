package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GildedRoseTest {

    @Test
    void dailyInventoryUpdate() {
        //full coverage test
        verifyAllCombinations(
            this::doDailyInventoryUpdate,
            new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
            new Integer[]{-1, 0, 5, 6, 10, 11},
            new Integer[]{0, 1, 49, 50});
    }

    private String doDailyInventoryUpdate(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.dailyInventoryUpdate();
        return app.items[0].toString();
    }

    @Test
    void standardItemQualityDecreaseSellinDecreasesEachDay() {
        int startingSellin = 5;
        int startingQuality = 7;
        final Item standardItem = new Item("Elixir of the Mongoose", startingSellin, startingQuality);
        GildedRose app = new GildedRose(new Item[]{standardItem});

        app.dailyInventoryUpdate();

        assertEquals(standardItem.sellIn, startingSellin - 1);
        assertEquals(standardItem.quality, startingQuality - 1);
    }

    @Test
    void agedBrieIncreaseInQualityOverIime() {
        Item item = new Item("Aged Brie", 5, 6);
        GildedRose app = new GildedRose(new Item[]{item});

        app.dailyInventoryUpdate();

        assertEquals(item.quality, 7);
    }

    @Test
    void itemQualityIsNeverNegative() {
        Item item = new Item("Standard Item", 4, 0);
        GildedRose app = new GildedRose(new Item[]{item});

        app.dailyInventoryUpdate();

        assertEquals(item.quality, 0);
    }

    @Test
    void qualityOfItemIsNeverGreaterThan50() {
        Item item = new Item("Aged Brie", 5, 50);
        GildedRose app = new GildedRose(new Item[]{item});

        app.dailyInventoryUpdate();

        assertEquals(item.quality, 50);
    }

    @Test
    void legendaryItemsNeverDecreaseInQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose app = new GildedRose(new Item[]{item});

        app.dailyInventoryUpdate();

        assertEquals(item.quality, 80);

    }

    @Test
    void legendaryItemsNeverHasToBeSold() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose app = new GildedRose(new Item[]{item});

        app.dailyInventoryUpdate();

        assertEquals(item.sellIn, -1);

    }

    @Test
    void backstagePassesQualityIs0AfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.dailyInventoryUpdate();

        assertEquals(item.quality, 0);
    }

    @Test
    void conjuredItemsDegradeInQualityTwiceAsFast() {
        Item item = new Item("Conjured", 10,20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.dailyInventoryUpdate();

        assertEquals(item.quality,18);
    }

    @Test
    void conjuredItemsDecreaseInSellIn() {
        Item item = new Item("Conjured", 10,20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.dailyInventoryUpdate();

        assertEquals(item.sellIn,9);
    }

    @Test
    void conjuredItemsDegradeInQualityTwiceAsFastThanStandardItemPastExpiryDay() {
        Item item = new Item("Conjured", 0,20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.dailyInventoryUpdate();

        assertEquals(item.quality,16);
    }
}

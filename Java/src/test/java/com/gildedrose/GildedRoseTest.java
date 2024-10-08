package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GildedRoseTest {

    @Test
    void udpateQuality() throws Exception {
        //full coverage test
        verifyAllCombinations(
            this::doUpdateQuality,
            new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
            new Integer[]{-1,0,5,6,11},
            new Integer[]{0,1,49,50});
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] {Item.createItem(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }

    @Test
    void standardItemQualityDecreaseSellinDecreasesEachDay() {
        int startingSellin = 5;
        int startingQuality = 7;
        final Item standardItem = Item.createItem("Elixir of the Mongoose", startingSellin, startingQuality);
        GildedRose app = new GildedRose(new Item[] {standardItem});

        app.updateQuality();

        assertEquals(standardItem.sellIn,startingSellin - 1);
        assertEquals(standardItem.quality,startingQuality - 1);
    }

    @Test
    void agedBrieIncreaseInQualityOverIime() {
        Item item = Item.createItem("Aged Brie", 5, 6);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(item.quality,7);
    }

    @Test
    void itemQualityIsNeverNegative() {
        Item item = new Item("Standard Item", 4, 0);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(item.quality,0);
    }
    @Test
    void qualityOfItemIsNeverGreaterThan50() {
        Item item = new Item("Aged Brie", 5, 51);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(item.quality,50);
    }


}

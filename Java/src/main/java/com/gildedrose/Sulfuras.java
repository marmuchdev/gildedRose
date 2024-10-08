package com.gildedrose;

public class Sulfuras extends Item {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    protected void doUpdateQuality() {
        //When you update Sulfuras Quality method does nothing as it is legendery product with 80 quality
    }
}

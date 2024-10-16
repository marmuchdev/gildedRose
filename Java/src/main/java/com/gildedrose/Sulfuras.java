package com.gildedrose;

public class Sulfuras extends ItemFactory {
    Sulfuras(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        /* When you update Sulfuras Quality method does nothing
        as it is legendary product with 80 quality that never changes */
    }

    @Override
    protected void updateExpiration() {
        // Sulfuras never expires- has no expiry date
    }

    @Override
    protected void handleExpired() {
        // Sulfuras never expires- has no expiry date
    }
}

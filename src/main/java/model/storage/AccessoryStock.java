package model.storage;

import model.products.Accessory;

public class AccessoryStock extends AbstractStock<Accessory> {
    public AccessoryStock(int capacity) {
        super(capacity);
        this.id = StockId.ACCESSORY;
    }
}
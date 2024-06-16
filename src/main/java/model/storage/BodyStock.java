package model.storage;

import model.products.Body;

public class BodyStock extends AbstractStock<Body> {
    public BodyStock(int capacity) {
        super(capacity);
        this.id = StockId.BODY;
    }
}
package model.suppliers;

import model.products.Body;
import model.storage.BodyStock;

public class BodySupplier extends Supplier<Body> {
    public BodySupplier(int supplyTimeout, BodyStock stock) {
        super(supplyTimeout, stock);
    }

    @Override
    public Body produce() {
        return new Body();
    }
}
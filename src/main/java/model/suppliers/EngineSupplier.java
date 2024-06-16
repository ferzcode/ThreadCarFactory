package model.suppliers;

import model.products.Engine;
import model.storage.EngineStock;

public class EngineSupplier extends Supplier<Engine> {
    public EngineSupplier(int supplyTimeout, EngineStock stock) {
        super(supplyTimeout, stock);
    }

    @Override
    public Engine produce() {
        return new Engine();
    }
}
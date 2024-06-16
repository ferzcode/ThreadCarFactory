package model.storage;

import model.products.Car;

public class CarStock extends AbstractStock<Car> {
    public CarStock(int capacity) {
        super(capacity);
        this.id = StockId.CAR;
    }
}
package model.products;

public class Car extends AbstractProduct {
    private static int nextId;
    private final Accessory accessory;
    private final Body body;
    private final Engine engine;

    public Car(Accessory accessory, Body body, Engine engine) {
        super(nextId++);
        this.accessory = accessory;
        this.body = body;
        this.engine = engine;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public Body getBody() {
        return body;
    }

    public Engine getEngine() {
        return engine;
    }
}
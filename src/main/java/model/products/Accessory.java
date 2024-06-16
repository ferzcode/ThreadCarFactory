package model.products;

public class Accessory extends AbstractProduct {
    private static int nextId;

    public Accessory() {
        super(nextId++);
    }
}
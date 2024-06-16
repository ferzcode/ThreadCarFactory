package model.products;

public class Engine extends AbstractProduct {
    private static int nextId;

    public Engine() {
        super(nextId++);
    }
}
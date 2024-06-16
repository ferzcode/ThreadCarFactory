package model.products;

public class Body extends AbstractProduct {
    private static int nextId;

    public Body() {
        super(nextId++);
    }
}
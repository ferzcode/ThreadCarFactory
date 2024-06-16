package model.products;

public abstract class AbstractProduct {
    protected final int id;

    protected AbstractProduct(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
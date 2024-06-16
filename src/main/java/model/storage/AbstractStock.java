package model.storage;

import model.products.AbstractProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class AbstractStock<T extends AbstractProduct> {
    protected StockId id;
    protected final int capacity;
    protected int numStored;
    protected final Stack<T> storedItems;

    private final List<StockListener> listeners = new ArrayList<>();

    protected AbstractStock(int capacity) {
        this.capacity = capacity;
        storedItems = new Stack<>();
    }

    public void addListener(StockListener listener) {
        listeners.add(listener);
    }

    synchronized public void add(T item) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        storedItems.add(item);
        numStored++;
        notify();

        for (StockListener listener : listeners) {
            listener.numStoredUpdated(numStored, id);
            listener.newItem(id);
        }
    }

    synchronized public T get() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        T item = storedItems.pop();
        numStored--;
        notify();

        for (StockListener listener : listeners)
            listener.numStoredUpdated(numStored, id);

        return item;
    }

    public boolean isFull() {
        return numStored == capacity;
    }

    public boolean isEmpty() {
        return numStored == 0;
    }

    public int getNumStored() {
        return numStored;
    }

    public int getCapacity() {
        return capacity;
    }
}
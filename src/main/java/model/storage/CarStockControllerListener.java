package model.storage;

public interface CarStockControllerListener extends StockListener {
    void pendingUpdated(int newNumPending);
}
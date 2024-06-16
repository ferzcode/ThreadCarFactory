package model;

import model.storage.CarStockControllerListener;
import model.storage.StockListener;

public interface ModelListener extends StockListener, CarStockControllerListener {
}
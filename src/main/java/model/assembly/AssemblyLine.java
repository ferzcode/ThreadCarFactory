package model.assembly;

import model.products.Car;
import model.storage.AccessoryStock;
import model.storage.BodyStock;
import model.storage.EngineStock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AssemblyLine {
    private final AccessoryStock accessoryStock;
    private final BodyStock bodyStock;
    private final EngineStock engineStock;

    private final ExecutorService workersPool;

    private AssemblyLineListener listener;

    public AssemblyLine(AccessoryStock accessoryStock, BodyStock bodyStock,
                        EngineStock engineStock, int numWorkers) {
        this.accessoryStock = accessoryStock;
        this.bodyStock = bodyStock;
        this.engineStock = engineStock;
        workersPool = Executors.newFixedThreadPool(numWorkers);
    }

    public void assemble() {
        Car car = new Car(accessoryStock.get(), bodyStock.get(), engineStock.get());
        if (listener != null)
            listener.produced(car);
    }

    public void requestCarProduction() {
        workersPool.submit(this::assemble);
    }

    public void setListener(AssemblyLineListener listener) {
        this.listener = listener;
    }
}
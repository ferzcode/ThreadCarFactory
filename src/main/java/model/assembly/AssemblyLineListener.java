package model.assembly;

import model.products.Car;

public interface AssemblyLineListener {
    void produced(Car car);
}
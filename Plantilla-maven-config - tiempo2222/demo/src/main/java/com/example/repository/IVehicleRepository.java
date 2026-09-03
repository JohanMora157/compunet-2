package com.example.repository;

import java.util.List;
import com.example.model.Vehicle;

public interface IVehicleRepository {
    void init();
    Vehicle save(Vehicle vehicle);
    Vehicle find(int id);
    List<Vehicle> list();
}

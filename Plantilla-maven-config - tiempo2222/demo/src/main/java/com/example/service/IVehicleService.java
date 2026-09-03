package com.example.service;

import java.util.List;
import com.example.model.Vehicle;

public interface IVehicleService {
    Vehicle save(Vehicle vehicle);
    Vehicle find(int id);
    List<Vehicle> list();
}

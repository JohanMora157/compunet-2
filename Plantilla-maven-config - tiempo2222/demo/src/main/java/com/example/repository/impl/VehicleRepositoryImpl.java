package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Vehicle;
import com.example.repository.IVehicleRepository;

public class VehicleRepositoryImpl implements IVehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();
    private int countId = 0;

    @Override
    public void init() {
        // String Captain, String ClassType, String CommissionDate, String RegistryCode, String Status, int id, String name
        vehicles.add(new Vehicle("fajardo", "dwqqsq", "dwad", "popopopo", "arads", countId++, "ojjoa"));
        vehicles.add(new Vehicle("aponza", "dwqqsq2", "dwad2", "popopopo", "arads", countId++, "ojjoa"));
        vehicles.add(new Vehicle("cubillo", "dwqqsq3", "dwad3", "popopopo", "arads", countId++, "ojjoa"));
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        } else {
            vehicle.setId(countId++);
            vehicles.add(vehicle);
            return vehicle;
        }
    }

    @Override
    public Vehicle find(int id) {
        for (Vehicle v : vehicles) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> list() {
        return vehicles;
    }
}

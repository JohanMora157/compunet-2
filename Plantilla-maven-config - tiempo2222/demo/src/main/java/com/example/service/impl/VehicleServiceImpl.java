package com.example.service.impl;

import java.util.List;

import com.example.model.Vehicle;
import com.example.repository.IVehicleRepository;
import com.example.service.IVehicleService;

public class VehicleServiceImpl implements IVehicleService {

    private IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        for (Vehicle v : vehicleRepository.list()) {
            if (vehicle.getRegistryCode() == v.getRegistryCode()) {
                throw new IllegalArgumentException("ya hay otro vehiculo con el registrycode");
            }
        }

        if (!(vehicle.getRegistryCode().length() == 8)) {
            throw new IllegalArgumentException("el registry code debe contener exactamente 8 chars");
        }

        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle find(int id) {
        return vehicleRepository.find(id);
    }

    @Override
    public List<Vehicle> list() {
        return vehicleRepository.list();
    }
}

package com.example.service.impl;

import java.util.List;

import com.example.model.MechanicVisit;
import com.example.repository.IMechanicVisitRepository;
import com.example.repository.IVehicleRepository;
import com.example.service.IMechanicVisitService;

public class MechanicVisitServiceImpl implements IMechanicVisitService {
    private IMechanicVisitRepository mechanicVisitRepository;
    private IVehicleRepository vehicleRepository;

    public MechanicVisitServiceImpl(IMechanicVisitRepository mechanicVisitRepository, IVehicleRepository vehicleRepository) {
        this.mechanicVisitRepository = mechanicVisitRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public MechanicVisit save(MechanicVisit mechanicVisit) {
        for (MechanicVisit m : mechanicVisitRepository.list()) {
            if ((mechanicVisit.getLogCode() == m.getLogCode()) && (mechanicVisit != m)) {
                throw new IllegalArgumentException("ya hay otra visita con el LogCode");
            }
        }

        if (!(mechanicVisit.getThreatLevel() > 0 && mechanicVisit.getThreatLevel() < 11)) {
            throw new IllegalArgumentException("el valor debe de estar entre 1 y 10");
        }

        if (vehicleRepository.find(mechanicVisit.getVehicleId()) == null) {
            throw new IllegalArgumentException("el vehiculo no existe");
        }

        if (vehicleRepository.find(mechanicVisit.getVehicleId()).getStatus().equals("Decommissioned")) {
            throw new IllegalArgumentException("el vehiculo no existe");
        }

        return mechanicVisitRepository.save(mechanicVisit);
    }

    @Override
    public MechanicVisit find(int id) {
        return mechanicVisitRepository.find(id);
    }

    @Override
    public List<MechanicVisit> list() {
        return mechanicVisitRepository.list();
    }
}

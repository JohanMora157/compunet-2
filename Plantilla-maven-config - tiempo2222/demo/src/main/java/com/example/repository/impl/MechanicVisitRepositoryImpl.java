package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.MechanicVisit;
import com.example.repository.IMechanicVisitRepository;

public class MechanicVisitRepositoryImpl implements IMechanicVisitRepository {

    private List<MechanicVisit> visits = new ArrayList<>();
    private int countId = 0;

    @Override
    public void init() {
        // String Description, String LogCode, String Sector, String StarDate, int VehicleId, int ThreatLevel, String Title, int id
        visits.add(new MechanicVisit("aponzaa", "1231231234", "norte", "oqwei", 0, 3, "toponza", countId++));
        visits.add(new MechanicVisit("aponzaa1", "12312123132", "norte", "oqwei", 1, 3, "toponza", countId++));
        visits.add(new MechanicVisit("aponza2", "1231231233415", "sur", "oqwei", 2, 3, "toponza", countId++));
    }

    @Override
    public MechanicVisit save(MechanicVisit mechanicVisit) {
        if (mechanicVisit == null) {
            return null;
        } else {
            mechanicVisit.setId(countId++);
            visits.add(mechanicVisit);
            return mechanicVisit;
        }
    }

    @Override
    public MechanicVisit find(int id) {
        for (MechanicVisit m : visits) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<MechanicVisit> list() {
        return visits;
    }
}

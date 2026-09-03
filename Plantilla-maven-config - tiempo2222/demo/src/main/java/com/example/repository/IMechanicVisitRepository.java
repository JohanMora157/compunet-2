package com.example.repository;

import java.util.List;
import com.example.model.MechanicVisit;

public interface IMechanicVisitRepository {
    void init();
    MechanicVisit save(MechanicVisit mechanicVisit);
    MechanicVisit find(int id);
    List<MechanicVisit> list();
}

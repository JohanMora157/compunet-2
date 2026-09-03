package com.example.service;

import java.util.List;
import com.example.model.MechanicVisit;

public interface IMechanicVisitService {
    MechanicVisit save(MechanicVisit mechanicVisit);
    MechanicVisit find(int id);
    List<MechanicVisit> list();
}

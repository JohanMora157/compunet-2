package com.parcial.repository;

import java.util.List;

import com.parcial.model.*;

public interface IMeasurementRepository {

    void init();

    Measurement saveMeasurement(Measurement measurement);

    Measurement searchMeasurement(int id);

    List<Measurement> listAll();

}

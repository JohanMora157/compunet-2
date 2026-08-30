package com.parcial.service;

import java.util.List;

import com.parcial.model.Measurement;

public interface IMeasurementService {


    
    Measurement saveMeasurement(Measurement measurement);

    Measurement searchMeasurement(int id);

    List<Measurement> listAll();

}

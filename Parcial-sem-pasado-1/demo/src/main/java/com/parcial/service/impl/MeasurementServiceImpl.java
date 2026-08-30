package com.parcial.service.impl;

import java.util.List;

import com.parcial.model.Measurement;
import com.parcial.repository.IMeasurementRepository;
import com.parcial.service.IMeasurementService;

public class MeasurementServiceImpl implements IMeasurementService{

    private final IMeasurementRepository measurementRepository;
    

    public MeasurementServiceImpl (IMeasurementRepository measurementRepository){
        this.measurementRepository = measurementRepository;
    }


    @Override
    public Measurement saveMeasurement(Measurement measurement) {
        return measurementRepository.saveMeasurement(measurement);
    }

    @Override
    public Measurement searchMeasurement(int id) {
        return measurementRepository.searchMeasurement(id);

    }

    @Override
    public List<Measurement> listAll() {
        return measurementRepository.listAll();
    }
    

}

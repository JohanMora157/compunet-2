package com.parcial.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.parcial.model.Measurement;
import com.parcial.repository.IMeasurementRepository;

public class MeasurementRepositoryImpl implements IMeasurementRepository {

    private List<Measurement> measurements = new ArrayList<>();
    private int idCount = 1;


    @Override
    public void init() {

        measurements.add(new Measurement(idCount++,2000,1000,2));

    }

    @Override
    public Measurement saveMeasurement(Measurement measurement) {

        if (measurement == null) {

            return null;
            
        }else{

            measurement.setId(idCount++);
            measurements.add(measurement);
            return measurement;

        }
        
    }

    @Override
    public Measurement searchMeasurement(int id) {

        for (Measurement measurement: measurements) {
            
            if (measurement.getId()==id) {

                return measurement;
                
            }

        }
        return null;

    }

    @Override
    public List<Measurement> listAll() {
    return measurements; 
    }
    
}

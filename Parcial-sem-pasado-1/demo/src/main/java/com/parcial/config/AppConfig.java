package com.parcial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parcial.repository.IDeviceRepository;
import com.parcial.repository.IMeasurementRepository;
import com.parcial.repository.impl.DeviceRepositoryImpl;
import com.parcial.repository.impl.MeasurementRepositoryImpl;
import com.parcial.service.IDeviceService;
import com.parcial.service.IMeasurementService;
import com.parcial.service.impl.DeviceServiceImpl;
import com.parcial.service.impl.MeasurementServiceImpl;

@Configuration
public class AppConfig {

    @Bean(initMethod="init")
    public IDeviceRepository deviceRepository(){
        return new DeviceRepositoryImpl();
    
    }


    @Bean(initMethod="init")
    public IMeasurementRepository measurementRepository(){
        return new MeasurementRepositoryImpl();
    
    }

    @Bean
    public IDeviceService deviceService(IDeviceRepository deviceRepository){
        return new DeviceServiceImpl(deviceRepository);
    }

     @Bean
    public IMeasurementService measurementService(IMeasurementRepository measurementRepository){
        return new MeasurementServiceImpl(measurementRepository);
    }



}

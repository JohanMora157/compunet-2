package com.example.config;

import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {




    
}



 //EJEMPLO DE COMO SE AÑADEN LOS SERVICES Y REPOSITORYS
 
/* @Bean(initMethod="init")
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
    } */
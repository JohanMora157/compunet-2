package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.repository.IMechanicVisitRepository;
import com.example.repository.IVehicleRepository;
import com.example.repository.impl.MechanicVisitRepositoryImpl;
import com.example.repository.impl.VehicleRepositoryImpl;
import com.example.service.IMechanicVisitService;
import com.example.service.IVehicleService;
import com.example.service.impl.MechanicVisitServiceImpl;
import com.example.service.impl.VehicleServiceImpl;

@Configuration
public class AppConfig {

    @Bean(initMethod="init")
    public IVehicleRepository vehicleRepository(){
        return new VehicleRepositoryImpl();
    }
    
    @Bean(initMethod="init")
    public IMechanicVisitRepository mechanicVisitRepository(){
        return new MechanicVisitRepositoryImpl();
    }

    @Bean
    public IMechanicVisitService mechanicVisitService(IMechanicVisitRepository mechanicVisitRepository, IVehicleRepository vehicleRepository){
        return new MechanicVisitServiceImpl(mechanicVisitRepository, vehicleRepository);
    }

    @Bean
    public IVehicleService vehicleService(IVehicleRepository vehicleRepository){
        return new VehicleServiceImpl(vehicleRepository);
    }

}
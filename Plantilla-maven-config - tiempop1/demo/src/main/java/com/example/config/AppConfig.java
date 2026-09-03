package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.repository.IMissionLogRepositoty;
import com.example.repository.IStarshipRepositoty;
import com.example.repository.impl.MissionLogRepositotyImpl;
import com.example.repository.impl.StarshipRepositotyImpl;
import com.example.service.IMissionLogService;
import com.example.service.IStarshipService;
import com.example.service.impl.MissionLogServiceImpl;
import com.example.service.impl.StarshipServiceImpl;


@Configuration
public class AppConfig {

    
      @Bean(initMethod="init")
    public IStarshipRepositoty starshipRepositoty(){
        return new StarshipRepositotyImpl();
    }
    
    
    @Bean(initMethod="init")
    public IMissionLogRepositoty missionLogRepositoty(){
        return new MissionLogRepositotyImpl();
    }


    @Bean
    public IMissionLogService missionLogService(IMissionLogRepositoty missionLogRepositoty,IStarshipRepositoty starshipRepositoty){
        return new MissionLogServiceImpl(missionLogRepositoty,starshipRepositoty);
    }


    @Bean
    public IStarshipService starshipService(IStarshipRepositoty starshipRepositoty){
        return new StarshipServiceImpl(starshipRepositoty);
    }


    
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
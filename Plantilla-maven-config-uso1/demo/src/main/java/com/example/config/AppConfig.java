package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.repository.ICourseRepository;
import com.example.repository.IEnrollmentRepository;
import com.example.repository.impl.CourseRepositoryImpl;
import com.example.repository.impl.EnrollmentRepositoryImpl;
import com.example.service.ICourseService;
import com.example.service.IEnrollmentService;
import com.example.service.impl.CourseServiceImpl;
import com.example.service.impl.EnrollmentServiceImpl;


@Configuration
public class AppConfig {

    @Bean(initMethod="init")
    public ICourseRepository courseRepository(){
        return  new CourseRepositoryImpl();
    }

   @Bean(initMethod="init")
    public IEnrollmentRepository enrollmentRepository(){
        return  new EnrollmentRepositoryImpl();
    }


    @Bean
public ICourseService courseService(ICourseRepository courseRepository){
    return new CourseServiceImpl(courseRepository);
    
}
    
@Bean
public IEnrollmentService enrollmentService(IEnrollmentRepository enrollmentRepository,ICourseRepository courseRepository){
    return new EnrollmentServiceImpl(enrollmentRepository,courseRepository);
    
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
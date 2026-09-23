package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Airline;
import com.example.demo.repository.IAirlineRepository;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final IAirlineRepository airlineRepository;

    @GetMapping
    public List<Airline> findAllAirlines() {
        return airlineRepository.findAll();
    }

    @GetMapping("/consult1")
    public List<Airline> getMethodName() {
        return airlineRepository.findByAirplanesFlightsOriginAirportNameAndAirplanesFlightsDestinationAirportName("El Dorado", "JFK");
    }

    @GetMapping("/consult3")
    public List<Airline> getMethodName2(@RequestParam String city) {
        return airlineRepository.findByAirplanesFlightsOriginAirportCityOrAirplanesFlightsDestinationAirportCity(city,city);
    }
    
    
  @GetMapping("/consult4")
    public List<Airline> getMethodName3() {
        return airlineRepository.findByAirplanesFlightsDestinationAirportNameAndAirplanesFlightsArrivalDateBetween("El Dorado",Timestamp.valueOf("2026-03-01 00:00:00"),Timestamp.valueOf("2026-03-11 23:59:59"));
    }
    


}




package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Airport;
import com.example.demo.repository.IAirportRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/airports")
@RequiredArgsConstructor
public class AirportController {

    private final IAirportRepository airportRepository;

    @GetMapping
    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }


    @GetMapping("/consult2")
    public List<Airport> getMethodName() {
        return airportRepository.findByDestinationFlightsDestinationAirportName("El Dorado");
    }
    


    
}

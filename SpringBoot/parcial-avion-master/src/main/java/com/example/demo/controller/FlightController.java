package com.example.demo.controller;

import com.example.demo.model.Flight;
import com.example.demo.repository.IFlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final IFlightRepository flightRepository;

    @GetMapping
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }
}

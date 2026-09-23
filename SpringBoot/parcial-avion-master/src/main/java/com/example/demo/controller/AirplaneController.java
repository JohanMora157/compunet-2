package com.example.demo.controller;

import com.example.demo.model.Airplane;
import com.example.demo.repository.IAirplaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airplanes")
@RequiredArgsConstructor
public class AirplaneController {

    private final IAirplaneRepository airplaneRepository;

    @GetMapping
    public List<Airplane> findAllAirplanes() {
        return airplaneRepository.findAll();
    }
}

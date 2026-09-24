package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Club;
import com.example.demo.repository.IClubRepository;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final IClubRepository clubRepository;

    @GetMapping
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
    

    @GetMapping("/consult4")
    public List<Club> consulta4() {
        return clubRepository.findByPlayerClubsPlayerCountryHomeIdOrPlayerClubsPlayerCountryAwayId(2L,2L);
    }
    
    
}

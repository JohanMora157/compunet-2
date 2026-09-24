package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Match;
import com.example.demo.repository.IMatchRepository;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/matches")
@RequiredArgsConstructor
public class MatchController  {
    
    private final IMatchRepository matchRepository;


    @GetMapping
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
    


    @GetMapping("/consult3")
    public List<Match> consulta3() {
        return matchRepository.findByHomePlayersPlayerClubsClubNameAndHomePlayersPlayerClubsEndDateIsNull("Liverpool FC");
    }
    


}

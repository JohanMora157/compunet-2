package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Player;
import com.example.demo.repository.IPlayerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final IPlayerRepository playerRepository;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/consult1")
    public List<Player> consulta1() {
        return playerRepository.findByPlayerClubsClubName("Real Madrid");
    }

    @GetMapping("/consult2")
    public List<Player> consulta2() {
        return playerRepository.findByCountryNameAndPlayerClubsClubName("Colombia","Real Madrid");
    }

}

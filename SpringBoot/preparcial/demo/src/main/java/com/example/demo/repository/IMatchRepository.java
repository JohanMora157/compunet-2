package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Match;

public interface IMatchRepository extends JpaRepository<Match, Long> {
    
    public List<Match> findByHomePlayersPlayerClubsClubNameAndHomePlayersPlayerClubsEndDateIsNull(String teamName);
}

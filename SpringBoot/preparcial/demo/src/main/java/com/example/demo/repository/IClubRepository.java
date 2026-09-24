package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Club;

public interface IClubRepository extends JpaRepository<Club,Long>{

    public List<Club> findByPlayerClubsPlayerCountryHomeIdOrPlayerClubsPlayerCountryAwayId(Long matchId,Long matchId2);
    
}

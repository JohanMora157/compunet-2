package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Player;

public interface  IPlayerRepository extends  JpaRepository<Player, Long>{


    public List<Player> findByPlayerClubsClubName(String clubName);

    public List<Player> findByCountryNameAndPlayerClubsClubName( String nameCountry,String nameClub);
    
    

}

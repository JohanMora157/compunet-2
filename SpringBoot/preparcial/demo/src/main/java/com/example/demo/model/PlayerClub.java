package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player_club")
public class PlayerClub{


    @EmbeddedId
    private PlayerClubId id;

    private Timestamp endDate;

    
    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Player player;
    
     
    @ManyToOne
    @MapsId("clubId") 
    @JoinColumn(name = "club_id")
    private Club club;







    


}
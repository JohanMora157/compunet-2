package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player")
public class Player {

    @Id // dice que este atributo es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    private String name;
    private Timestamp birth_date;
    private String position;
    private int fifa_score; 


    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @ToString.Exclude    
    @OneToMany(mappedBy= "player")
    private List<PlayerClub> playerClubs;


    
    
}

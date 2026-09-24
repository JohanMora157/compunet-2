package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "country")
public class Country {


    @Id // dice que este atributo es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String name;
    private String code;
    private String confederation;

    @JsonIgnore
    @ToString.Exclude    
    @OneToMany(mappedBy= "country")
    private List<Player> players;

    @JsonIgnore
    @ToString.Exclude    
    @OneToMany(mappedBy= "country")
    private List<Club> clubs;

    @JsonIgnore
    @ToString.Exclude    
    @OneToMany(mappedBy= "away")
    private List<Match> away;

    @JsonIgnore
    @ToString.Exclude    
    @OneToMany(mappedBy= "home")
    private List<Match> home;
    



}

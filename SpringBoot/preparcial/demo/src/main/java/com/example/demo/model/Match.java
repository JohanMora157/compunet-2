package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match")
public class Match {
    
@Id // dice que este atributo es PK
@GeneratedValue(strategy = GenerationType.IDENTITY)     
private Long id;

private Timestamp match_date;
private String stadium;

@ManyToOne
    @JoinColumn(name = "home_country_id")
    private Country home;

    
@ManyToOne
    @JoinColumn(name = "away_country_id")
    private Country away;



}   

package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name = "airports")
public class Airport {


    @Id // dice que este atributo es PK
@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String name;

    private String city;

    private String country;

    private String iataCode;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Flight> departingFlights = new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "originAirport", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Flight> destinationFlights = new ArrayList<>();

    
 @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Ticket> departingTickets= new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "originAirport", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Ticket> destinationTickets = new ArrayList<>();

    

    
    

}

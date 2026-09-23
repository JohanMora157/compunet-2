package com.example.demo.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;

    private int estimated_passengers;

    private Timestamp departureDate;

    private Timestamp arrivalDate;

    
    @ManyToOne()
    @JoinColumn(name = "originAirport_id")
    private Airport originAirport;
    @ManyToOne
    @JoinColumn(name = "destinationAirport_id")
    private Airport destinationAirport;
    
    
    @JsonIgnore
    @ToString.Exclude    
    @OneToMany(mappedBy= "flight")
    private List<TicketFlight> ticketFlights = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

}

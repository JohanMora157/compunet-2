package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passengerFullName;

    private String bookingCode;

    private Timestamp purchaseDate;


    @ManyToOne()
    @JoinColumn(name = "originAirport_id")
    private Airport originAirport;
    @ManyToOne
    @JoinColumn(name = "destinationAirport_id")
    private Airport destinationAirport;
    

    @ManyToOne(fetch = FetchType.LAZY)
    private Ticket ticketFlights;
}

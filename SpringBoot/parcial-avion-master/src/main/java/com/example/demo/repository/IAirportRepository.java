package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Airport;

public interface IAirportRepository extends JpaRepository<Airport, Long> {


    public List<Airport> findByDestinationFlightsDestinationAirportName(String nameAirport);
}


/*Listar los aeropuertos que reciben vuelos provenientes de un aeropuerto específico
(por nombre del aeropuerto origen).ΑΓΝΟΗΣΤΕ αυτήν την απαίτηση
Si su entrada es El Dorado, su salida será JFK, LAX, Barajas, Heathrow, Charles de
Gaulle, Guarulhos, Benito Juarez, Jorge Chavez, Miami International. */
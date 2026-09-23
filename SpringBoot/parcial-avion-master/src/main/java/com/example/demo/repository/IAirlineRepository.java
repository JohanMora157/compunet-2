package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Airline;

public interface IAirlineRepository extends JpaRepository<Airline, Long> {



    public List<Airline> findByAirplanesFlightsOriginAirportNameAndAirplanesFlightsDestinationAirportName(String nameOriginAirport, String nameDestAirport);
    public List<Airline> findByAirplanesFlightsDestinationAirportNameAndAirplanesFlightsArrivalDateBetween(String name ,Timestamp departureDate,Timestamp arivalDate);

public List<Airline> findByAirplanesFlightsOriginAirportCityOrAirplanesFlightsDestinationAirportCity(String city1, String city2);


    /*• Obtener las aerolíneas que cubren un trayecto exacto entre dos aeropuertos (por
nombre de aeropuerto origen y destino).
Si su entrada es El Dorado y JFK, su salida será Andes Air, Global Air */

}

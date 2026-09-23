package com.example.demo.model;

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
@Table(name = "airplanes")
public class Airplane {
        
    @Id // dice que este atributo es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String model;

    private String registrationNumber;

    private Integer seatCapacity;


    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;


    @JsonIgnore
    @ToString.Exclude    
    @OneToMany(mappedBy= "airplane")
    private List<Flight> flights;
}

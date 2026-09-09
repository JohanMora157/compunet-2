package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder 
@NoArgsConstructor 
@AllArgsConstructor
@Entity 
@Table(name="exercises")
public class Exercise {
@Id 
@GeneratedValue (strategy=GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String description;
    private float estimatedCalories;
    private float estimatedDistanceKm;
    private int estimatedDurationMin;
    private String icon;
    private Timestamp createdAt;
    
}

package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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


    @OneToMany(mappedBy = "exercise")
    @JsonIgnoreProperties("exercise")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<RoutineExercise> routineExercises;
    

    private String name;
    private String description;
    private String type;
    private float estimatedCalories;
    private float estimatedDistanceKm;
    private int estimatedDurationMin;
    private String icon;
    private Timestamp createdAt;
    
}

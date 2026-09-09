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
@Table(name="routine_exercises")
public class RoutineExercise {


    @Id 
@GeneratedValue (strategy=GenerationType.IDENTITY)
    private int id;

    private int routineId;
    private int exerciseId;
    
        private int orderIndex;
    private int targetSets;
    private int targetReps;
    private float targetWeightKg;
    private int targetDurationMin; 
    private Timestamp createdAt;

    
}

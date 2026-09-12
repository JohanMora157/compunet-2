package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="routine_exercises")
public class RoutineExercise {

    @Id 
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "routine_id")
    @JsonIgnoreProperties({"routineExercises", "activityLogs"})
    private Routine routine; //FK

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    @JsonIgnoreProperties("routineExercises")
    private Exercise exercise; //FK

    @OneToMany(mappedBy = "routineExercise")
    @JsonIgnoreProperties("routineExercise")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ActivityExercise> activityExercise;
    
    private int orderIndex;
    private int targetSets;
    private int targetReps;
    private float targetWeightKg;
    private int targetDurationMin; 
    private Timestamp createdAt;

    
}

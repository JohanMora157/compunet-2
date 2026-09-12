package com.example.demo.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "activity_exercises")
public class ActivityExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "activity_log_id")
    @JsonIgnoreProperties("activityExercise")
    private ActivityLog activityLog; //FK

    @ManyToOne
    @JoinColumn(name = "routine_exercise_id")
    @JsonIgnoreProperties("activityExercise")
    private RoutineExercise routineExercise; //FK  

    private Integer actualSets;

    private Integer actualReps;

    private Float actualWeightKg;

    private Integer actualDurationMin;

    private Float caloriesBurned;

    private Float distanceCoveredKm;

    private Timestamp startedAt;

    private Timestamp completedAt;
}
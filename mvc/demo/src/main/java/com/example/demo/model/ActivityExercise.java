package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

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

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_log_id")
    private ActivityLog activityLog;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_exercise_id")
    private RoutineExercise routineExercise;

    private Integer actualSets;

    private Integer actualReps;

    private Float actualWeightKg;

    private Integer actualDurationMin;

    private Float caloriesBurned;

    private Float distanceCoveredKm;

    private Timestamp startedAt;

    private Timestamp completedAt;
}

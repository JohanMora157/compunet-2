package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routine_exercises")
public class RoutineExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id")
    private Routine routine;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private Integer orderIndex;

    private Integer targetSets;

    private Integer targetReps;

    private Float targetWeightKg;

    private Integer targetDurationMin;

    private Timestamp createdAt;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "routineExercise", cascade = CascadeType.ALL)
    private List<ActivityExercise> activityExercises;
}

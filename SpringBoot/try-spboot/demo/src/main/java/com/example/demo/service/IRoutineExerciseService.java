package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.RoutineExercise;

public interface IRoutineExerciseService {
    List<RoutineExercise> findAll();
    Optional<RoutineExercise> findById(Integer id);
    RoutineExercise save(RoutineExercise routineExercise);
    void deleteById(Integer id);
    List<RoutineExercise> findByRoutineId(int routineId);
    List<RoutineExercise> findByExerciseId(int exerciseId);
}

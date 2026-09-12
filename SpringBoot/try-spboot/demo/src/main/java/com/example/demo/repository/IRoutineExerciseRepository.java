package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RoutineExercise;

@Repository
public interface IRoutineExerciseRepository extends JpaRepository<RoutineExercise, Integer> {
    List<RoutineExercise> findByRoutineId(int routineId);
    List<RoutineExercise> findByExerciseId(int exerciseId);
}

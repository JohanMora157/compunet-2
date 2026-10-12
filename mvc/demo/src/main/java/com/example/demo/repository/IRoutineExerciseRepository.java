package com.example.demo.repository;

import com.example.demo.model.RoutineExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoutineExerciseRepository extends JpaRepository<RoutineExercise, Integer> {
}

package com.example.demo.repository;

import com.example.demo.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExerciseRepository extends JpaRepository<Exercise, Integer> {
}

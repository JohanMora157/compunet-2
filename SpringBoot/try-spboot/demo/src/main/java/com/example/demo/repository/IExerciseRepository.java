package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Exercise;

@Repository
public interface IExerciseRepository extends JpaRepository<Exercise, Integer> {
    List<Exercise> findByType(String type);
}

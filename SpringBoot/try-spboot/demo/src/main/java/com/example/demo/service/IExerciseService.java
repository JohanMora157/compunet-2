package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Exercise;

public interface IExerciseService {
    List<Exercise> findAll();
    Optional<Exercise> findById(Integer id);
    Exercise save(Exercise exercise);
    void deleteById(Integer id);
    List<Exercise> findByType(String type);
}

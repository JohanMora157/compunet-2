package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Exercise;
import com.example.demo.repository.IExerciseRepository;
import com.example.demo.service.IExerciseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements IExerciseService {

    private final IExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Optional<Exercise> findById(Integer id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public void deleteById(Integer id) {
        exerciseRepository.deleteById(id);
    }

    @Override
    public List<Exercise> findByType(String type) {
        return exerciseRepository.findByType(type);
    }
}

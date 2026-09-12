package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.RoutineExercise;
import com.example.demo.repository.IRoutineExerciseRepository;
import com.example.demo.service.IRoutineExerciseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoutineExerciseServiceImpl implements IRoutineExerciseService {

    private final IRoutineExerciseRepository routineExerciseRepository;

    @Override
    public List<RoutineExercise> findAll() {
        return routineExerciseRepository.findAll();
    }

    @Override
    public Optional<RoutineExercise> findById(Integer id) {
        return routineExerciseRepository.findById(id);
    }

    @Override
    public RoutineExercise save(RoutineExercise routineExercise) {
        return routineExerciseRepository.save(routineExercise);
    }

    @Override
    public void deleteById(Integer id) {
        routineExerciseRepository.deleteById(id);
    }

    @Override
    public List<RoutineExercise> findByRoutineId(int routineId) {
        return routineExerciseRepository.findByRoutineId(routineId);
    }

    @Override
    public List<RoutineExercise> findByExerciseId(int exerciseId) {
        return routineExerciseRepository.findByExerciseId(exerciseId);
    }
}

package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.ActivityExercise;
import com.example.demo.repository.IActivityExerciseRepository;
import com.example.demo.service.IActivityExerciseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityExerciseServiceImpl implements IActivityExerciseService {

    private final IActivityExerciseRepository activityExerciseRepository;

    @Override
    public List<ActivityExercise> findAll() {
        return activityExerciseRepository.findAll();
    }

    @Override
    public Optional<ActivityExercise> findById(Integer id) {
        return activityExerciseRepository.findById(id);
    }

    @Override
    public ActivityExercise save(ActivityExercise activityExercise) {
        return activityExerciseRepository.save(activityExercise);
    }

    @Override
    public void deleteById(Integer id) {
        activityExerciseRepository.deleteById(id);
    }

    @Override
    public List<ActivityExercise> findByActivityLogId(Integer activityLogId) {
        return activityExerciseRepository.findByActivityLogId(activityLogId);
    }

    @Override
    public List<ActivityExercise> findByRoutineExerciseId(Integer routineExerciseId) {
        return activityExerciseRepository.findByRoutineExerciseId(routineExerciseId);
    }
}

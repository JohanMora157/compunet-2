package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.ActivityExercise;

public interface IActivityExerciseService {
    List<ActivityExercise> findAll();
    Optional<ActivityExercise> findById(Integer id);
    ActivityExercise save(ActivityExercise activityExercise);
    void deleteById(Integer id);
    List<ActivityExercise> findByActivityLogId(Integer activityLogId);
    List<ActivityExercise> findByRoutineExerciseId(Integer routineExerciseId);
}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ActivityExercise;

@Repository
public interface IActivityExerciseRepository extends JpaRepository<ActivityExercise, Integer> {
    List<ActivityExercise> findByActivityLogId(Integer activityLogId);
    List<ActivityExercise> findByRoutineExerciseId(Integer routineExerciseId);
}

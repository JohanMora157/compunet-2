package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.ActivityLog;

public interface IActivityLogService {
    List<ActivityLog> findAll();
    Optional<ActivityLog> findById(Integer id);
    ActivityLog save(ActivityLog activityLog);
    void deleteById(Integer id);
    List<ActivityLog> findByUserId(Integer userId);
    List<ActivityLog> findByRoutineId(Integer routineId);
}

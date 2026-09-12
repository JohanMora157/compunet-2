package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.ActivityLog;
import com.example.demo.repository.IActivityLogRepository;
import com.example.demo.service.IActivityLogService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements IActivityLogService {

    private final IActivityLogRepository activityLogRepository;

    @Override
    public List<ActivityLog> findAll() {
        return activityLogRepository.findAll();
    }

    @Override
    public Optional<ActivityLog> findById(Integer id) {
        return activityLogRepository.findById(id);
    }

    @Override
    public ActivityLog save(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    @Override
    public void deleteById(Integer id) {
        activityLogRepository.deleteById(id);
    }

    @Override
    public List<ActivityLog> findByUserId(Integer userId) {
        return activityLogRepository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> findByRoutineId(Integer routineId) {
        return activityLogRepository.findByRoutineId(routineId);
    }
}

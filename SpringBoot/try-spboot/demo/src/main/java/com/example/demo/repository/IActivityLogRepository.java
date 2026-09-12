package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ActivityLog;

@Repository
public interface IActivityLogRepository extends JpaRepository<ActivityLog, Integer> {
    List<ActivityLog> findByUserId(Integer userId);
    List<ActivityLog> findByRoutineId(Integer routineId);
}

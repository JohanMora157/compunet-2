package com.example.demo.repository;

import com.example.demo.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActivityLogRepository extends JpaRepository<ActivityLog, Integer> {
}

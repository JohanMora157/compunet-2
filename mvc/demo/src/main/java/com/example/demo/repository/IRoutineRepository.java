package com.example.demo.repository;

import com.example.demo.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoutineRepository extends JpaRepository<Routine, Integer> {
}

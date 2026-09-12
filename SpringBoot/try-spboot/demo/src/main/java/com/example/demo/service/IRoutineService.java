package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Routine;

public interface IRoutineService {
    List<Routine> findAll();
    Optional<Routine> findById(Integer id);
    Routine save(Routine routine);
    void deleteById(Integer id);
    List<Routine> findByUserId(int userId);
}

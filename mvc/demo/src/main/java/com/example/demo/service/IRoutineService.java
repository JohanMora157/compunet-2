package com.example.demo.service;

import com.example.demo.model.Routine;

import java.util.List;
import java.util.Optional;

public interface IRoutineService {
    Routine create(Routine routine, Integer userId);
    Routine create(Routine routine);
    List<Routine> findAll();
    Optional<Routine> findById(Integer id);
    Routine update(Integer id, Routine routine, Integer userId);
    void deleteById(Integer id);
}

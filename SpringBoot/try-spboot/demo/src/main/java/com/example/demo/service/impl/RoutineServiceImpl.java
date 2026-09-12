package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Routine;
import com.example.demo.repository.IRoutineRepository;
import com.example.demo.service.IRoutineService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements IRoutineService {

    private final IRoutineRepository routineRepository;

    @Override
    public List<Routine> findAll() {
        return routineRepository.findAll();
    }

    @Override
    public Optional<Routine> findById(Integer id) {
        return routineRepository.findById(id);
    }

    @Override
    public Routine save(Routine routine) {
        return routineRepository.save(routine);
    }

    @Override
    public void deleteById(Integer id) {
        routineRepository.deleteById(id);
    }

    @Override
    public List<Routine> findByUserId(int userId) {
        return routineRepository.findByUserId(userId);
    }
}

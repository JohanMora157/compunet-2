package com.example.demo.service.impl;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Routine;
import com.example.demo.model.User;
import com.example.demo.repository.IRoutineRepository;
import com.example.demo.service.IRoutineService;
import com.example.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements IRoutineService {

    private final IRoutineRepository routineRepository;
    private final IUserService userService;

    @Override
    public Routine create(Routine routine, Integer userId) {
        log.info("Creating routine: {} for userId: {}", routine, userId);
        if (routine == null) {
            throw new BadRequestException("Routine cannot be null");
        }
        if (routine.getName() == null || routine.getName().trim().isEmpty()) {
            throw new BadRequestException("Routine name cannot be null or empty");
        }
        if (userId != null) {
            User user = userService.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
            routine.setUser(user);
        }
        if (routine.getCreatedAt() == null) {
            routine.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
        return routineRepository.save(routine);
    }

    @Override
    public Routine create(Routine routine) {
        Integer userId = routine != null && routine.getUser() != null ? routine.getUser().getId() : null;
        return create(routine, userId);
    }

    @Override
    public List<Routine> findAll() {
        log.info("Fetching all routines");
        return routineRepository.findAll();
    }

    @Override
    public Optional<Routine> findById(Integer id) {
        log.info("Finding routine by id: {}", id);
        return routineRepository.findById(id);
    }

    @Override
    public Routine update(Integer id, Routine routine, Integer userId) {
        log.info("Updating routine id: {} with data: {}, userId: {}", id, routine, userId);
        if (id == null) {
            throw new BadRequestException("Routine id cannot be null");
        }
        if (routine == null) {
            throw new BadRequestException("Routine cannot be null");
        }

        Routine existingRoutine = routineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Routine not found with id: " + id));

        if (routine.getName() != null && !routine.getName().trim().isEmpty()) {
            existingRoutine.setName(routine.getName());
        }
        if (routine.getDescription() != null) {
            existingRoutine.setDescription(routine.getDescription());
        }
        if (userId != null) {
            User user = userService.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
            existingRoutine.setUser(user);
        }

        existingRoutine.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return routineRepository.save(existingRoutine);
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting routine by id: {}", id);
        if (id == null) {
            throw new BadRequestException("Routine id cannot be null");
        }
        if (!routineRepository.existsById(id)) {
            throw new ResourceNotFoundException("Routine not found with id: " + id);
        }
        routineRepository.deleteById(id);
    }
}

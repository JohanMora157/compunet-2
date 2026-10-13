package com.example.demo.service.impl;

import static java.rmi.server.LogStream.log;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Exercise;
import com.example.demo.repository.IExerciseRepository;
import com.example.demo.service.IExerciseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements IExerciseService {

    private final IExerciseRepository exerciseRepository;

    @Override
    public Exercise create(Exercise exercise) {
        log.info("Creating exercise: {}", exercise);
        if (exercise == null) {
            throw new BadRequestException("Exercise cannot be null");
        }
        if (exercise.getName() == null || exercise.getName().trim().isEmpty()) {
            throw new BadRequestException("Exercise name cannot be null or empty");
        }
        if (exercise.getEstimatedDurationMin() != null && exercise.getEstimatedDurationMin() < 0) {
            throw new BadRequestException("Estimated duration cannot be negative");
        }
        if (exercise.getEstimatedCalories() != null && exercise.getEstimatedCalories() < 0) {
            throw new BadRequestException("Estimated calories cannot be negative");
        }
        if (exercise.getEstimatedDistanceKm() != null && exercise.getEstimatedDistanceKm() < 0) {
            throw new BadRequestException("Estimated distance cannot be negative");
        }
        if (exercise.getCreatedAt() == null) {
            exercise.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
        return exerciseRepository.save(exercise);
    }

    @Override
    public List<Exercise> findAll() {
        log.info("Fetching all exercises");
        return exerciseRepository.findAll();
    }

    @Override
    public Optional<Exercise> findById(Integer id) {
        log.info("Finding exercise by id: {}", id);
        return exerciseRepository.findById(id);
    }

    @Override
    public Exercise update(Integer id, Exercise exercise) {
        log.info("Updating exercise id: {} with data: {}", id, exercise);
        if (id == null) {
            throw new BadRequestException("Exercise id cannot be null");
        }
        if (exercise == null) {
            throw new BadRequestException("Exercise cannot be null");
        }

        Exercise existingExercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found with id: " + id));

        if (exercise.getName() != null && !exercise.getName().trim().isEmpty()) {
            existingExercise.setName(exercise.getName());
        }
        if (exercise.getDescription() != null) {
            existingExercise.setDescription(exercise.getDescription());
        }
        if (exercise.getType() != null) {
            existingExercise.setType(exercise.getType());
        }
        if (exercise.getEstimatedCalories() != null) {
            if (exercise.getEstimatedCalories() < 0) {
                throw new BadRequestException("Estimated calories cannot be negative");
            }
            existingExercise.setEstimatedCalories(exercise.getEstimatedCalories());
        }
        if (exercise.getEstimatedDistanceKm() != null) {
            if (exercise.getEstimatedDistanceKm() < 0) {
                throw new BadRequestException("Estimated distance cannot be negative");
            }
            existingExercise.setEstimatedDistanceKm(exercise.getEstimatedDistanceKm());
        }
        if (exercise.getEstimatedDurationMin() != null) {
            if (exercise.getEstimatedDurationMin() < 0) {
                throw new BadRequestException("Estimated duration cannot be negative");
            }
            existingExercise.setEstimatedDurationMin(exercise.getEstimatedDurationMin());
        }
        if (exercise.getIcon() != null) {
            existingExercise.setIcon(exercise.getIcon());
        }

        return exerciseRepository.save(existingExercise);
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting exercise by id: {}", id);
        if (id == null) {
            throw new BadRequestException("Exercise id cannot be null");
        }
        if (!exerciseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Exercise not found with id: " + id);
        }
        exerciseRepository.deleteById(id);
    }
}

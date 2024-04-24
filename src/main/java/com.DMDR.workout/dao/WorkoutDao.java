package com.DMDR.workout.dao;

import com.DMDR.workout.model.Person;
import com.DMDR.workout.model.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutDao {

    int insertWorkout(UUID id, Workout workout);

    default int insertWorkout(Workout workout) {
        UUID id = UUID.randomUUID();
        return insertWorkout(id, workout);
    }
    List<Workout> selectWorkouts();

    Optional<Workout> selectWorkoutById(UUID id);

    int deleteWorkoutById(UUID id);

}

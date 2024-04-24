package com.DMDR.workout.dao;


import com.DMDR.workout.model.Workout;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository()
public class WorkoutDaoImpl implements WorkoutDao{

    private static List<Workout> workouts = new ArrayList<>();

    @Override
    public int insertWorkout(UUID id, Workout workout) {
        workouts.add(new Workout(id, workout.getTitle(), workout.getImgUrl(), workout.getIntensity(), workout.getTime(), workout.getBodyTarget()));
        return 1;
    }

    @Override
    public int insertWorkout(Workout workout) {
        return WorkoutDao.super.insertWorkout(workout);
    }

    @Override
    public List<Workout> selectWorkouts() {
        return workouts;
    }


    @Override
    public Optional<Workout> selectWorkoutById(UUID id) {
        return workouts.stream()
                .filter(workout -> workout.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteWorkoutById(UUID id) {
        Optional<Workout> workout = selectWorkoutById(id);
        if (workout.isEmpty()) {
            return 0;
        }
        workouts.remove(workout.get());
        return 1;
    }
}

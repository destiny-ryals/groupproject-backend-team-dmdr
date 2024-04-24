package com.DMDR.workout.dao;

import com.DMDR.workout.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkoutService {

    private final WorkoutDao workoutDao;

    @Autowired
    public WorkoutService(WorkoutDao workoutDao){
        this.workoutDao = workoutDao;
    }

    public List<Workout> getAllWorkouts(){
        return workoutDao.selectWorkouts();
    }

    public int addWorkout(Workout workout){
        return workoutDao.insertWorkout(workout);
    }

    public Optional<Workout> getWorkoutById(UUID id){
        return workoutDao.selectWorkoutById(id);
    }

    public int deleteWorkout(UUID id) {

        return workoutDao.deleteWorkoutById(id);
    }




}

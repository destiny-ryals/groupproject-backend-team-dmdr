package com.DMDR.workout.api;

import com.DMDR.workout.service.WorkoutService;
import com.DMDR.workout.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/workout")
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout) {
        int savedWorkout = workoutService.addWorkout(workout);
        if (savedWorkout == 1){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }}

    @GetMapping
    public List<Workout> getAllWorkouts(){
        return workoutService.getAllWorkouts();
    }
    public Workout getWorkoutById(@PathVariable("id") UUID id){
        return workoutService.getWorkoutById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWorkoutById(@PathVariable("id") UUID id) {
        workoutService.deleteWorkout(id);
    }

}

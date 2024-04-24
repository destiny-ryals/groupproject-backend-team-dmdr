package com.DMDR.workout.api;

import com.DMDR.workout.dao.GoalService;
import com.DMDR.workout.model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/goals")
public class GoalController {
    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }

    @GetMapping
    public List<Goal> getAllGoals(){
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public Goal getGoalById(@PathVariable UUID id) {
        return goalService.getGoalById(id);
    }

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.createGoal(goal);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable UUID id) {
        goalService.deleteGoal(id);
    }
}

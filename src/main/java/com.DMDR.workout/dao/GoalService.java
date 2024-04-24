package com.DMDR.workout.dao;

import com.DMDR.workout.model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GoalService {
    private final GoalDao goalDao;

    @Autowired
    public GoalService(GoalDao goalDao){
        this.goalDao = goalDao;
    }

    public List<Goal> getAllGoals(){
        return goalDao.findAll();
    }

    public Goal getGoalById(UUID id){
        return goalDao.findById(id).orElse(null);
    }

    public Goal createGoal(Goal goal){
        return goalDao.save(goal);
    }

    public void deleteGoal(UUID id){
        goalDao.deleteById(id);
    }
}

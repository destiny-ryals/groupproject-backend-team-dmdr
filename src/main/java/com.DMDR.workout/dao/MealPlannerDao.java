package com.DMDR.workout.dao;

import com.DMDR.workout.model.MealPlanner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MealPlannerDao {

    int insertMealPlan(UUID mealId, MealPlanner mealPlanner);

    default int insertMealPlan(MealPlanner mealPlanner) {
        UUID mealId = UUID.randomUUID();
        return insertMealPlan(mealId, mealPlanner);
    }

    List<MealPlanner> selectAllMealPlans();

    Optional<MealPlanner> selectMealPlanById(UUID mealId);

    int deleteMealPlanById(UUID mealId);

    int updateMealPlanById(UUID mealId, MealPlanner mealPlanner);
}

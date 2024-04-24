package com.DMDR.workout.service;

import com.DMDR.workout.dao.MealPlannerDao;
import com.DMDR.workout.model.MealPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MealPlannerService {
    private final MealPlannerDao mealPlannerDao;

    @Autowired
    public MealPlannerService(@Qualifier("fakeDaoMeal") MealPlannerDao mealPlannerDao) {
        this.mealPlannerDao = mealPlannerDao;
    }

    public int addMealPlan(MealPlanner mealPlanner) {
        return mealPlannerDao.insertMealPlan(mealPlanner);
    }

    public List<MealPlanner> getAllMealPlans() {
        return mealPlannerDao.selectAllMealPlans();
    }

    public Optional<MealPlanner> getMealPlanById(UUID mealId) {
        return mealPlannerDao.selectMealPlanById(mealId);
    }

    public int deleteMealPlan(UUID mealId) {
        return mealPlannerDao.deleteMealPlanById(mealId);
    }

    public int updateMealPlan(UUID mealId, MealPlanner newPerson) {
        return mealPlannerDao.updateMealPlanById(mealId, newPerson);
    }
}

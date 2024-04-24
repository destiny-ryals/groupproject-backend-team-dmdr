package com.DMDR.workout.dao;

import com.DMDR.workout.model.MealPlanner;
import com.DMDR.workout.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDaoMeal")
public class MealAccessDataService implements MealPlannerDao {

    private static List<MealPlanner> mealDB = new ArrayList<>();

    @Override
    public int insertMealPlan(UUID mealId, MealPlanner mealPlanner) {
        mealDB.add(new MealPlanner( mealPlanner.getName()));
        return 1;
    }

    @Override
    public List<MealPlanner> selectAllMealPlans() {
        return mealDB;
    }

    @Override
    public Optional<MealPlanner> selectMealPlanById(UUID mealId) {
        return mealDB.stream()
                .filter(mealPlan -> mealPlan.getId().equals(mealId))
                .findFirst();
    }

    @Override
    public int deleteMealPlanById(UUID mealId) {
        Optional<MealPlanner> mealMaybe = selectMealPlanById(mealId);
        if (mealMaybe.isEmpty()) {
            return 0;
        }
        mealDB.remove(mealMaybe.get());
        return 1;
    }

    @Override
    public int updateMealPlanById(UUID mealId, MealPlanner mealPlanner) {
        return selectMealPlanById(mealId)
                .map(mealPlan -> {
                    int indexOfPersonToUpdate = mealDB.indexOf(mealPlan);
                    if (indexOfPersonToUpdate >= 0) {
                        mealDB.set(indexOfPersonToUpdate, new MealPlanner( mealPlanner.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}

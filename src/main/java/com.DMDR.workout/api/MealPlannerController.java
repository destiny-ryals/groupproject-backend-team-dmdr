package com.DMDR.workout.api;

import com.DMDR.workout.model.MealPlanner;
import com.DMDR.workout.service.MealPlannerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/MealPlanner")
@RestController
public class MealPlannerController {

    private final MealPlannerService mealPlannerService;

    @Autowired
    public MealPlannerController(MealPlannerService mealPlannerService) {
        this.mealPlannerService = mealPlannerService;
    }

    @PostMapping
    public void addMealPlan(@Valid @NonNull @RequestBody MealPlanner mealPlanner) {
        mealPlannerService.addMealPlan(mealPlanner);
    }

    @GetMapping
    public List<MealPlanner> getAllMealPlans() {
        return mealPlannerService.getAllMealPlans();
    }

    @GetMapping(path = "{id}")
    public MealPlanner getMealPlanById(@PathVariable("id") UUID id) {
        return mealPlannerService.getMealPlanById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMealPLan(@PathVariable("id") UUID id) {
        mealPlannerService.deleteMealPlan(id);
    }

    @PutMapping(path = "{id}")
    public void updateMealPlan(@PathVariable("id") UUID id, @RequestBody MealPlanner mealPlanToUpdate) {
        mealPlannerService.updateMealPlan(id, mealPlanToUpdate);
    }
}
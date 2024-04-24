package com.DMDR.workout.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MealPlanner {


    private final UUID id;
    @NotBlank
    private final String name;

    private final List<Meal> meals = new ArrayList<>();

    public MealPlanner( @JsonProperty("name") String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public List<Meal> getMeals() {
        return meals;
    }
}

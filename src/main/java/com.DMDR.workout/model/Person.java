package com.DMDR.workout.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Person {

    private final UUID id;
    @NotBlank
    private final String name;

    private final List<MealPlanner> meals = new ArrayList<>();

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MealPlanner> getMeals() {
        return meals;
    }

    /*@OneToMany(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Goal> goals;*/
}

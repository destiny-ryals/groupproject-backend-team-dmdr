package com.DMDR.workout.model;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private final String title;

    private final String[] content;

    private final List<Food> contentNested = new ArrayList<>();

    private final Number calories;

    private final String type;


    public Meal(String title, String[] content, List<Food> contentNested, Number calories, String type) {
        this.title = title;
        this.content = content;
        this.calories = calories;
        this.type = type;
    }
}

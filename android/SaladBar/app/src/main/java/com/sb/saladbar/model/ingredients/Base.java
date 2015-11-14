package com.sb.saladbar.model.ingredients;

/**
 * Created by G on 11/13/15.
 */
public enum Base implements Ingredient {

    CHOPPED_ROMAINE("chopped romaine", .10, 25),
    ORGANIC_ARUGULA("organic arugula", .20, 25),
    ORGANIC_BABY_SPINACH("organic baby spinach", .30, 25),
    ORGANIC_MESCLUN("organic mesclun", .40, 25),
    ORGANIC_WILD_RICE("organic wild rice", .50, 130),
    SHREDDED_KALE("shredded kale", .60, 40),
    WARM_QUINOA_AND_FARRO("warm quinoa and farro", .70, 160);


    private String name;
    private double cost;
    private int calories;

    private Base(String name, double cost, int calories) {
        this.name = name;
        this.cost = cost;
        this.calories = calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}

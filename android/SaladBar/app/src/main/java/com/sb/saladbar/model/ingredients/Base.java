package com.sb.saladbar.model.ingredients;

/**
 * Created by G on 11/13/15.
 */
public enum Base implements Ingredient {

    CHOPPED_ROMAINE("chopped romaine", .25, 100),
    ORGANIC_MESCLUN("organic mesclun", .25, 100),
    ORGANIC_WILD_RICE("organic wild rice", 25, 100);

    private String name;
    private double price;
    private int calories;

    private Base(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}

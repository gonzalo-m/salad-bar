package com.sb.saladbar.model.ingredients;

/**
 * Created by G on 11/13/15.
 */
public enum Premium implements Ingredient {

    ROASTED_TURKEY("roasted turkey", 25, 100),
    ROASTED_CURRY_CAULIFLOWER("roasted curry cauliflower", .25, 100),
    LOCAL_GOAT_CHEESE("local goat cheese", .25, 100);

    private String name;
    private double price;
    private int calories;

    Premium(String name, double price, int calories) {
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
package com.sb.saladbar.model.ingredients;

/**
 * Created by G on 11/13/15.
 */
public enum Dressing implements Ingredient {

    CRANBERRY_VINAGREITTE("cranberry vinaigrette", 25, 100),
    SPICY_CASHEW_DRESSING("spicy cashew dressing", .25, 100),
    BLUE_CHEESE_DRESSING("blue cheese dressing", .25, 100);

    private String name;
    private double price;
    private int calories;

    Dressing(String name, double price, int calories) {
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
package com.sb.saladbar.model.ingredients;

/**
 * Created by G on 11/13/15.
 */
public enum Topping implements Ingredient {

    ROASTED_BRUSSEL_SPROUTS("roasted brussels sprouts", 25, 100),
    ROASTED_SWEET_POTATOES("roasted sweet potatoes", .25, 100),
    PEARS("pears", .25, 100);

    private String name;
    private double price;
    private int calories;

    private Topping(String name, double price, int calories) {
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
package com.sb.saladbar.model.ingredients;

/**
 * Created by G on 11/13/15.
 */
public enum Topping implements Ingredient {


    APPLE("apple", .25, 15),
    BASIL("basil", .25, 0),
    CILANTRO("cilantro", .25, 0),
    CUCUMBER("cucumber", .25, 0),
    ORGANIC_CARROT("organic carrot", .25, 10),
    ORGANIC_CHICKPEAS("organic chickpeas", .25, 50),
    PITA_CHIPS("pita chips", .25, 90),
    RAISINS("raisins", .25, 40),
    RAW_BEET("raw beet", .25, 15),
    RAW_CORN("raw corn", .25, 30),
    RAW_PECANS("raw pecans", .25, 100),
    RAW_SEEDS("raw seeds", .25, 80),
    RED_AND_GREEN_PEPPERS("red and green peppers", .25, 10),
    RED_ONION("red onion", .25, 15),
    ROASTED_BRUSSEL_SPROUTS("roasted brussels sprouts", 25, 50),
    ROASTED_SWEET_POTATO("roasted sweet potato", .25, 70),
    SHREDDED_CABBAGE("shredded cabbage", .25, 5),
    SPICY_BROCCOLI("spicy broccoli", .25, 50),
    SPICY_QUINOA("spicy quinoa", .25, 50),
    SPICY_SUNFLOWER_SEEDS("spicy sunflower seeds", .25, 70),
    SPROUTS("sprouts", .25, 5),
    TOASTED_ALMONDS("toasted almonds", .25, 80),
    TOMATO("tomato", .25, 10),
    TORTILLA_CHIPS("tortilla chips", .25, 80),
    PEARS("pears", .25, 15);

    private String name;
    private double cost;
    private int calories;

    private Topping(String name, double cost, int calories) {
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
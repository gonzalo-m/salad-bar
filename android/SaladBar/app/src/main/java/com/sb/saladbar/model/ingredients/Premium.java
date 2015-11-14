package com.sb.saladbar.model.ingredients;

/**
 * Created by G on 11/13/15.
 */
public enum Premium implements Ingredient {

    AVOCADO("avocado", .25, 140),
    BACON("bacon", .25, 170),
    BAKED_FALAFEL("baked falafel", .25, 180),
    CITRUS_SHRIMP("citrus shrimp",.25, 140),
    FEAT_CHEESE("feta cheese", .25, 80),
    HARD_BOILED_EGG("hard boiled egg", .25, 80),
    HOUSEMADE_HUMMUS("housemade calories", .25, 90),
    GOAT_CHEESE("goat cheese", .25, 80),
    ORGANIC_WHITE_CHEDDAR("organic white cheddar", .25, 130),
    PARMESAN_CRISP("parmesan crisp", .25, 100),
    ROASTED_CURRY_CAULIFLOWER("roasted curry cauliflower", .25, 30),
    ROASTED_ORGANIC_TOFU("roasted organic tofu", .25, 100),
    ROASTED_CHICKEN("roasted chicken", 25, 140),
    ROASTED_TURKEY("roasted turkey", 25, 110),
    SHAVED_PARMESAN("shaved parmesan", .25, 45);

    private String name;
    private double cost;
    private int calories;

    Premium(String name, double cost, int calories) {
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
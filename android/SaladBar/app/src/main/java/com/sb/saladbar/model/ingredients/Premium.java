package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

/**
 * Created by G on 11/13/15.
 */
public enum Premium implements Ingredient {

    AVOCADO("Avocado", .25, 140, R.drawable.premium_avocado),
    BACON("Bacon", .25, 170, R.drawable.premium_bacon),
    GOAT_CHEESE("Goat Cheese", .25, 80, R.drawable.premium_goat_cheese),
    HARD_BOILED_EGG("Egg", .25, 80, R.drawable.premium_hard_boiled_egg),
    HOUSEMADE_HUMMUS("Hummus", .25, 90, R.drawable.premium_housemade_hummus),
    ORGANIC_WHITE_CHEDDAR("White Cheddar", .25, 130, R.drawable.premium_organic_white_cheddar),
    ROASTED_CHICKEN("Chicken", 25, 140, R.drawable.premium_roasted_chicken),
    ROASTED_CURRY_CAULIFLOWER("Cauliflower", .25, 30, R.drawable.premium_roasted_curry_cauliflower),
    SHAVED_PARMESAN("Parmesan", .25, 45, R.drawable.premium_shaved_parmesan);


    private String name;
    private double cost;
    private int calories;
    private int resId;

    Premium(String name, double cost, int calories, int resId) {
        this.name = name;
        this.cost = cost;
        this.calories = calories;
        this.resId = resId;
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

    @Override
    public int getResId() {
        return resId;
    }


}
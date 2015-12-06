package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

/**
 * Created by G on 11/13/15.
 */
public enum Premium implements Ingredient {

    HOUSEMADE_HUMMUS("Hummus", 2.25, 90, R.drawable.premium_housemade_hummus, R.drawable.hummus_layer),
    BACON("Bacon", 2.00, 170, R.drawable.premium_bacon, R.drawable.bacon_layer),
    ROASTED_CHICKEN("Chicken", 2.50, 140, R.drawable.premium_roasted_chicken, R.drawable.chicken_layer),
    HARD_BOILED_EGG("Egg", 2.00, 80, R.drawable.premium_hard_boiled_egg, R.drawable.egg_layer),
    AVOCADO("Avocado", 2.25, 140, R.drawable.premium_avocado, R.drawable.avocado_layer2),
    GOAT_CHEESE("Goat Cheese", 1.75, 80, R.drawable.premium_goat_cheese, R.drawable.premium_goat_cheese_layer),
    ORGANIC_WHITE_CHEDDAR("White Cheddar", 1.75, 130, R.drawable.premium_organic_white_cheddar, R.drawable.cheddar_layer),
    ROASTED_CURRY_CAULIFLOWER("Cauliflower", 2.25, 30, R.drawable.premium_roasted_curry_cauliflower, R.drawable.premium_roasted_curry_cauliflower_layer),
    SHAVED_PARMESAN("Parmesan", 1.75, 45, R.drawable.premium_shaved_parmesan, R.drawable.parmesan_layer);


    private String name;
    private double cost;
    private int calories;
    private int resId;
    private int layerId;

    Premium(String name, double cost, int calories, int resId, int layerId) {
        this.name = name;
        this.cost = cost;
        this.calories = calories;
        this.resId = resId;
        this.layerId = layerId;
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

    @Override
    public int getLayerId() { return layerId; }


}
package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

/**
 * Created by G on 11/13/15.
 */
public enum Premium implements Ingredient {

    AVOCADO("avocado", .25, 140, R.drawable.premium_avocado),
    BACON("bacon", .25, 170, R.drawable.premium_bacon),
//    BAKED_FALAFEL("baked falafel", .25, 180),
//    CITRUS_SHRIMP("citrus shrimp",.25, 140),
//    FETA_CHEESE("feta cheese", .25, 80),
    HARD_BOILED_EGG("hard boiled egg", .25, 80, R.drawable.premium_hard_boiled_egg),
    HOUSEMADE_HUMMUS("housemade calories", .25, 90, R.drawable.premium_housemade_hummus),
    GOAT_CHEESE("goat cheese", .25, 80, R.drawable.premium_goat_cheese),
    ORGANIC_WHITE_CHEDDAR("organic white cheddar", .25, 130, R.drawable.premium_organic_white_cheddar),
//    PARMESAN_CRISP("parmesan crisp", .25, 100),
    ROASTED_CURRY_CAULIFLOWER("roasted curry cauliflower", .25, 30, R.drawable.premium_roasted_curry_cauliflower),
//    ROASTED_ORGANIC_TOFU("roasted organic tofu", .25, 100),
    ROASTED_CHICKEN("roasted chicken", 25, 140, R.drawable.premium_roasted_chicken),
//    ROASTED_TURKEY("roasted turkey", 25, 110),
    SHAVED_PARMESAN("shaved parmesan", .25, 45, R.drawable.premium_shaved_parmesan);


    private String name;
    private double cost;
    private int calories;
    private int resId;

    Premium(String name, double cost, int calories, int resId) {
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

    @Override
    public int getResId() {
        return resId;
    }


}
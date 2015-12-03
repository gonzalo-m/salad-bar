package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

/**
 * Created by G on 11/13/15.
 */
public enum Topping implements Ingredient {


    APPLE("Apple", .75, 15, R.drawable.topping_apples),
    BASIL("Basil", .25, 0, R.drawable.topping_basil),
    CILANTRO("Cilantro", .25, 0, R.drawable.topping_cilantro),
    CUCUMBER("Cucumber", .25, 0, R.drawable.topping_cucumber),
    ORGANIC_CARROT("Carrot", .25, 10, R.drawable.topping_organic_carrot),
    ORGANIC_CHICKPEAS("Chickpeas", .25, 50, R.drawable.topping_organic_chickpeas),
    PEARS("Pears", .75, 15, R.drawable.topping_pear),
    PEPPERS("Peppers", .25, 15, R.drawable.topping_peppers),
    PITA_CHIPS("Pita Chips", .50, 90, R.drawable.topping_pita_chip),
    RAISINS("Raisins", .25, 40, R.drawable.topping_raisins),
    RAW_BEET("Beet", .25, 15, R.drawable.topping_raw_beet),
    RAW_CORN("Corn", .25, 30, R.drawable.topping_raw_corn),
    RAW_PECANS("Pecans", .75, 100, R.drawable.topping_raw_pecan),
    RAW_SEEDS("Seeds", .25, 80, R.drawable.topping_raw_seeds),
    RED_ONION("Red Onion", .25, 15, R.drawable.topping_red_onion),
    ROASTED_BRUSSEL_SPROUTS("Brussel Sprouts", .25, 50, R.drawable.topping_roasted_brussel_sprouts),
    ROASTED_SWEET_POTATO("Sweet Potato", .75, 70, R.drawable.topping_roasted_sweet_potato),
    SHREDDED_CABBAGE("Cabbage", .25, 5, R.drawable.topping_shredded_cabbage),
    SPICY_BROCCOLI("Broccoli", .25, 50, R.drawable.topping_spicy_broccoli),
    SPICY_QUINOA("Quinoa", .75, 50, R.drawable.topping_spicy_quinoa),
    SPROUTS("Sprouts", .25, 5, R.drawable.topping_sprouts),
    SPICY_SUNFLOWER_SEEDS("Sunflower Seeds", .25, 70, R.drawable.topping_sunflower_seeds),
    TOASTED_ALMONDS("Almonds", .75, 80, R.drawable.topping_toasted_almonds),
    TOMATO("Tomato", .25, 10, R.drawable.topping_tomato),
    TORTILLA_CHIPS("Tortilla Chips", .25, 80, R.drawable.topping_tortilla_chips);

    private String name;
    private double cost;
    private int calories;
    private int resId;

    private Topping(String name, double cost, int calories, int resId) {
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
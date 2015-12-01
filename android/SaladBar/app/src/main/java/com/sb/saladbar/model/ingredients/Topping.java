package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

/**
 * Created by G on 11/13/15.
 */
public enum Topping implements Ingredient {


    APPLE("apple", .25, 15, R.drawable.topping_apples),
    BASIL("basil", .25, 0, R.drawable.topping_basil),
    CILANTRO("cilantro", .25, 0, R.drawable.topping_cilantro),
    CUCUMBER("cucumber", .25, 0, R.drawable.topping_cucumber),
    ORGANIC_CARROT("organic carrot", .25, 10, R.drawable.topping_organic_carrot),
    ORGANIC_CHICKPEAS("organic chickpeas", .25, 50, R.drawable.topping_organic_chickpeas),
    PEARS("pears", .25, 15, R.drawable.topping_pear),
    PITA_CHIPS("pita chips", .25, 90, R.drawable.topping_pita_chip),
    RAISINS("raisins", .25, 40, R.drawable.topping_raisins),
    RAW_BEET("raw beet", .25, 15, R.drawable.topping_raw_beet),
    RAW_CORN("raw corn", .25, 30, R.drawable.topping_raw_corn),
    RAW_PECANS("raw pecans", .25, 100, R.drawable.topping_raw_pecan),
    RAW_SEEDS("raw seeds", .25, 80, R.drawable.topping_raw_seeds),
    RED_AND_GREEN_PEPPERS("red and green peppers", .25, 10, R.drawable.topping_peppers),
    RED_ONION("red onion", .25, 15, R.drawable.topping_red_onion),
    ROASTED_BRUSSEL_SPROUTS("roasted brussels sprouts", 25, 50, R.drawable.topping_roasted_brussel_sprouts),
    ROASTED_SWEET_POTATO("roasted sweet potato", .25, 70, R.drawable.topping_roasted_sweet_potato),
    SHREDDED_CABBAGE("shredded cabbage", .25, 5, R.drawable.topping_shredded_cabbage),
    SPICY_BROCCOLI("spicy broccoli", .25, 50, R.drawable.topping_spicy_broccoli),
    SPICY_QUINOA("spicy quinoa", .25, 50, R.drawable.topping_spicy_quinoa),
    SPICY_SUNFLOWER_SEEDS("spicy sunflower seeds", .25, 70, R.drawable.topping_sunflower_seeds),
    SPROUTS("sprouts", .25, 5, R.drawable.topping_sprouts),
    TOASTED_ALMONDS("toasted almonds", .25, 80, R.drawable.topping_toasted_almonds),
    TOMATO("tomato", .25, 10, R.drawable.topping_tomato),
    TORTILLA_CHIPS("tortilla chips", .25, 80, R.drawable.topping_tortilla_chips);

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
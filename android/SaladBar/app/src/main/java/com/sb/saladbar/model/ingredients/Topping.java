package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

/**
 * Created by G on 11/13/15.
 */
public enum Topping implements Ingredient {


    TOMATO("Tomato", .25, 10, R.drawable.topping_tomato, R.drawable.tomato_layer),
    APPLE("Apple", .75, 15, R.drawable.topping_apples, R.drawable.apple_chips_layer),
    BASIL("Basil", .25, 0, R.drawable.topping_basil, R.drawable.topping_basil_layer),
    CUCUMBER("Cucumber", .25, 0, R.drawable.topping_cucumber, R.drawable.cucumber_layer),
    ORGANIC_CARROT("Carrot", .25, 10, R.drawable.topping_organic_carrot, R.drawable.topping_organic_carrot_layer),
    ORGANIC_CHICKPEAS("Chickpeas", .25, 50, R.drawable.topping_organic_chickpeas, R.drawable.topping_organic_chickpeas_layer),
    PEARS("Pears", .75, 15, R.drawable.topping_pear, R.drawable.topping_pear_layer),
    PEPPERS("Peppers", .25, 15, R.drawable.topping_peppers, R.drawable.topping_peppers_layer),
    PITA_CHIPS("Pita Chips", .50, 90, R.drawable.topping_pita_chip, R.drawable.topping_pita_chip_layer),
    CILANTRO("Cilantro", .25, 0, R.drawable.topping_cilantro, R.drawable.cilantro_layer),
    RAISINS("Raisins", .25, 40, R.drawable.topping_raisins, R.drawable.topping_raisins_layer),
    RAW_BEET("Beet", .25, 15, R.drawable.topping_raw_beet, R.drawable.topping_raw_beet_layer),
    RAW_CORN("Corn", .25, 30, R.drawable.topping_raw_corn, R.drawable.topping_raw_corn_layer),
    RAW_PECANS("Pecans", .75, 100, R.drawable.topping_raw_pecan, R.drawable.topping_raw_pecan_layer),
    RAW_SEEDS("Seeds", .25, 80, R.drawable.topping_raw_seeds, R.drawable.topping_raw_seeds_layer),
    RED_ONION("Red Onion", .25, 15, R.drawable.topping_red_onion, R.drawable.red_onion_layer),
    ROASTED_BRUSSEL_SPROUTS("Brussel Sprouts", .25, 50, R.drawable.topping_roasted_brussel_sprouts, R.drawable.topping_roasted_brussel_sprouts_layer),
    ROASTED_SWEET_POTATO("Sweet Potato", .75, 70, R.drawable.topping_roasted_sweet_potato, R.drawable.topping_roasted_sweet_potato_layer),
    SHREDDED_CABBAGE("Cabbage", .25, 5, R.drawable.topping_shredded_cabbage, R.drawable.topping_shredded_cabbage_layer),
    SPICY_BROCCOLI("Broccoli", .25, 50, R.drawable.topping_spicy_broccoli, R.drawable.topping_spicy_broccoli_layer),
    SPICY_QUINOA("Quinoa", .75, 50, R.drawable.topping_spicy_quinoa, R.drawable.spicy_quinoa_layer),
    SPROUTS("Sprouts", .25, 5, R.drawable.topping_sprouts, R.drawable.topping_sprouts_layer),
    SPICY_SUNFLOWER_SEEDS("Sunflower Seeds", .25, 70, R.drawable.topping_sunflower_seeds, R.drawable.topping_sunflower_seeds_layer),
    TOASTED_ALMONDS("Almonds", .75, 80, R.drawable.topping_toasted_almonds, R.drawable.almonds_layer),
    TORTILLA_CHIPS("Tortilla Chips", .25, 80, R.drawable.topping_tortilla_chips, R.drawable.topping_tortilla_chips_layer);

    private String name;
    private double cost;
    private int calories;
    private int resId;
    private int layerId;

    private Topping(String name, double cost, int calories, int resId, int layerId) {
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
package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

import java.io.Serializable;

/**
 * Created by G on 11/13/15.
 */
public enum Base implements Ingredient, Serializable {

    CHOPPED_ROMAINE("Romaine", .10, 25, R.drawable.base_chooped_romaine),
    ORGANIC_ARUGULA("Arugula", .20, 25, R.drawable.base_organic_argula),
    ORGANIC_BABY_SPINACH("Spinach", .30, 25, R.drawable.base_organic_baby_spinach),
    ORGANIC_MESCLUN("Mesculn", .40, 25, R.drawable.base_organic_mesclun),
    ORGANIC_WILD_RICE("Wild rice", .50, 130, R.drawable.base_organic_wild_rice),
    SHREDDED_KALE("Kale", .60, 40, R.drawable.base_shredded_kale),
    WARM_QUINOA_AND_FARRO("Quinoa & Farro", .70, 160, R.drawable.base_organic_quinoa_farro);


    private String name;
    private double cost;
    private int calories;
    private int resId;

    private Base(String name, double cost, int calories, int resId) {
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

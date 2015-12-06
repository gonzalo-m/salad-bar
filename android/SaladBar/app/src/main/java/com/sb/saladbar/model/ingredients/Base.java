package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

import java.io.Serializable;

/**
 * Created by G on 11/13/15.
 */
public enum Base implements Ingredient, Serializable {

    CHOPPED_ROMAINE("Romaine", 1.50, 25, R.drawable.base_chooped_romaine, R.drawable.romaine_base),
    ORGANIC_ARUGULA("Arugula", 1.50, 25, R.drawable.base_organic_argula, R.drawable.arugula_base),
    ORGANIC_BABY_SPINACH("Spinach", 1.50, 25, R.drawable.base_organic_baby_spinach, R.drawable.spinach_base),
    ORGANIC_MESCLUN("Mesculn", 1.50, 25, R.drawable.base_organic_mesclun, R.drawable.mesclun_base),
    ORGANIC_WILD_RICE("Wild rice", 1.50, 130, R.drawable.base_organic_wild_rice, R.drawable.organic_wild_rice_base),
    SHREDDED_KALE("Kale", 1.60, 40, R.drawable.base_shredded_kale, R.drawable.kale_base),
    WARM_QUINOA_AND_FARRO("Quinoa & Farro", 1.80, 160, R.drawable.base_organic_quinoa_farro, R.drawable.quinoa_base);


    private String name;
    private double cost;
    private int calories;
    private int resId;
    private int layerId;

    private Base(String name, double cost, int calories, int resId, int layerId) {
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

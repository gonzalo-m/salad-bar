package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

/**
 * Created by G on 11/13/15.
 */
public enum Dressing implements Ingredient {

    BALSAMIC_VINAIGRETTE("Balsamic Vinaigrette", .25, 150, R.drawable.dressing_balsamic_vinaigrette),
    BALSAMIC_VINEGAR("Balsamic Vinegar", .25, 15, R.drawable.dressing_balsamic_vinegar),
    BLUE_CHEESE_DRESSING("Blue Cheese Dressing", .25, 100, R.drawable.dressing_blue_cheese),
    CAESAR_DRESSING("Caesar", .25, 100, R.drawable.dressing_caesar),
    CARROT_CHILI_VINAIGRETTE("Carrot Chili Vinaigrette", .25, 150, R.drawable.dressing_carrot_chili_vinaigrette),
    CRANBERRY_VINAGREITTE("Cranberry Vinaigrette", 25, 110, R.drawable.dressing_cranberry_vinaigrette),
    CUCUMBER_TAHINI_YOGURT_DRESSING("Cucumber Tahini Yogurt Dressing", .25, 110, R.drawable.dressing_cucumber_tahini_yogurt_dressing),
    EXTRA_VIRGIN_OLIVE_OIL("Extra Virgin Olive oOil", .25, 130, R.drawable.dressing_extra_virgin_olive_oil),
    FRESH_LEMON_SQUEEZE("Fresh Lemon Squeeze", .25, 0, R.drawable.dressing_fresh_lemon_squeeze),
    FRESH_LIME_SQUEEZE("Fresh Lime Squeeze", .25, 0, R.drawable.dressing_fresh_lime_squeeze),
    LIME_CILANTRO_JALAPENO_VINAIGRETTE("Lime Cilantro Jalapeno Vinaigrette", .25, 140, R.drawable.dressing_lime_cilantro_jalapeno_vinaigrette),
    MISO_SESAME_GINGER_DRESSING("Miso Sesame Ginger Dressing", .25, 140, R.drawable.dressing_miso_sesame_ginger_dressing),
    PESTO_VINAIGRETTE("Pesto Vinaigrette", .25, 190, R.drawable.dressing_pesto_vinaigrette),
    SPICY_CASHEW_DRESSING("Spicy Cashew Dressing", .25, 120, R.drawable.dressing_spicy_cashew_dressing),
    SRIRACHA("Sriracha", .25, 15, R.drawable.dressing_sriracha);

    private String name;
    private double cost;
    private int calories;
    private int resId;

    Dressing(String name, double cost, int calories, int resId) {
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
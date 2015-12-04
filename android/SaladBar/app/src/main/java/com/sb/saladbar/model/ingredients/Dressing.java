package com.sb.saladbar.model.ingredients;

import com.sb.saladbar.R;

/**
 * Created by G on 11/13/15.
 */
public enum Dressing implements Ingredient {

    BALSAMIC_VINAIGRETTE("Balsamic Vinaigrette", .75, 150, R.drawable.dressing_balsamic_vinaigrette, R.drawable.store_icon),
    BALSAMIC_VINEGAR("Balsamic Vinegar", .75, 15, R.drawable.dressing_balsamic_vinegar, R.drawable.store_icon),
    BLUE_CHEESE_DRESSING("Blue Cheese Dressing", .25, 100, R.drawable.dressing_blue_cheese, R.drawable.store_icon),
    CAESAR_DRESSING("Caesar", .75, 100, R.drawable.dressing_caesar, R.drawable.store_icon),
    CARROT_CHILI_VINAIGRETTE("Carrot Chili Vinaigrette", .75, 150, R.drawable.dressing_carrot_chili_vinaigrette, R.drawable.store_icon),
    CRANBERRY_VINAGREITTE("Cranberry Vinaigrette", .75, 110, R.drawable.dressing_cranberry_vinaigrette, R.drawable.store_icon),
    CUCUMBER_TAHINI_YOGURT_DRESSING("Cucumber Tahini Yogurt Dressing", .75, 110, R.drawable.dressing_cucumber_tahini_yogurt_dressing, R.drawable.store_icon),
    EXTRA_VIRGIN_OLIVE_OIL("Extra Virgin Olive Oil", .75, 130, R.drawable.dressing_extra_virgin_olive_oil, R.drawable.store_icon),
    FRESH_LEMON_SQUEEZE("Fresh Lemon Squeeze", .75, 0, R.drawable.dressing_fresh_lemon_squeeze, R.drawable.store_icon),
    FRESH_LIME_SQUEEZE("Fresh Lime Squeeze", .75, 0, R.drawable.dressing_fresh_lime_squeeze, R.drawable.store_icon),
    LIME_CILANTRO_JALAPENO_VINAIGRETTE("Lime Cilantro Jalapeno Vinaigrette", .75, 140, R.drawable.dressing_lime_cilantro_jalapeno_vinaigrette, R.drawable.store_icon),
    MISO_SESAME_GINGER_DRESSING("Miso Sesame Ginger Dressing", .75, 140, R.drawable.dressing_miso_sesame_ginger_dressing, R.drawable.store_icon),
    PESTO_VINAIGRETTE("Pesto Vinaigrette", .75, 190, R.drawable.dressing_pesto_vinaigrette, R.drawable.store_icon),
    SPICY_CASHEW_DRESSING("Spicy Cashew Dressing", .75, 120, R.drawable.dressing_spicy_cashew_dressing, R.drawable.store_icon),
    SRIRACHA("Sriracha", .75, 15, R.drawable.dressing_sriracha, R.drawable.store_icon);

    private String name;
    private double cost;
    private int calories;
    private int resId;
    private int layerId;

    Dressing(String name, double cost, int calories, int resId, int layerId) {
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
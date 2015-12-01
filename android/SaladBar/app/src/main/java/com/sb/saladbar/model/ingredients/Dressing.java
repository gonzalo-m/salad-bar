package com.sb.saladbar.model.ingredients;

/**
 * Created by G on 11/13/15.
 */
public enum Dressing implements Ingredient {

    BALSAMIC_VINAIGRETTE("balsamic vinaigrette", .25, 150),
    BALSAMIC_VINEGAR("balsamic vinegar", .25, 15),
    BLUE_CHEESE_DRESSING("blue cheese dressing", .25, 100),
    CARROT_CHILI_VINAIGRETTE("carrot chili vinaigrette", .25, 150),
    CAESAR_DRESSING("caesar", .25, 100),
    CRANBERRY_VINAGREITTE("cranberry vinaigrette", 25, 110),
    CUCUMBER_TAHINI_YOGURT_DRESSING("cucumber tahini yogurt dressing", .25, 110),
    EXTRA_VIRGIN_OLIVE_OIL("extra virgin olive oil", .25, 130),
    FRESH_LEMON_SQUEEZE("fresh lemon squeeze", .25, 0),
    FRESH_LIME_SQUEEZE("fresh lime squeeze", .25, 0),
    LIME_CILANTRO_JALAPENO_VINAIGRETTE("lime cilantro jalapeno vinaigrette", .25, 140),
    MISO_SESAME_GINGER_DRESSING("miso sesame ginger dressing", .25, 140),
    PESTO_VINAIGRETTE("pesto vinaigrette", .25, 190),
    SPICY_CASHEW_DRESSING("spicy cashew dressing", .25, 120),
    SRIRACHA("sriracha", .25, 15);

    private String name;
    private double cost;
    private int calories;
    private int resId;

    Dressing(String name, double cost, int calories) { // add resid
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
        return 0;
    }


}
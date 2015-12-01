package com.sb.saladbar.model.ingredients;

import android.os.Parcelable;

/**
 * Created by G on 11/13/15.
 */
public interface Ingredient {

    String getName();
    double getCost();
    int getCalories();
    int getResId();

}

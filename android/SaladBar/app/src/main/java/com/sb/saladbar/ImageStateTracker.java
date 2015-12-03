package com.sb.saladbar;

import com.sb.saladbar.model.ingredients.Ingredient;

import java.io.Serializable;
import java.util.HashMap;

public class ImageStateTracker implements Serializable {

    public HashMap<Ingredient, Boolean> imageState = new HashMap<>();

    public void add(Ingredient ingredient, boolean enabled) {
        imageState.put(ingredient, enabled);
    }

    public boolean contains(Ingredient ingredient) {
        return imageState.containsKey(ingredient);
    }

    public boolean getImageState(Ingredient ingredient) {
        return imageState.get(ingredient);
    }

    public void clear() {
        imageState.clear();
    }

    public void remove(Ingredient ingredient) {
        imageState.remove(ingredient);
    }

    public HashMap<Ingredient, Boolean> getImageStateHashMap() {
        return imageState;
    }

}

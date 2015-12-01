package com.sb.saladbar.notused;

import com.sb.saladbar.model.ingredients.Ingredient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by G on 11/2/15.
 */
public class Salad {

    private static final int id = 0;

    private final String name;
    private final List<Ingredient> ingredientList;

    public Salad() {
        this("Custom Salad " + id);
    }

    public Salad(String name) {
        this.name = name;
        ingredientList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public double getPrice() {
        double total = 0;
        for (Ingredient item : ingredientList)
            total += item.getCost();
        return total;
    }

    public int getCalories() {
        int total = 0;
        for (Ingredient item : ingredientList)
            total += item.getCalories();
        return total;
    }

    public int add(Ingredient ingredient) {
        ingredientList.add(ingredient);
        return ingredientList.size();
    }

    public boolean contains(Ingredient ingredient) {    
        return ingredientList.contains(ingredient);
    }

    public int remove(Ingredient ingredient) {
        ingredientList.remove(ingredient);
        return ingredientList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salad otherItem = (Salad) o;

        return bothEqual(ingredientList, otherItem.ingredientList);

    }

    @Override
    public int hashCode() {
        return ingredientList.hashCode();
    }

    private static boolean bothEqual(List<Ingredient> listA, List<Ingredient> listB) {
        // a copy is needed as the reference to the list of ingredients is immutable
        List<Ingredient> listOne = new ArrayList<>(listA);
        List<Ingredient> listTwo = new ArrayList<>(listB);
//        Collections.sort(listOne);
//        Collections.sort(listTwo);
        if (listOne.size() != listTwo.size()) return false;
        for (int i = 0; i < listOne.size(); i++) {
            if (!listOne.get(i).equals(listTwo.get(i))) {
                return false;
            }
        }
        return true;
    }
}

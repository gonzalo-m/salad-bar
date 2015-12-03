package com.sb.saladbar.model;

import com.sb.saladbar.model.ingredients.Base;
import com.sb.saladbar.model.ingredients.Dressing;
import com.sb.saladbar.model.ingredients.Ingredient;
import com.sb.saladbar.model.ingredients.Premium;
import com.sb.saladbar.model.ingredients.Topping;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * Created by G on 11/14/15.
 */
public class Salad implements Serializable {

    public static final int MAX_BASE_INGREDIENTS = 1;
    public static final int MAX_TOPPING_INGREDIENTS = 5;
    public static final int MAX_PREMIUM_INGREDIENTS = 3;
    public static final int MAX_DRESSING_INGREDIENTS = 1;

    private static int id = 0;

    private final String name;
    private final TreeSet<Ingredient> baseIngredients;
    private final TreeSet<Ingredient> toppingIngredients;
    private final TreeSet<Ingredient> premiumIngredients;
    private final TreeSet<Ingredient> dressingIngredients;

    public Salad() {
        this("Custom Salad " + (id++));
    }

    public Salad(String name) {
        this.name = name;
        baseIngredients = new TreeSet<>();
        toppingIngredients = new TreeSet<>();
        premiumIngredients = new TreeSet<>();
        dressingIngredients = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public int getNumBaseIngredients() {
        return baseIngredients.size();
    }

    public int getNumToppingIngredients() {
        return toppingIngredients.size();
    }

    public int getNumPremiumIngredients() {
        return premiumIngredients.size();
    }

    public int getNumDressingIngredients() {
        return dressingIngredients.size();
    }

    public int getTotalNumIngredients() {
        return getNumBaseIngredients() + getNumToppingIngredients() + getNumPremiumIngredients() +
                getNumDressingIngredients();
    }
    public double getCost() {
        double total = 0;
        for (Ingredient item : baseIngredients)
            total += item.getCost();
        for (Ingredient item : toppingIngredients)
            total += item.getCost();
        for (Ingredient item : premiumIngredients)
            total += item.getCost();
        for (Ingredient item : dressingIngredients)
            total += item.getCost();
        return total;
    }

    public int getCalories() {
        int total = 0;
        for (Ingredient item : baseIngredients)
            total += item.getCalories();
        for (Ingredient item : toppingIngredients)
            total += item.getCalories();
        for (Ingredient item : premiumIngredients)
            total += item.getCalories();
        for (Ingredient item : dressingIngredients)
            total += item.getCalories();
        return total;
    }

    public boolean add(Ingredient ingredient) {

        if (ingredient instanceof Base) {
            if (baseIngredients.size() == MAX_BASE_INGREDIENTS)
                throw new IllegalArgumentException(
                        "You have selected the maximum amount of bases. Remove one to add another.");
            return baseIngredients.add(ingredient);

        } else if (ingredient instanceof Topping) {
            if (toppingIngredients.size() == MAX_TOPPING_INGREDIENTS)
                throw new IllegalArgumentException(
                        "You have selected the maximum amount of toppings. Remove one to add another.");
            return toppingIngredients.add(ingredient);

        } else if (ingredient instanceof Premium) {
            if (premiumIngredients.size() == MAX_PREMIUM_INGREDIENTS)
                throw new IllegalArgumentException(
                        "You have selected the maximum amount of premiums. Remove one to add another");
            return premiumIngredients.add(ingredient);

        } else if (ingredient instanceof Dressing) {
            if (dressingIngredients.size() == MAX_DRESSING_INGREDIENTS)
                throw new IllegalArgumentException(
                        "You have selected the maximum amount of dressings. Remove one to add another");
            return dressingIngredients.add(ingredient);

        }
        throw new IllegalArgumentException("Unknown ingredient");
    }

    public boolean contains(Ingredient ingredient) {
        if (ingredient instanceof Base) {
            return baseIngredients.contains(ingredient);

        } else if (ingredient instanceof Topping) {
            return toppingIngredients.contains(ingredient);

        } else if (ingredient instanceof Premium) {
            return premiumIngredients.contains(ingredient);

        } else if (ingredient instanceof  Dressing) {
            return dressingIngredients.contains(ingredient);

        }
        return false;
    }

    public boolean remove(Ingredient ingredient) {
        if (ingredient instanceof Base) {
            return baseIngredients.remove(ingredient);

        } else if (ingredient instanceof Topping) {
            return toppingIngredients.remove(ingredient);

        } else if (ingredient instanceof Premium) {
            return premiumIngredients.remove(ingredient);

        } else if (ingredient instanceof Dressing) {
            return dressingIngredients.remove(ingredient);

        }
        return false;
    }

    public boolean isEmpty() {
        return baseIngredients.isEmpty() && toppingIngredients.isEmpty()
                && premiumIngredients.isEmpty() && dressingIngredients.isEmpty();
    }

    public void clear() {
        baseIngredients.clear();
        toppingIngredients.clear();
        premiumIngredients.clear();
        dressingIngredients.clear();
    }

    @Override
    public String toString() {
        return "Salad{" +
                "name='" + name + '\'' +
                ", baseIngredients=" + baseIngredients +
                ", toppingIngredients=" + toppingIngredients +
                ", premiumIngredients=" + premiumIngredients +
                ", dressingIngredients=" + dressingIngredients +
                '}';
    }
}

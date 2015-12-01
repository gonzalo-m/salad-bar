package com.sb.saladbar.notused;

/**
 * Created by G on 11/10/15.
 *
 * This class is immutable, so there is no need for setter methods
 */
public class Ingredient implements Comparable<Ingredient> {

    private final String name;
    private final double cost;
    private final int calories;

    public Ingredient(String name, double cost) {
        this(name, cost, 0);
    }

    public Ingredient(String name, double cost, int calories) {
        this.name = name;
        this.cost = cost;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (Double.compare(that.cost, cost) != 0) return false;
        if (calories != that.calories) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + calories;
        return result;
    }

    @Override
    public int compareTo(Ingredient other) {
        return name.compareTo(other.name);
    }
}

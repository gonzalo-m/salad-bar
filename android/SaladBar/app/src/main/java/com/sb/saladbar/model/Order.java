package com.sb.saladbar.model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by G on 11/14/15.
 */
public class Order implements Serializable {

    private final TreeMap<String, Salad> saladItems;

    public Order() {
        saladItems = new TreeMap<>();
    }

    public int getNumSaladItems(){
        return saladItems.size();
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<String, Salad> entry: saladItems.entrySet()) {
            Salad salad  = entry.getValue();
            total += salad.getCost();
        }
        return total;
    }

    public int getCalories() {
        int total = 0;
        for (Map.Entry<String, Salad> entry: saladItems.entrySet()) {
            Salad salad  = entry.getValue();
            total += salad.getCalories();
        }
        return total;
    }

    public boolean isEmpty() {
        return saladItems.isEmpty();
    }

    public TreeMap<String, Salad> getSaladItems() {
        return saladItems;
    }

    public Salad addSalad(Salad salad) {
        return saladItems.put(salad.getName(), salad);
    }

    public boolean containsSalad(String saladName) {
        return saladItems.containsKey(saladName);
    }

    public Salad removeSalad(String saladName) {
        return saladItems.remove(saladName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "saladItems=" + saladItems +
                '}';
    }
}

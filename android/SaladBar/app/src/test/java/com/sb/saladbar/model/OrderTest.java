package com.sb.saladbar.model;

import com.sb.saladbar.model.ingredients.Base;
import com.sb.saladbar.model.ingredients.Dressing;
import com.sb.saladbar.model.ingredients.Premium;
import com.sb.saladbar.model.ingredients.Topping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by G on 11/14/15.
 */
public class OrderTest {

    private Salad caesar, caesar2, guacamole, hummus;
    private static final String CAESAR = "caesar";
    private static final String CAESAR2 = "caesar2";
    private static final String GUACAMOLE = "guacamole";
    private static final String HUMMUS = "hummus";

    @Before
    public void setUp() throws Exception {

        caesar = new Salad(CAESAR);
        caesar2 = new Salad(CAESAR2);
        guacamole = new Salad(GUACAMOLE);
        hummus = new Salad(HUMMUS);

        caesar.add(Base.SHREDDED_KALE);
        caesar.add(Base.CHOPPED_ROMAINE);
        caesar.add(Premium.PARMESAN_CRISP);
        caesar.add(Premium.SHAVED_PARMESAN);
        caesar.add(Premium.ROASTED_CHICKEN);
        caesar.add(Topping.TOMATO);
        caesar.add(Dressing.FRESH_LIME_SQUEEZE);
        caesar.add(Dressing.CAESAR_DRESSING);

        guacamole.add(Base.ORGANIC_MESCLUN);
        guacamole.add(Premium.AVOCADO);
        guacamole.add(Premium.ROASTED_CHICKEN);
        guacamole.add(Topping.RED_ONION);
        guacamole.add(Topping.TORTILLA_CHIPS);
        guacamole.add(Dressing.FRESH_LIME_SQUEEZE);
        guacamole.add(Dressing.LIME_CILANTRO_JALAPENO_VINAIGRETTE);

        hummus.add(Base.CHOPPED_ROMAINE);
        hummus.add(Base.SHREDDED_KALE);
        hummus.add(Premium.BAKED_FALAFEL);
        hummus.add(Premium.FETA_CHEESE);
        hummus.add(Topping.TOMATO);
        hummus.add(Topping.RED_ONION);
        hummus.add(Topping.CUCUMBER);
        hummus.add(Premium.HOUSEMADE_HUMMUS);
        hummus.add(Dressing.CUCUMBER_TAHINI_YOGURT_DRESSING);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddSalad() {
        Order order = new Order();
        assertNull(order.addSalad(caesar));
        assertEquals(caesar, order.addSalad(caesar2));
        assertNull(order.addSalad(guacamole));
        assertNull(order.addSalad(hummus));

        assertTrue(order.getNumSaladItems() == 3);
        assertTrue(order.getTotal() == caesar2.getCost() + guacamole.getCost() + hummus.getCost());
    }

    @Test
    public void testContainsSalad() {
        Order order = new Order();
        order.addSalad(caesar);
        order.addSalad(guacamole);
        order.addSalad(hummus);

        assertTrue(order.containsSalad(CAESAR));
        assertFalse(order.containsSalad(CAESAR2));
        assertTrue(order.containsSalad(GUACAMOLE));
        assertTrue(order.containsSalad(HUMMUS));
    }

    @Test
    public void testRemoveSalad() {
        Order order = new Order();
        order.addSalad(caesar);
        order.addSalad(guacamole);
        order.addSalad(hummus);

        assertEquals(caesar, order.removeSalad(CAESAR));
        assertEquals(guacamole, order.removeSalad(GUACAMOLE));
        assertEquals(hummus, order.removeSalad(HUMMUS));

        assertTrue(order.isEmpty());
    }
}
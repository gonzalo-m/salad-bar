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
 * Created by G on 11/13/15.
 */
public class SaladTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAdd() {

        Salad salad = new Salad();

        // ==============================Base ======================================================
        assertEquals(salad.getName(), "Custom Salad 0");
        assertTrue(salad.add(Base.ORGANIC_BABY_SPINACH));
        assertFalse(salad.add(Base.ORGANIC_BABY_SPINACH));
        assertTrue(salad.add(Base.CHOPPED_ROMAINE));

        try {
            salad.add(Base.ORGANIC_WILD_RICE);     // cannot add more than two bases
            fail("Exception was not thrown for base");
        } catch(IllegalArgumentException e) {}

        assertTrue(salad.getCost() == Base.ORGANIC_BABY_SPINACH.getCost()
                + Base.CHOPPED_ROMAINE.getCost());
        assertTrue(salad.getCalories() == Base.ORGANIC_BABY_SPINACH.getCalories()
                + Base.CHOPPED_ROMAINE.getCalories());
        assertTrue(salad.getTotalNumIngredients() == 2);

        // ========================= Toppings ======================================================
        assertTrue(salad.add(Topping.APPLE));
        assertFalse(salad.add(Topping.APPLE));
        assertTrue(salad.add(Topping.CILANTRO));
        assertTrue(salad.add(Topping.CUCUMBER));
        assertTrue(salad.add(Topping.BASIL));
        assertTrue(salad.add(Topping.PEARS));
        assertTrue(salad.add(Topping.PITA_CHIPS));
        assertTrue(salad.add(Topping.ORGANIC_CARROT));
        assertTrue(salad.add(Topping.ORGANIC_CHICKPEAS));
        assertTrue(salad.add(Topping.RAW_BEET));
        assertTrue(salad.add(Topping.RAW_CORN));

        try {
            salad.add(Topping.RAISINS);        // cannot add more than ten toppings
            fail("Exception was not thrown for toppings");
        } catch(IllegalArgumentException e) {}

        assertTrue(salad.getCost() == Base.ORGANIC_BABY_SPINACH.getCost()
                + Base.CHOPPED_ROMAINE.getCost()
                + Topping.APPLE.getCost() + Topping.CILANTRO.getCost()
                + Topping.CUCUMBER.getCost() + Topping.BASIL.getCost()
                + Topping.PEARS.getCost() + Topping.PITA_CHIPS.getCost()
                + Topping.ORGANIC_CARROT.getCost() + Topping.ORGANIC_CHICKPEAS.getCost()
                + Topping.RAW_BEET.getCost() + Topping.RAW_CORN.getCost());

        assertTrue(salad.getCalories() == Base.ORGANIC_BABY_SPINACH.getCalories()
                + Base.CHOPPED_ROMAINE.getCalories()
                + Topping.APPLE.getCalories() + Topping.CILANTRO.getCalories()
                + Topping.CUCUMBER.getCalories() + Topping.BASIL.getCalories()
                + Topping.PEARS.getCalories() + Topping.PITA_CHIPS.getCalories()
                + Topping.ORGANIC_CARROT.getCalories() + Topping.ORGANIC_CHICKPEAS.getCalories()
                + Topping.RAW_BEET.getCalories() + Topping.RAW_CORN.getCalories());
        assertTrue(salad.getTotalNumIngredients() == 12);

        // ========================= Premiums ======================================================
        assertTrue(salad.add(Premium.AVOCADO));
        assertFalse(salad.add(Premium.AVOCADO));
        assertTrue(salad.add(Premium.BACON));
        assertTrue(salad.add(Premium.BAKED_FALAFEL));
        assertTrue(salad.add(Premium.CITRUS_SHRIMP));
        assertTrue(salad.add(Premium.HARD_BOILED_EGG));

        try {
            salad.add(Premium.HOUSEMADE_HUMMUS);        // cannot add more than five premiums
            fail("Exception was not thrown for premiums");
        } catch(IllegalArgumentException e) {}

        assertTrue(salad.getCost() == Base.ORGANIC_BABY_SPINACH.getCost()
                + Base.CHOPPED_ROMAINE.getCost()
                + Topping.APPLE.getCost() + Topping.CILANTRO.getCost()
                + Topping.CUCUMBER.getCost() + Topping.BASIL.getCost()
                + Topping.PEARS.getCost() + Topping.PITA_CHIPS.getCost()
                + Topping.ORGANIC_CARROT.getCost() + Topping.ORGANIC_CHICKPEAS.getCost()
                + Topping.RAW_BEET.getCost() + Topping.RAW_CORN.getCost()
                + Premium.AVOCADO.getCost() + Premium.BACON.getCost()
                + Premium.BAKED_FALAFEL.getCost() + Premium.CITRUS_SHRIMP.getCost()
                + Premium.HARD_BOILED_EGG.getCost());

        assertTrue(salad.getCalories() == Base.ORGANIC_BABY_SPINACH.getCalories()
                + Base.CHOPPED_ROMAINE.getCalories()
                + Topping.APPLE.getCalories() + Topping.CILANTRO.getCalories()
                + Topping.CUCUMBER.getCalories() + Topping.BASIL.getCalories()
                + Topping.PEARS.getCalories() + Topping.PITA_CHIPS.getCalories()
                + Topping.ORGANIC_CARROT.getCalories() + Topping.ORGANIC_CHICKPEAS.getCalories()
                + Topping.RAW_BEET.getCalories() + Topping.RAW_CORN.getCalories()
                + Premium.AVOCADO.getCalories() + Premium.BACON.getCalories()
                + Premium.BAKED_FALAFEL.getCalories() + Premium.CITRUS_SHRIMP.getCalories()
                + Premium.HARD_BOILED_EGG.getCalories());
        assertTrue(salad.getTotalNumIngredients() == 17);

        // ========================= Dressings =====================================================
        assertTrue(salad.add(Dressing.BALSAMIC_VINAIGRETTE));
        assertFalse(salad.add(Dressing.BALSAMIC_VINAIGRETTE));
        assertTrue(salad.add(Dressing.BALSAMIC_VINEGAR));

        try {
            salad.add(Dressing.CAESAR_DRESSING);        // cannot add more than two dressings
            fail("Exception was not thrown for premiums");
        } catch(IllegalArgumentException e) {}

        assertTrue(salad.getCost() == Base.ORGANIC_BABY_SPINACH.getCost()
                + Base.CHOPPED_ROMAINE.getCost()
                + Topping.APPLE.getCost() + Topping.CILANTRO.getCost()
                + Topping.CUCUMBER.getCost() + Topping.BASIL.getCost()
                + Topping.PEARS.getCost() + Topping.PITA_CHIPS.getCost()
                + Topping.ORGANIC_CARROT.getCost() + Topping.ORGANIC_CHICKPEAS.getCost()
                + Topping.RAW_BEET.getCost() + Topping.RAW_CORN.getCost()
                + Premium.AVOCADO.getCost() + Premium.BACON.getCost()
                + Premium.BAKED_FALAFEL.getCost() + Premium.CITRUS_SHRIMP.getCost()
                + Premium.HARD_BOILED_EGG.getCost()
                + Dressing.BALSAMIC_VINAIGRETTE.getCost() + Dressing.BALSAMIC_VINEGAR.getCost());

        assertTrue(salad.getCalories() == Base.ORGANIC_BABY_SPINACH.getCalories()
                + Base.CHOPPED_ROMAINE.getCalories()
                + Topping.APPLE.getCalories() + Topping.CILANTRO.getCalories()
                + Topping.CUCUMBER.getCalories() + Topping.BASIL.getCalories()
                + Topping.PEARS.getCalories() + Topping.PITA_CHIPS.getCalories()
                + Topping.ORGANIC_CARROT.getCalories() + Topping.ORGANIC_CHICKPEAS.getCalories()
                + Topping.RAW_BEET.getCalories() + Topping.RAW_CORN.getCalories()
                + Premium.AVOCADO.getCalories() + Premium.BACON.getCalories()
                + Premium.BAKED_FALAFEL.getCalories() + Premium.CITRUS_SHRIMP.getCalories()
                + Premium.HARD_BOILED_EGG.getCalories()
                + Dressing.BALSAMIC_VINAIGRETTE.getCalories() + Dressing.BALSAMIC_VINEGAR.getCalories());
        assertTrue(salad.getTotalNumIngredients() == 19);

    }

    @Test
    public void testContains() {

        Salad salad = new Salad();

        salad.add(Base.ORGANIC_BABY_SPINACH);
        salad.add(Topping.CUCUMBER);
        salad.add(Premium.BACON);
        salad.add(Dressing.BALSAMIC_VINEGAR);

        assertTrue(salad.contains(Base.ORGANIC_BABY_SPINACH));
        assertTrue(salad.contains(Topping.CUCUMBER));
        assertTrue(salad.contains(Premium.BACON));
        assertTrue(salad.contains(Dressing.BALSAMIC_VINEGAR));

        assertFalse(salad.contains(Base.ORGANIC_WILD_RICE));
        assertFalse(salad.contains(Topping.RAISINS));
        assertFalse(salad.contains(Premium.HOUSEMADE_HUMMUS));
        assertFalse(salad.contains(Dressing.CAESAR_DRESSING));
    }

    @Test
    public void testRemove() {

        Salad salad = new Salad();

        salad.add(Base.ORGANIC_BABY_SPINACH);
        salad.add(Topping.CUCUMBER);
        salad.add(Premium.BACON);
        salad.add(Dressing.BALSAMIC_VINEGAR);

        assertFalse(salad.remove(Base.ORGANIC_WILD_RICE));
        assertFalse(salad.remove(Topping.RAISINS));
        assertFalse(salad.remove(Premium.HOUSEMADE_HUMMUS));
        assertFalse(salad.remove(Dressing.CAESAR_DRESSING));

        assertTrue(salad.remove(Base.ORGANIC_BABY_SPINACH));
        assertTrue(salad.remove(Topping.CUCUMBER));
        assertTrue(salad.remove(Premium.BACON));
        assertTrue(salad.remove(Dressing.BALSAMIC_VINEGAR));

        assertTrue(salad.isEmpty());

        salad.add(Base.ORGANIC_BABY_SPINACH);
        salad.add(Topping.CUCUMBER);
        salad.add(Premium.BACON);
        salad.add(Dressing.BALSAMIC_VINEGAR);

        salad.clear();

        assertTrue(salad.isEmpty());
    }
}
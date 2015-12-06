package com.sb.saladbar.model;

import com.sb.saladbar.model.ingredients.Base;
import com.sb.saladbar.model.ingredients.Dressing;
import com.sb.saladbar.model.ingredients.Premium;
import com.sb.saladbar.model.ingredients.Topping;
import com.sb.saladbar.model.orderprocessor.OnOrderProcessed;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by G on 11/14/15.
 */
public class OrderProcessorTest {

    private Salad caesar, caesar2, guacamole, hummus;
    private static final String CAESAR = "caesar";
    private static final String CAESAR2 = "caesar";
    private static final String GUACAMOLE = "guacamole";
    private static final String HUMMUS = "hummus";

    private static final boolean[] result = new boolean[2];

    @Before
    public void setUp() {

        caesar = new Salad(CAESAR);
        caesar2 = new Salad(CAESAR2);
        guacamole = new Salad(GUACAMOLE);
        hummus = new Salad(HUMMUS);

        caesar.add(Base.SHREDDED_KALE);
        caesar.add(Base.CHOPPED_ROMAINE);
//        caesar.add(Premium.PARMESAN_CRISP);
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
//        hummus.add(Premium.BAKED_FALAFEL);
//        hummus.add(Premium.FETA_CHEESE);
        hummus.add(Topping.TOMATO);
        hummus.add(Topping.RED_ONION);
        hummus.add(Topping.CUCUMBER);
        hummus.add(Premium.HOUSEMADE_HUMMUS);
        hummus.add(Dressing.CUCUMBER_TAHINI_YOGURT_DRESSING);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testPlaceOrder() throws InterruptedException {
        final Order order = new Order();
        order.addSalad(caesar);

        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);

        final OnOrderProcessed onOrderProcessed = new OnOrderProcessed() {
            @Override
            public void onOnOrderConfirmation(OrderConfirmation orderConfirmation) {
                System.out.println("Order confirmed");
                result[0] = orderConfirmation.getOrderNum() == 1;
            }

            @Override
            public void onOrderReady(OrderConfirmation orderConfirmation) {
                System.out.println("Order ready");
                result[1] = orderConfirmation.getOrderPlaced().containsSalad(CAESAR);
                signal.countDown();

            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {

                OrderConfirmation confirmation = new OrderConfirmation(order);
                final int twoSeconds = 2000;
                final int fiveSeconds = 5000;
                sleep(twoSeconds); // simulate salad ordering request
                onOrderProcessed.onOnOrderConfirmation(confirmation);
                sleep(fiveSeconds); // simulate cooking staff preparing food
                onOrderProcessed.onOrderReady(confirmation);

            }
            private void sleep(int delay) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        signal.await();
        assertTrue(result[0]);
        assertTrue(result[1]);
    }
}
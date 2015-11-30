package com.sb.saladbar.model;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by G on 11/19/15.
 */
public class OrderProcessor {

    public static String TAG = OrderProcessor.class.getSimpleName();

    public static void placeOrder(Order order, OnOrderProcessed onOrderProcessed) {

        new PlaceOrderTask(onOrderProcessed).execute(order);

    }


    static class PlaceOrderTask extends AsyncTask<Order, Void, OrderConfirmation> {

        private OnOrderProcessed onOrderProcessed;

        public PlaceOrderTask(OnOrderProcessed onOrderProcessed) {
            this.onOrderProcessed = onOrderProcessed;
        }

        @Override
        protected OrderConfirmation doInBackground(Order... params) {

            Order placedOrder = params[0];
            return new OrderConfirmation(placedOrder);
        }

        @Override
        protected void onPostExecute(OrderConfirmation orderConfirmation) {


            final int twoSeconds = 2000;
            final int fiveSeconds = 5000;
            sleep(twoSeconds); // simulate salad ordering request
            onOrderProcessed.onOnOrderConfirmation(orderConfirmation);
            sleep(fiveSeconds); // simulate cooking staff preparing food
            onOrderProcessed.onOrderReady(orderConfirmation);

        }

        private void sleep(int delay) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Log.e(TAG, e.toString());
            }
        }
    }

}

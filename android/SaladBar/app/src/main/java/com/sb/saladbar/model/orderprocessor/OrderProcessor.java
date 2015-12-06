package com.sb.saladbar.model.orderprocessor;

import android.os.AsyncTask;
import android.util.Log;

import com.sb.saladbar.model.Order;
import com.sb.saladbar.model.OrderConfirmation;

/**
 * Created by G on 11/19/15.
 */
public class OrderProcessor {

    public static String TAG = OrderProcessor.class.getSimpleName();

    public static void placeOrder(Order order, OnOrderProcessed onOrderProcessed,
                                  int processDelay, int cookDelay) {

        new PlaceOrderTask(onOrderProcessed, processDelay, cookDelay).execute(order);

    }


    static class PlaceOrderTask extends AsyncTask<Order, Void, OrderConfirmation> {

        private OnOrderProcessed onOrderProcessed;
        private int processDelay;
        private int cookDelay;

        public PlaceOrderTask(OnOrderProcessed onOrderProcessed, int processDelay, int cookDelay) {
            this.onOrderProcessed = onOrderProcessed;
            this.processDelay = processDelay;
            this.cookDelay = cookDelay;
        }

        @Override
        protected OrderConfirmation doInBackground(Order... params) {

            Order placedOrder = params[0];
            sleep(processDelay);    // simulate salad ordering request
            return new OrderConfirmation(placedOrder);
        }

        @Override
        protected void onPostExecute(OrderConfirmation orderConfirmation) {

            onOrderProcessed.onOnOrderConfirmation(orderConfirmation);
            new CookOrderTask(onOrderProcessed, cookDelay).execute(orderConfirmation);
        }

        private void sleep(int delay) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    static class CookOrderTask extends AsyncTask<OrderConfirmation, Void, OrderConfirmation> {

        private OnOrderProcessed onOrderProcessed;
        private int cookDelay;

        public CookOrderTask(OnOrderProcessed onOrderProcessed, int cookDelay) {
            this.onOrderProcessed = onOrderProcessed;
            this.cookDelay = cookDelay;
        }

        @Override
        protected OrderConfirmation doInBackground(OrderConfirmation... params) {

            OrderConfirmation confirmation = params[0];
            sleep(cookDelay);   // simulate cooking staff preparing food
            return confirmation;
        }

        @Override
        protected void onPostExecute(OrderConfirmation orderConfirmation) {

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

package com.sb.saladbar.model;

/**
 * Created by G on 11/23/15.
 */
public interface OnOrderProcessed {

    void onOnOrderConfirmation(OrderConfirmation orderConfirmation);

    void onOrderReady(OrderConfirmation orderConfirmation);
}

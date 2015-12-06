package com.sb.saladbar.model.orderprocessor;

import com.sb.saladbar.model.OrderConfirmation;

/**
 * Created by G on 11/23/15.
 */
public interface OnOrderProcessed {

    void onOnOrderConfirmation(OrderConfirmation orderConfirmation);

    void onOrderReady(OrderConfirmation orderConfirmation);
}

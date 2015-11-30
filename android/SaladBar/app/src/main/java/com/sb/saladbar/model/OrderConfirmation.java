package com.sb.saladbar.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by G on 11/23/15.
 */
public class OrderConfirmation {

    private static int orderIds = 1;

    private final int orderNum;
    private final Calendar confirmationDate;
    private final Order orderPlaced;

    public OrderConfirmation(Order orderPlaced) {
        orderNum = orderIds++;
        confirmationDate = Calendar.getInstance();
        this.orderPlaced = orderPlaced;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public Calendar getConfirmationDate() {
        return confirmationDate;
    }

    public Order getOrderPlaced() {
        return orderPlaced;
    }

}

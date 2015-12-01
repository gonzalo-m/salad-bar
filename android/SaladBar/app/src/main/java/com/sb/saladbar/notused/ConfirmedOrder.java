package com.sb.saladbar.notused;

import com.sb.saladbar.model.Order;

import java.util.Date;

/**
 * Created by G on 11/2/15.
 */
public class ConfirmedOrder extends Order {

    private final int orderNumber;
    private final Date confirmationDate;

    public ConfirmedOrder(int orderNumber, Date confirmationDate) {
        this.orderNumber = orderNumber;
        this.confirmationDate = confirmationDate;

    }

    public int getOrderNumber() {
        new Date();
        return orderNumber;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

}

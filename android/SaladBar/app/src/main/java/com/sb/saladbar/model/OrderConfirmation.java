package com.sb.saladbar.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by G on 11/23/15.
 */
public class OrderConfirmation extends Order {

    private static int orderIds;

    private int orderNum;
    private Calendar confirmationDate;

    public OrderConfirmation(Order order) {
        orderNum = orderIds++;
        confirmationDate = Calendar.getInstance();
    }

    public static void setOrderIds(int orderIds) {
        OrderConfirmation.orderIds = orderIds;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }
}

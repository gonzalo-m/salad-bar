package com.sb.saladbar.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by G on 11/23/15.
 */
public class OrderConfirmation implements Serializable {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM-dd-yyyy", Locale.US);
    private final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("h:mma", Locale.US);

    private static int orderIds = 1;

    private final String orderNum;
    private final String date;
    private final String time;
    private final String total;
    private final Order orderPlaced;

    public OrderConfirmation(Order orderPlaced) {
        orderNum = String.valueOf(orderIds++);
        Calendar cal = Calendar.getInstance();
        date = DATE_FORMAT.format(cal.getTime());
        time = TIME_FORMAT.format(cal.getTime());
        total = String.valueOf(orderPlaced.getTotal());

        this.orderPlaced = orderPlaced;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public String getConfirmationTime() {
        return time;
    }

    public String getConfirmationDate() {
        return date;
    }

    public Order getOrderPlaced() {
        return orderPlaced;
    }

    public String getTotal() {
        return total;
    }

}

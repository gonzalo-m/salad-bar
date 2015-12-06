package com.sb.saladbar.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by G on 11/23/15.
 */
public class OrderConfirmation implements Serializable {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM-dd-yyyy", Locale.US);
    private final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("h:mma", Locale.US);

    private static int orderIds = 1;

    private final int orderNum;
    private final String date;
    private final String time;
    private final Order orderPlaced;

    public OrderConfirmation(Order orderPlaced) {
        orderNum = orderIds++;
        date = DATE_FORMAT.format(Calendar.getInstance().getTime());
        time = TIME_FORMAT.format(Calendar.getInstance().getTime());
        this.orderPlaced = orderPlaced;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getConfirmationTime() {
        return time;
    }

    public String getConfirmationDate() {
        return date;
    }

    public List<Salad> getSaladItems() {
        return new ArrayList<>(orderPlaced.getSaladItems().values());
    }

    public double getTotal() {
        return orderPlaced.getTotal();
    }

}

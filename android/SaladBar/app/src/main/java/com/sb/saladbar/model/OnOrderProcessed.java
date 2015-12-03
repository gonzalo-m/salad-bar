package com.sb.saladbar.model;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.sb.saladbar.R;


public class OnOrderProcessed {
    static NotificationManager mNotificationManager;
    private static Context mContext;

    public OnOrderProcessed(Context context) {
        mContext = context;
    }

    public static void onOnOrderConfirmation(OrderConfirmation orderConfirmation){
        //set loading screen to simulate salad ordering request?
        Toast.makeText(mContext, "Order Confirmed", Toast.LENGTH_LONG).show();
    }

    public static void onOrderReady(OrderConfirmation orderConfirmation) {
        //Send notification to notification area
        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        CharSequence title = "SweetGreen";
        CharSequence text = "Your Order Is Ready";
        Notification.Builder orderReadyNotification = new Notification.Builder(mContext)
                .setContentText(text)
                .setContentTitle(text)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.green2)
                .setOngoing(true)
                .setAutoCancel(true);
        PendingIntent mContentIntent = PendingIntent.getActivity(mContext, 0, new Intent(), 0);
        orderReadyNotification.setContentIntent(mContentIntent);
        mNotificationManager.notify(0, orderReadyNotification.build());

        //Send Toast notification
        Toast.makeText(mContext, "Your Order Is Ready", Toast.LENGTH_LONG).show();
    }
}


package com.sb.saladbar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sb.saladbar.model.OnOrderProcessed;
import com.sb.saladbar.model.Order;
import com.sb.saladbar.model.OrderConfirmation;
import com.sb.saladbar.model.OrderProcessor;
import com.sb.saladbar.model.Salad;

//Todo will make list adapter for list view and order object.
public class PlaceOrderFragment extends Fragment implements OnOrderProcessed {

    private static final String TAG = PlaceOrderFragment.class.getSimpleName();
    private Order mOrder = new Order();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_place_order, null);
        Button placeOrderButton = (Button) rootView.findViewById(R.id.button_place_order);
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
        return rootView;
    }

    /**
     * Called only by its parent Activity (SalasBarHostActivity)
     * @param salad
     */
    public void updateOrder(Salad salad) {
        mOrder.addSalad(salad);
        updateViews();
    }

    private void placeOrder() {
        ((SaladBarHostActivity) getActivity()).showProgressDialog(R.string.progress_message);
        int processDelay = 3000;    // after 3 sec.
        int cookDelay = 5000;       // after 3 + 5 sec.
        OrderProcessor.placeOrder(mOrder, this, processDelay, cookDelay);
    }

    //Todo add data to be passed to the activity
    public void openConfirmationActivity() {
        Intent intent = new Intent(this.getActivity(), OrderConfirmationActivity.class);
        startActivity(intent);
    }

    public void updateViews() {
        //TODO:  (Aldene) update views with order object
        Log.i(TAG, mOrder.toString());
    }

    @Override
    public void onOnOrderConfirmation(OrderConfirmation orderConfirmation) {
        ((SaladBarHostActivity) getActivity()).hideProgressBar();
        openConfirmationActivity();
    }

    @Override
    public void onOrderReady(OrderConfirmation orderConfirmation) {
        Vibrator vibrator = (Vibrator) getActivity().getSystemService(getContext().VIBRATOR_SERVICE);
        vibrator.vibrate(500);

        //Send notification to notification area
        NotificationManager notificationManager =
                (NotificationManager)getActivity().getSystemService(getContext().NOTIFICATION_SERVICE);
        CharSequence title = "SweetGreen";
        CharSequence text = "Your Order Is Ready";
        Notification.Builder orderReadyNotification = new Notification.Builder(getContext())
                .setContentText(text)
                .setContentTitle(text)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.green2)
                .setOngoing(true)
                .setAutoCancel(true);
        PendingIntent mContentIntent = PendingIntent.getActivity(getContext(), 0, new Intent(), 0);
        orderReadyNotification.setContentIntent(mContentIntent);
        notificationManager.notify(0, orderReadyNotification.build());
    }
}

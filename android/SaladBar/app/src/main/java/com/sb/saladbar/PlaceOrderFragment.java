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
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.sb.saladbar.model.OnOrderProcessed;
import com.sb.saladbar.model.Order;
import com.sb.saladbar.model.OrderConfirmation;
import com.sb.saladbar.model.OrderProcessor;
import com.sb.saladbar.model.Salad;
import com.sb.saladbar.utility.CustomListAdapter;

import java.util.Map;

public class PlaceOrderFragment extends Fragment implements OnOrderProcessed {

    private static final String TAG = PlaceOrderFragment.class.getSimpleName();
    private Order mOrder = new Order();

    CustomListAdapter customListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_place_order, container, false);
        Button placeOrderButton = (Button) rootView.findViewById(R.id.button_place_order);

        // Added just to test if listview is working. Remove.
        RelativeLayout footer = (RelativeLayout) inflater.inflate(R.layout.order_list_item_view, null);

        ListView listView = (ListView)rootView.findViewById(R.id.listView);
        listView.addFooterView(footer);

        customListAdapter = new CustomListAdapter(getActivity());
        listView.setAdapter(customListAdapter);

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

    public void openConfirmationActivity(OrderConfirmation orderConfirmation) {
        Intent intent = new Intent(this.getActivity(), OrderConfirmationActivity.class);
        intent.putExtra(Intent.EXTRA_INTENT, orderConfirmation);
        startActivity(intent);
    }

    public void updateViews() {
        //TODO:  (Aldene) update views with order object
        //Todo customListAdapter becomes null here. will fix.
        Log.i(TAG, mOrder.toString());
        if(null == mOrder.getSaladItems()) {
            for (Map.Entry<String, Salad> entry : mOrder.getSaladItems().entrySet()) {
                //customListAdapter.add(entry.getValue());
            }
        }


        // To test listview (temporary)
        if(null == customListAdapter){
            Log.i(TAG, "customListAdapter is null");
        } else {
            Log.i(TAG, "customListAdapter is not null");

            for(int i = 0; i < 5; i++){
                Salad temp = new Salad();
                customListAdapter.add(temp);
                Log.i(TAG, "Loop number " + i);
            }

        }
    }

    @Override
    public void onOnOrderConfirmation(OrderConfirmation orderConfirmation) {
        ((SaladBarHostActivity) getActivity()).hideProgressBar();
        openConfirmationActivity(orderConfirmation);
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

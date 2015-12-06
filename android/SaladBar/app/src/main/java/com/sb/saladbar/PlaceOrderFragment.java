package com.sb.saladbar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sb.saladbar.model.orderprocessor.OnOrderProcessed;
import com.sb.saladbar.model.Order;
import com.sb.saladbar.model.OrderConfirmation;
import com.sb.saladbar.model.orderprocessor.OrderProcessor;
import com.sb.saladbar.model.Salad;

import java.text.NumberFormat;
import java.util.Map;

public class PlaceOrderFragment extends Fragment {

    private static final String TAG = PlaceOrderFragment.class.getSimpleName();

    private Order mOrder;
    private SaladListAdapter mSaladListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSaladListAdapter = new SaladListAdapter(getActivity().getApplicationContext());
        mOrder = ((SaladBarHostActivity)getActivity()).getOrder();
        for(Map.Entry entry : mOrder.getSaladItems().entrySet()) {
            mSaladListAdapter.add((Salad) entry.getValue());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_place_order, container, false);
        Button placeOrderButton = (Button) rootView.findViewById(R.id.button_place_order);
        ListView listView = (ListView)rootView.findViewById(R.id.listView);
        listView.setAdapter(mSaladListAdapter);
        TextView totalPriceTextView = (TextView) rootView.findViewById(R.id.textView_order_total_price);
        totalPriceTextView.setText(NumberFormat.getCurrencyInstance().format(mOrder.getTotal()));

        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SaladBarHostActivity)getActivity()).placeOrder();
            }
        });

        return rootView;
    }
}

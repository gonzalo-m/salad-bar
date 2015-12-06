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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sb.saladbar.model.orderprocessor.OnOrderProcessed;
import com.sb.saladbar.model.Order;
import com.sb.saladbar.model.OrderConfirmation;
import com.sb.saladbar.model.orderprocessor.OrderProcessor;
import com.sb.saladbar.model.Salad;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlaceOrderFragment extends Fragment {

    private static final String TAG = PlaceOrderFragment.class.getSimpleName();

    private Order mOrder;
    private SaladListAdapter mSaladListAdapter;
    private Set<Integer> deleteSet;
    private TextView mTotalPriceTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSaladListAdapter = new SaladListAdapter(getActivity().getApplicationContext());
        mOrder = ((SaladBarHostActivity)getActivity()).getOrder();
        for(Map.Entry entry : mOrder.getSaladItems().entrySet()) {
            mSaladListAdapter.add((Salad) entry.getValue());
        }
        deleteSet = new HashSet<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_place_order, container, false);
        Button placeOrderButton = (Button) rootView.findViewById(R.id.button_place_order);
        ListView listView = (ListView)rootView.findViewById(R.id.listView);
        listView.setAdapter(mSaladListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView deleteTextView = (TextView) view.findViewById(R.id.textView_salad_delete);
                if (deleteTextView.getVisibility() == View.GONE) {
                    deleteTextView.setVisibility(View.VISIBLE);
                    deleteSet.add(position);
                } else {
                    deleteTextView.setVisibility(View.GONE);
                    deleteSet.remove(position);
                }
                if (deleteSet.isEmpty()) {
                    ((SaladBarHostActivity)getActivity()).hideDeleteButton();
                } else {
                    ((SaladBarHostActivity)getActivity()).showDeleteButton();
                }
            }
        });
        mTotalPriceTextView = (TextView) rootView.findViewById(R.id.textView_order_total_price);

        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SaladBarHostActivity) getActivity()).placeOrder();
            }
        });

        updatePrice();

        return rootView;
    }

    public void updatePrice() {
        mTotalPriceTextView.setText(NumberFormat.getCurrencyInstance().format(mOrder.getTotal()));
    }

    public void removeMarkedSalads() {
        List<Salad> temp = new ArrayList<>();
        for(Integer i : deleteSet) {
            temp.add((Salad) mSaladListAdapter.getItem(i));
        }
        deleteSet.clear();
        for(Salad s : temp) {
            mSaladListAdapter.remove(s);
            mOrder.removeSalad(s.getName());
        }
        updatePrice();
        ((SaladBarHostActivity)getActivity()).hideDeleteButton();
    }
}

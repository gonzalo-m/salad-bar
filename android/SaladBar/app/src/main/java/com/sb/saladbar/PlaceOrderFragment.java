package com.sb.saladbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sb.saladbar.model.OrderConfirmation;

//Todo will make list adapter for list view and order object.
public class PlaceOrderFragment extends Fragment {

    private static final String TAG = PlaceOrderFragment.class.getSimpleName();

    Button placeOrderButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_place_order, null);
        placeOrderButton = (Button) rootView.findViewById(R.id.button_place_order);
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfirmationActivity();
            }
        });
        return rootView;
    }

    //Todo add data to be passed to the activity
    public void openConfirmationActivity(){
        Intent intent = new Intent(this.getActivity(), OrderConfirmationActivity.class);
        startActivity(intent);
    }

}

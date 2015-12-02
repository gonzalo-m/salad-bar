package com.sb.saladbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RestaurantSelectorFragment extends android.support.v4.app.Fragment {

    private static final String TAG = RestaurantSelectorFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant_selector, null);
        return rootView;
    }

}

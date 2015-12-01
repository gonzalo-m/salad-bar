package com.sb.saladbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sb.saladbar.fragmenttabs.BaseFragmentTab;
import com.sb.saladbar.fragmenttabs.PremiumFragmentTab;
import com.sb.saladbar.fragmenttabs.ToppingFragmentTab;


public class SaladBarFragment extends Fragment {

    private static final String TAG = SaladBarFragment.class.getSimpleName();

    public static final String BASES        = "Bases";
    public static final String TOPPINGS     = "Toppings";
    public static final String PREMIUMS     = "Premiums";
    public static final String DRESSINGS    = "Dressings";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_salad_bar, null);
        FragmentTabHost tabHost = (FragmentTabHost) rootView.findViewById(android.R.id.tabhost);
        rootView.findViewById(R.id.salad).setOnDragListener(new MyDragListener());

        tabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec(BASES).setIndicator(BASES, null),
                FragmentTab.class, null);
        tabHost.addTab(tabHost.newTabSpec(TOPPINGS).setIndicator(TOPPINGS, null),
                FragmentTab.class, null);
        tabHost.addTab(tabHost.newTabSpec(PREMIUMS).setIndicator(PREMIUMS, null),
                FragmentTab.class, null);
        tabHost.addTab(tabHost.newTabSpec(DRESSINGS).setIndicator(DRESSINGS, null),
                FragmentTab.class, null);
        return rootView;
    }

    class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    // TODO - Update View:v to incorporate the new ingredient

                    Log.i(TAG, "ingredient dropped");

                    // that was dragged into v.
                    // Data from the new dragged ingredient can be
                    // accessed from the DragEvent: event.
                    // -- still need to figure exactly how to do this.
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }
}

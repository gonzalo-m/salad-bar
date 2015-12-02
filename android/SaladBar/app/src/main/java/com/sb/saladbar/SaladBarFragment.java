package com.sb.saladbar;

import android.content.ClipData;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sb.saladbar.fragmenttabs.BaseFragmentTab;
import com.sb.saladbar.fragmenttabs.DressingFragmentTab;
import com.sb.saladbar.fragmenttabs.PremiumFragmentTab;
import com.sb.saladbar.fragmenttabs.ToppingFragmentTab;
import com.sb.saladbar.model.Salad;
import com.sb.saladbar.model.ingredients.Base;
import com.sb.saladbar.model.ingredients.Dressing;
import com.sb.saladbar.model.ingredients.Ingredient;
import com.sb.saladbar.model.ingredients.Premium;
import com.sb.saladbar.model.ingredients.Topping;

import java.text.NumberFormat;


public class SaladBarFragment extends Fragment {

    private static final String TAG = SaladBarFragment.class.getSimpleName();

    public static final String DRAG_DATA_KEY = "TYPE";

    public static final String BASES        = "Bases";
    public static final String TOPPINGS     = "Toppings";
    public static final String PREMIUMS     = "Premiums";
    public static final String DRESSINGS    = "Dressings";

    private Salad mSalad;
    private TextView mPriceView;
    private TextView mCaloriesView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSalad = new Salad();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_salad_bar, null);
        mPriceView = (TextView) rootView.findViewById(R.id.salad_price);
        mCaloriesView = (TextView) rootView.findViewById(R.id.salad_calories);
        FragmentTabHost tabHost = (FragmentTabHost) rootView.findViewById(android.R.id.tabhost);
        rootView.findViewById(R.id.salad).setOnDragListener(new MyDragListener());

        tabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec(BASES).setIndicator(BASES),
                BaseFragmentTab.class, null);
        tabHost.addTab(tabHost.newTabSpec(TOPPINGS).setIndicator(TOPPINGS),
                ToppingFragmentTab.class, null);
        tabHost.addTab(tabHost.newTabSpec(PREMIUMS).setIndicator(PREMIUMS),
                PremiumFragmentTab.class, null);
        tabHost.addTab(tabHost.newTabSpec(DRESSINGS).setIndicator(DRESSINGS),
                DressingFragmentTab.class, null);

        return rootView;
    }

    public void updateOrder(Ingredient ingredient) {

        boolean reachedMax = false;
        //TODO: 1. disable views when salad reached max number of ingredients for each type
        if (ingredient instanceof Base) {
            reachedMax = mSalad.getNumBaseIngredients() == Salad.MAX_BASE_INGREDIENTS ? true : false;
        } else if (ingredient instanceof Topping) {
            reachedMax = mSalad.getNumToppingIngredients() == Salad.MAX_TOPPING_INGREDIENTS ? true : false;

        } else if (ingredient instanceof Premium) {
            reachedMax = mSalad.getNumPremiumIngredients() == Salad.MAX_PREMIUM_INGREDIENTS ? true : false;

        } else if (ingredient instanceof Dressing) {
            reachedMax = mSalad.getNumDressingIngredients() == Salad.MAX_DRESSING_INGREDIENTS ? true : false;

        }
        if (!reachedMax) {
            mSalad.add(ingredient);
            updateViews();
        }
        Log.i(TAG, mSalad.toString());
    }

    private void updateViews() {
        mPriceView.setText(NumberFormat.getCurrencyInstance().format(mSalad.getCost()));
        mCaloriesView.setText(String.valueOf(mSalad.getCalories()) + " cal.");
    }

    /**
     * Only called by its parent Activity (SaladBarFragment)
     * @return
     */
    public Salad getAssembledSalad() {
        return mSalad;
    }

    /**
     * Only called by its parent Activity (SaladBarFragment)
     * @return
     */
    public void assembleNewSalad() {
        mSalad = new Salad();
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
                    ClipData.Item item = event.getClipData().getItemAt(0);
                    Ingredient ingredient = (Ingredient) item.getIntent().getExtras().get(DRAG_DATA_KEY);
                    Log.i(TAG, "ingredient dropped: " + ingredient.getName());
                    updateOrder(ingredient);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }
}

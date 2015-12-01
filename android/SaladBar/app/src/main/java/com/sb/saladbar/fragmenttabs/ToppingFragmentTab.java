package com.sb.saladbar.fragmenttabs;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.sb.saladbar.R;


public class ToppingFragmentTab extends Fragment {

    private static int[] imgs = {
            R.drawable.topping_pita_chip, R.drawable.topping_tortilla_chips,
            R.drawable.topping_toasted_almonds, R.drawable.topping_sunflower_seeds,
            R.drawable.topping_raw_seeds, R.drawable.topping_roasted_sweet_potato,
            R.drawable.topping_spicy_quinoa, R.drawable.topping_peppers,
            R.drawable.topping_sprouts, R.drawable.topping_organic_carrot,
            R.drawable.topping_shredded_cabbage, R.drawable.topping_raw_beet,
            R.drawable.topping_roasted_brussel_sprouts, R.drawable.topping_spicy_broccoli,
            R.drawable.topping_red_onion, R.drawable.topping_cucumber,
            R.drawable.topping_organic_chickpeas, R.drawable.topping_tomato,
            R.drawable.topping_apples, R.drawable.topping_basil,
            R.drawable.topping_cilantro, R.drawable.topping_raisins,
            R.drawable.topping_raw_pecan, R.drawable.topping_pear,
            R.drawable.topping_raw_corn};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scrollable_ingredients, container, false);
        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.ingredients);
        for (int i = 0; i < imgs.length; i++) {
            // TODO - add names of toppings
            RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            param.setMargins(100, 100, 100, 100);
            ImageView temp = new ImageView(getActivity());
            temp.setLayoutParams(param);
            temp.setImageDrawable(getResources().getDrawable(imgs[i]));
            temp.setOnTouchListener(new MyTouchListener());
            temp.setAdjustViewBounds(true);
            linearLayout.addView(temp);
        }
        return v;
    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.VISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }
}


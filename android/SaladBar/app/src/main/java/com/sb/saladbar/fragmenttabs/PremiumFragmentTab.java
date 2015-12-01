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

public class PremiumFragmentTab extends Fragment {

    private static int[] imgs = {
            R.drawable.premium_housemade_hummus, R.drawable.premium_goat_cheese,
            R.drawable.premium_organic_white_cheddar, R.drawable.premium_shaved_parmesan,
            R.drawable.premium_hard_boiled_egg, R.drawable.premium_roasted_curry_cauliflower,
            R.drawable.premium_avocado, R.drawable.premium_bacon,
            R.drawable.premium_roasted_chicken};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scrollable_ingredients, container, false);
        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.ingredients);
        for (int i = 0; i < imgs.length; i++) {
            // TODO - add names of premiums
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
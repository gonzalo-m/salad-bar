package com.sb.saladbar;

import android.content.ClipData;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.sb.saladbar.model.ingredients.Base;
import com.sb.saladbar.model.ingredients.Dressing;
import com.sb.saladbar.model.ingredients.Ingredient;
import com.sb.saladbar.model.ingredients.Premium;
import com.sb.saladbar.model.ingredients.Topping;


public class FragmentTab extends Fragment {

    public static final String TAG = FragmentTab.class.getSimpleName();

    private Ingredient[] ingredients;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String type = getArguments().getString("type");
        Log.i(TAG, getArguments().toString());
        switch (type) {
            case SaladBarFragment.BASES:
                ingredients = Base.values();
                break;
            case SaladBarFragment.TOPPINGS:
                ingredients = Topping.values();
                break;
            case SaladBarFragment.PREMIUMS:
                ingredients = Premium.values();
                break;
            case SaladBarFragment.DRESSINGS:
                ingredients = Dressing.values();
                break;
            default:
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scrollable_ingredients, container, false);
        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.ingredients);
        for (Ingredient ingredient: ingredients) {
            RelativeLayout.LayoutParams param =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            param.setMargins(100, 100, 100, 100);
            ImageView temp = new ImageView(getActivity());
            temp.setLayoutParams(param);
            temp.setImageResource(ingredient.getResId());
            temp.setTag(ingredient);
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


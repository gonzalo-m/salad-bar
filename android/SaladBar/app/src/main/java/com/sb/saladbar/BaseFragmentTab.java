package com.sb.saladbar;

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

public class BaseFragmentTab extends Fragment {

    private static int[] imgs = {
            R.drawable.base_organic_argula, R.drawable.base_organic_baby_spinach,
            R.drawable.base_organic_mesclun, R.drawable.base_organic_wild_rice,
            R.drawable.base_shredded_kale, R.drawable.base_organic_quinoa_farro,
            R.drawable.base_chooped_romaine};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scrollable_ingredients, container, false);
        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.ingredients);
        for (int i = 0; i < imgs.length; i++) {
            // TODO - add names of bases
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

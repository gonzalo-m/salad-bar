package com.sb.saladbar.fragmenttabs;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sb.saladbar.ImageStateTracker;
import com.sb.saladbar.R;
import com.sb.saladbar.SaladBarFragment;
import com.sb.saladbar.model.ingredients.Base;
import com.sb.saladbar.model.ingredients.Ingredient;


import static com.sb.saladbar.SaladBarFragment.*;

public class BaseFragmentTab extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scrollable_ingredients, container, false);
        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.ingredients);
        ImageStateTracker imageStateTracker = (ImageStateTracker) getArguments().get("imageState");
        for (Ingredient ingredient: Base.values()) {
            View viewGroup = LayoutInflater.from(getContext()).inflate(
                    R.layout.ingredient_view_group, null);

            SaladBarFragment.OnClickCallback onClickCallback = new SaladBarFragment.OnClickCallback(ingredient);

            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.ingredient_img);
            imageView.setImageResource(ingredient.getResId());
            imageView.setId(ingredient.getResId());
            imageView.setOnLongClickListener(new MyTouchListener());
            imageView.setAdjustViewBounds(true);
            Intent data = new Intent();
            data.putExtra(SaladBarFragment.DRAG_DATA_KEY, (Base) ingredient);
            imageView.setTag(data);
            imageView.setOnClickListener(onClickCallback);
            TextView textView = (TextView) viewGroup.findViewById(R.id.ingredient_str);
            textView.setText(ingredient.getName());
            textView.setTextSize(14);


            if (!(imageStateTracker.getImageStateHashMap().size() == 0) && imageStateTracker.contains(ingredient)) {
                ColorMatrix matrix = new ColorMatrix();
                matrix.setSaturation(0);
                ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
                imageView.setColorFilter(cf);
                imageView.setAlpha(0.5f);
            }

            linearLayout.addView(viewGroup);
        }
        return v;
    }

    private final class MyTouchListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View view) {
            Intent intent = (Intent) view.getTag();
            Base ingredient = (Base) intent.getExtras().get(DRAG_DATA_KEY);
            ClipData.Item item =  new ClipData.Item(intent);
            ClipData dragData = new ClipData(ingredient.getName(),
                    new String[]{ ClipDescription.MIMETYPE_TEXT_PLAIN }, item);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(dragData, shadowBuilder, view, 0);
            view.setVisibility(View.VISIBLE);
            return true;
        }
    }

}

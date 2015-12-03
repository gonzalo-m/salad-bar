package com.sb.saladbar;

import android.content.ClipData;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

import java.io.Serializable;
import java.text.NumberFormat;


public class SaladBarFragment extends Fragment {

    private static final String TAG = SaladBarFragment.class.getSimpleName();

    public static final String DRAG_DATA_KEY = "TYPE";

    public static final String BASES        = "Bases";
    public static final String TOPPINGS     = "Toppings";
    public static final String PREMIUMS     = "Premiums";
    public static final String DRESSINGS    = "Dressings";

    private static Salad mSalad;
    private static TextView mPriceView;
    private static TextView mCaloriesView;

    private FragmentTabHost mTabHost;

    private static ImageStateTracker mImageState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        mSalad = new Salad();
        mImageState = new ImageStateTracker();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_salad_bar, null);
        mPriceView = (TextView) rootView.findViewById(R.id.salad_price);
        mCaloriesView = (TextView) rootView.findViewById(R.id.salad_calories);
        mTabHost = (FragmentTabHost) rootView.findViewById(android.R.id.tabhost);
        rootView.findViewById(R.id.salad).setOnDragListener(new MyDragListener());

        mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        Bundle bundle = new Bundle();
        bundle.putSerializable("imageState", mImageState);

        mTabHost.addTab(mTabHost.newTabSpec(BASES).setIndicator(BASES),
                BaseFragmentTab.class, bundle);
        mTabHost.addTab(mTabHost.newTabSpec(TOPPINGS).setIndicator(TOPPINGS),
                ToppingFragmentTab.class, bundle);
        mTabHost.addTab(mTabHost.newTabSpec(PREMIUMS).setIndicator(PREMIUMS),
                PremiumFragmentTab.class, bundle);
        mTabHost.addTab(mTabHost.newTabSpec(DRESSINGS).setIndicator(DRESSINGS),
                DressingFragmentTab.class, bundle);

        return rootView;
    }

    public void updateOrder(Ingredient ingredient) {

        boolean reachedMax = false;
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
            setLocked(ingredient);
            updateViews();
        }
    }

    private void setLocked(Ingredient ingredient) {
        ImageView imageView = (ImageView) mTabHost.getChildAt(0).findViewById(ingredient.getResId());
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
        imageView.setColorFilter(cf);
        imageView.setAlpha(0.5f);
        mImageState.add(ingredient, true);
    }


    private static void updateViews() {
        mPriceView.setText(NumberFormat.getCurrencyInstance().format(mSalad.getCost()));
        mCaloriesView.setText(String.valueOf(mSalad.getCalories()) + " cal.");
    }

    /**
     * Called only by its parent Activity to get current salad(SaladBarFragment)
     * @return
     */
    public Salad getAssembledSalad() {
        return mSalad;
    }

    /**
     * Called only by its parent Activity to create new salad (SaladBarFragment)
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


    public static class OnClickCallback implements Serializable, View.OnClickListener {

        private Ingredient ingredient;

        public OnClickCallback(Ingredient ingredient ){
            this.ingredient = ingredient;
        }

        @Override
        public void onClick(View v) {
            ImageView image = (ImageView) v;
            if (image.getAlpha() == 0.5f) {
                image.setAlpha(1.0f);
                image.setColorFilter(null);
                mSalad.remove(ingredient);
                updateViews();
                mImageState.remove(ingredient);
            }
        }
    }

}

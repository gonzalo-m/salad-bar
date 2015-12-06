package com.sb.saladbar.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sb.saladbar.R;
import com.sb.saladbar.model.Salad;
import com.sb.saladbar.model.ingredients.Ingredient;


import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated
 * Created by AVillardo on 12/2/2015.
 */
public class CustomListAdapter extends BaseAdapter {

    Context mContext;
    private final List<Salad> saladItems = new ArrayList<>();

    public CustomListAdapter(Context context) {
        this.mContext = context;
    }


    public void add(Salad item){
        saladItems.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Salad item = (Salad) getItem(position);

        LinearLayout itemLayout = (LinearLayout) LayoutInflater.from(mContext)
                .inflate(R.layout.order_list_item_view, parent, false);

        final TextView orderNumTextView = (TextView) itemLayout.findViewById(R.id.textView_confirmation_number);
        final TextView orderNameTextView = (TextView) itemLayout.findViewById(R.id.textView_salad_name);
        final TextView orderIngredientsTextView = (TextView) itemLayout.findViewById(R.id.textView_salad_ingredients);
        final TextView orderPriceTextView = (TextView) itemLayout.findViewById(R.id.textView_salad_price);

        orderNumTextView.setText(position);
        orderPriceTextView.setText(item.getCost()+"");
        orderNameTextView.setText(item.getName());

        String ingredients = ingredientsToString(item);
        orderIngredientsTextView.setText(ingredients);
        return itemLayout;
    }

    public String ingredientsToString(Salad salad) {
        String ingredients = null;

        for (Ingredient i : salad.getBaseIngredients()) {
            ingredients += i.getName() + " ";
        }

        for (Ingredient i : salad.getDressingIngredients()) {
            ingredients += i.getName() + " ";
        }

        for (Ingredient i : salad.getPremiumIngredients()) {
            ingredients += i.getName() + " ";
        }

        for (Ingredient i : salad.getToppingIngredients()) {
            ingredients += i.getName() + " ";
        }
        return ingredients;
    }
}

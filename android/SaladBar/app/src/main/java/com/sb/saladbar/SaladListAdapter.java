package com.sb.saladbar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sb.saladbar.model.Salad;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by G on 12/5/15.
 */
public class SaladListAdapter extends BaseAdapter {

    public static final String TAG = SaladListAdapter.class.getSimpleName();

    private List<Salad> mSaladItems = new ArrayList<>();
    private Context mContext;

    public SaladListAdapter(Context context) {
        mContext = context;
    }

    public void add(Salad saladItem) {
        mSaladItems.add(saladItem);
        notifyDataSetChanged();
    }

    public void remove(Salad saladItem) {
        mSaladItems.remove(saladItem);
        notifyDataSetChanged();
    }

    public void clear() {
        mSaladItems.clear();
        notifyDataSetChanged();
    }

    public List<Salad> getSaladItems() {
        return mSaladItems;
    }

    @Override
    public int getCount() {
        return mSaladItems.size();
    }

    @Override
    public Object getItem(int pos) {
        return mSaladItems.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos; // same as the position
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.i(TAG, "getView " + position + " " + convertView);

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.order_list_item_view, null);
            holder = new ViewHolder();
            holder.saladName = (TextView) convertView.findViewById(R.id.textView_salad_name);
            holder.ingredients = (TextView) convertView.findViewById(R.id.textView_salad_ingredients);
            holder.price = (TextView) convertView.findViewById(R.id.textView_salad_price);
            holder.deleteGlyph = (TextView) convertView.findViewById(R.id.textView_salad_delete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Salad saladItem = mSaladItems.get(position);
        holder.saladName.setText(saladItem.getName());
        holder.ingredients.setText(saladItem.getAllIngredients());
        holder.price.setText(NumberFormat.getCurrencyInstance().format(saladItem.getCost()));
        holder.deleteGlyph.setVisibility(View.GONE);

        return convertView;
    }

    public static class ViewHolder {
        public TextView saladName;
        public TextView ingredients;
        public TextView price;
        public TextView deleteGlyph;
    }
}

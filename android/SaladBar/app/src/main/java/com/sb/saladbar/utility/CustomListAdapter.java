package com.sb.saladbar.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sb.saladbar.R;
import com.sb.saladbar.model.Salad;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
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

        final TextView orderNumTextView = (TextView) itemLayout.findViewById(R.id.textView_order_number);
        final TextView orderNameTextView = (TextView) itemLayout.findViewById(R.id.textView_order_name);
        final TextView orderIngredientsTextView = (TextView) itemLayout.findViewById(R.id.textView_order_ingredients);
        final TextView orderPriceTextView = (TextView) itemLayout.findViewById(R.id.textView_order_price);

        return itemLayout;
    }
}

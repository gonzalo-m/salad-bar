package com.sb.saladbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.sb.saladbar.model.OrderConfirmation;
import com.sb.saladbar.model.Salad;

import java.text.NumberFormat;

public class OrderConfirmationActivity extends AppCompatActivity {

    public static final String TAG = OrderConfirmation.class.getSimpleName();

    private TextView mDateTextView, mTimeTextView, mConfirmationNumTextView, mTotalView;
    private ListView mSaladList;
    private SaladListAdapter mConfirmedSaladAdapter;
    private OrderConfirmation mOrderConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        mOrderConfirmation = (OrderConfirmation) getIntent().getSerializableExtra(Intent.EXTRA_INTENT);
        Log.i(TAG, mOrderConfirmation.toString());

        mDateTextView = (TextView) findViewById(R.id.textView_order_date);
        mTimeTextView = (TextView) findViewById(R.id.textView_order_time);
        mConfirmationNumTextView = (TextView) findViewById(R.id.textView_confirmation_number);
        mTotalView = (TextView) findViewById(R.id.textView_order_total_amount);
        mSaladList = (ListView) findViewById(R.id.listView);

        setImmutableAdapter();  // reuse adapter from PlaceOrderFragment

        updateHeaderView();
        updateFooterView();
        updateItemViews();
    }

    private void setImmutableAdapter() {
        mConfirmedSaladAdapter = new SaladListAdapter(this) {

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                Log.i(TAG, "getView " + position + " " + convertView);

                ViewHolder holder;

                if (convertView == null) {
                    convertView = LayoutInflater.from(OrderConfirmationActivity.this)
                            .inflate(R.layout.order_list_item_view, null);
                    holder = new ViewHolder();
                    holder.saladName = (TextView) convertView.findViewById(R.id.textView_salad_name);
                    holder.ingredients = (TextView) convertView.findViewById(R.id.textView_salad_ingredients);
                    holder.price = (TextView) convertView.findViewById(R.id.textView_salad_price);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                Salad saladItem = getSaladItems().get(position);
                holder.saladName.setText(saladItem.getName());
                holder.ingredients.setText(saladItem.getAllIngredients());
                holder.price.setText(NumberFormat.getCurrencyInstance().format(saladItem.getCost()));

                return convertView;
            }
        };
    }

    private void updateHeaderView() {
        mConfirmationNumTextView.setText(String.valueOf(mOrderConfirmation.getOrderNum()));
        mTimeTextView.setText(mOrderConfirmation.getConfirmationDate());
        mDateTextView.setText(mOrderConfirmation.getConfirmationTime());
    }

    private void updateFooterView() {
        mTotalView.setText(NumberFormat.getCurrencyInstance().format(mOrderConfirmation.getTotal()));
    }

    private void updateItemViews() {
        for (Salad s : mOrderConfirmation.getSaladItems())
            mConfirmedSaladAdapter.add(s);
        mSaladList.setAdapter(mConfirmedSaladAdapter);
    }
}

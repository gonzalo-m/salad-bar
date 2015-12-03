package com.sb.saladbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sb.saladbar.model.OrderConfirmation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OrderConfirmationActivity extends AppCompatActivity {

    public static final String TAG = OrderConfirmation.class.getSimpleName();



    private TextView mDateTextView, mTimeTextView, mConfirmationNumTextView, mTotalView;
    private OrderConfirmation mOrderConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        //TODO: here is the orderConfirmation ready to be used
        mOrderConfirmation = (OrderConfirmation) getIntent().getSerializableExtra(Intent.EXTRA_INTENT);
        Log.i(TAG, mOrderConfirmation.toString());

        mDateTextView = (TextView) findViewById(R.id.textView_order_date);
        mTimeTextView = (TextView) findViewById(R.id.textView_order_time);
        mConfirmationNumTextView = (TextView) findViewById(R.id.textView_confirmation_number);
        mTotalView = (TextView) findViewById(R.id.textView_order_total_amount);


        updateHeaderView();
        updateFooterView();
        updateItemViews();
    }

    private void updateHeaderView() {
        String orderNum = mOrderConfirmation.getOrderNum();
        String date = mOrderConfirmation.getConfirmationDate();
        String time = mOrderConfirmation.getConfirmationTime();
        mConfirmationNumTextView.setText(orderNum);
        mTimeTextView.setText(time);
        mDateTextView.setText(date);
    }

    private void updateFooterView() {

    }

    private void updateItemViews() {
        String total = mOrderConfirmation.getTotal();
        mTotalView.setText(total);
    }
}

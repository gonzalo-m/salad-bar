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

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM-dd-yyyy", Locale.US);
    private final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("h:mma", Locale.US);

    TextView dateTextView, timeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        //TODO: (Aldene) here is the orderConfirmation ready to be used
        OrderConfirmation orderConfirmation = (OrderConfirmation) getIntent().getSerializableExtra(Intent.EXTRA_INTENT);
        Log.i(TAG, orderConfirmation.toString());

        Calendar cal = Calendar.getInstance();
        String dateText = DATE_FORMAT.format(cal.getTime());
        String timeText = TIME_FORMAT.format(cal.getTime());

        dateTextView = (TextView) findViewById(R.id.textView_order_date);
        timeTextView = (TextView) findViewById(R.id.textView_order_time);

        dateTextView.setText(dateText);
        timeTextView.setText(timeText.toLowerCase());
    }
}

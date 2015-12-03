package com.sb.saladbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OrderConfirmationActivity extends AppCompatActivity {
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM-dd-yyyy", Locale.US);
    private final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("h:mma", Locale.US);

    TextView dateTextView, timeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        Calendar cal = Calendar.getInstance();
        String dateText = DATE_FORMAT.format(cal.getTime());
        String timeText = TIME_FORMAT.format(cal.getTime());

        dateTextView = (TextView) findViewById(R.id.textView_order_date);
        timeTextView = (TextView) findViewById(R.id.textView_order_time);

        dateTextView.setText(dateText);
        timeTextView.setText(timeText.toLowerCase());
    }
}

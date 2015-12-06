package com.sb.saladbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RestaurantSelectorActivity extends AppCompatActivity {

    public final static String RESTAURANT_NAME = "Restaurant";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_selector);
    }

    public void continueActivity(View v ) {
        Intent intent = new Intent(this, SaladBarHostActivity.class);
        intent.putExtra(RESTAURANT_NAME, (String)v.getTag());
        startActivity(intent);
    }

}

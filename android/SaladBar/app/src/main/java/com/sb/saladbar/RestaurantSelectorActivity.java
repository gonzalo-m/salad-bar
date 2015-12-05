package com.sb.saladbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RestaurantSelectorActivity extends AppCompatActivity {

    public final static String RESTAURANT_NAME = "SweetGreens";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_selector);
    }

    public void continueActivity(View v ) {
        Intent intent = new Intent(this, SaladBarHostActivity.class);
        RadioGroup rg = (RadioGroup)findViewById(R.id.Restaurant_Choice);
        String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        intent.putExtra(RESTAURANT_NAME, radiovalue);
        startActivity(intent);
    }

}

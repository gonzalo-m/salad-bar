package com.sb.saladbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class SaladBarHostActivity extends AppCompatActivity {

    private static final String TAG = SaladBarHostActivity.class.getSimpleName();

    private SaladBarFragment mSaladBarFragment = new SaladBarFragment();
    private PlaceOrderFragment mPlaceOrderFragment = new PlaceOrderFragment();
    private RestaurantSelectorFragment mRestaurantSelectorFragment = new RestaurantSelectorFragment();

    private MenuItem mToggleMenuButton;
    private MenuItem mToggleMenuButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_bar_host);
//
        setTitle("Sweetgreen");
        getSupportActionBar().setIcon(R.drawable.ic_drawer);

        // add to host activity
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, mSaladBarFragment)
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_salad_bar_host, menu);
        mToggleMenuButton = menu.findItem(R.id.action_add_order);
        mToggleMenuButton2 = menu.findItem(R.id.action_choose_restaurant);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_order) {
            Log.i(TAG, "adding order");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToggleMenuButton.setVisible(true);
            mToggleMenuButton.setIcon(android.R.drawable.ic_input_add);
            mToggleMenuButton2.setVisible(false);
            showNextFragment(null);
            return true;
        } else if (id == android.R.id.home) {
            Log.i(TAG, "back");
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            mToggleMenuButton.setVisible(true);
            mToggleMenuButton.setIcon(R.drawable.paperbag_brown);
            mToggleMenuButton2.setVisible(true);
            getSupportFragmentManager().popBackStack();
        } else if (id == R.id.action_choose_restaurant) {
            Log.i(TAG, "adding order");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToggleMenuButton.setVisible(false);
            mToggleMenuButton2.setVisible(false);
            showRsFragment(null);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void showNextFragment(String backStackName) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit,
                        R.anim.slide_left_enter, R.anim.slide_right_exit)
                .replace(R.id.fragment_container, mPlaceOrderFragment)
                .addToBackStack(backStackName)
                .commit();
        getFragmentManager().executePendingTransactions();
    }

    public void showRsFragment(String backStackName) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit,
                        R.anim.slide_left_enter, R.anim.slide_right_exit)
                .replace(R.id.fragment_container, mRestaurantSelectorFragment)
                .addToBackStack(backStackName)
                .commit();
        getFragmentManager().executePendingTransactions();
    }

}

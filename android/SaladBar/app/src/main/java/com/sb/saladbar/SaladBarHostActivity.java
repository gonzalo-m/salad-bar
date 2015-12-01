package com.sb.saladbar;

import android.support.v4.app.Fragment;
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

    private MenuItem mToggleMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_bar_host);

        setTitle("Sweetgreen");

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
            Fragment currFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (currFragment != null && currFragment.isVisible()) {
                if (currFragment instanceof SaladBarFragment) {
                    Log.i(TAG, "curr: salad");
                    showNextFragment();
                } else if (currFragment instanceof  PlaceOrderFragment ){
                    Log.i(TAG, "curr: order");
                    showPreviousFragment();
                }
            }


            return true;

        } else if (id == android.R.id.home) {
            Log.i(TAG, "back");
            showPreviousFragment();
        }

        return super.onOptionsItemSelected(item);
    }


    public void showNextFragment() {
        mToggleMenuButton.setIcon(android.R.drawable.ic_input_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit,
                        R.anim.slide_left_enter, R.anim.slide_right_exit)
                .replace(R.id.fragment_container, mPlaceOrderFragment)
                .addToBackStack(null)
                .commit();
        getFragmentManager().executePendingTransactions();
    }

    public void showPreviousFragment() {
        mToggleMenuButton.setIcon(R.drawable.paperbag_brown);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportFragmentManager().popBackStack();
    }

}

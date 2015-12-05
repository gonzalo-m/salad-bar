package com.sb.saladbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.sb.saladbar.model.Salad;
import com.sb.saladbar.utility.ShakeDeviceManager;



public class SaladBarHostActivity extends AppCompatActivity {

    private static final String TAG = SaladBarHostActivity.class.getSimpleName();

    private SaladBarFragment mSaladBarFragment = new SaladBarFragment();
    private PlaceOrderFragment mPlaceOrderFragment = new PlaceOrderFragment();

    private MenuItem mToggleMenuButton;
    private ProgressDialog mProgressDialog;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDeviceManager mShakeDeviceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_bar_host);

        mProgressDialog = new ProgressDialog(this, AlertDialog.THEME_HOLO_DARK);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        Intent intent = getIntent();
        setTitle(intent.getStringExtra(RestaurantSelectorActivity.RESTAURANT_NAME));
        setTitle("RestaurantSelectorActivity Not Active"); // TODO: REMOVE THIS LINE

        // add to host activity
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, mSaladBarFragment)
                .commit();

        //shake feature
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDeviceManager = new ShakeDeviceManager();
        mShakeDeviceManager.setOnShakeListener(new ShakeDeviceManager.OnShakeListener() {
            @Override
            public void onShake(int count) {
                mSaladBarFragment.fillRandomSalad();
            }

        });
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
            Fragment currFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (currFragment != null && currFragment.isVisible()) {
                if (currFragment instanceof SaladBarFragment) {
                    Salad temp = mSaladBarFragment.getAssembledSalad();
                    mPlaceOrderFragment.updateOrder(temp);
                    showNextFragment();
                } else if (currFragment instanceof  PlaceOrderFragment) {
                    mSaladBarFragment.assembleNewSalad();
                    showPreviousFragment();
                }
            }
            return true;

        } else if (id == android.R.id.home) {
            showPreviousFragment();
        }

        return super.onOptionsItemSelected(item);
    }


    private void showNextFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit,
                        R.anim.slide_left_enter, R.anim.slide_right_exit)
                .replace(R.id.fragment_container, mPlaceOrderFragment)
                .addToBackStack(null)
                .commit();
        mToggleMenuButton.setIcon(android.R.drawable.ic_input_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showPreviousFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_right_exit,
                        R.anim.slide_right_enter, R.anim.slide_left_exit)
                .replace(R.id.fragment_container, mSaladBarFragment)
                .addToBackStack(null)
                .commit();
        mToggleMenuButton.setIcon(R.drawable.paperbag_brown);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void showProgressDialog(int resId) {
        mProgressDialog.setMessage(getResources().getString(resId));
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
    }

    public void hideProgressBar() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onResume() {
        super.onResume();
        //register Sensor manager onResume
        mSensorManager.registerListener(mShakeDeviceManager, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        //unregister Sensor manager onPause
        mSensorManager.unregisterListener(mShakeDeviceManager);
        super.onPause();
    }
}

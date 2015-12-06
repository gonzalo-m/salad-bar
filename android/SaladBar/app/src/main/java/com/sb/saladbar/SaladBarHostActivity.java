package com.sb.saladbar;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.sb.saladbar.model.Order;
import com.sb.saladbar.model.OrderConfirmation;
import com.sb.saladbar.model.Salad;
import com.sb.saladbar.model.orderprocessor.OnOrderProcessed;
import com.sb.saladbar.model.orderprocessor.OrderProcessor;
import com.sb.saladbar.utility.ShakeDeviceManager;


public class SaladBarHostActivity extends AppCompatActivity implements OnOrderProcessed {

    private static final String TAG = SaladBarHostActivity.class.getSimpleName();

    private SaladBarFragment mSaladBarFragment;
    private PlaceOrderFragment mPlaceOrderFragment;

    private MenuItem mToggleMenuButton;
    private ProgressDialog mProgressDialog;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDeviceManager mShakeDeviceManager;

    private Order mOrder;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_bar_host);

        mSaladBarFragment = new SaladBarFragment();
        mPlaceOrderFragment = new PlaceOrderFragment();
        mOrder = new Order();

        mProgressDialog = new ProgressDialog(this, AlertDialog.THEME_HOLO_DARK);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        Intent intent = getIntent();
        setTitle(intent.getStringExtra(RestaurantSelectorActivity.RESTAURANT_NAME));

        // add to host activity
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, mSaladBarFragment)
//                .addToBackStack(null)
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

    /**
     * Called only by the PlaceOrderFragment to populate the ListView
     */
    public Order getOrder() {
        return mOrder;
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
            Fragment currFragment =
                    getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (currFragment != null && currFragment.isVisible()) {
                if (currFragment instanceof SaladBarFragment) {
                    showPlaceOrderFragment();
                } else if (currFragment instanceof  PlaceOrderFragment) {
                    showSaladBarFragment(true);
                }
            }
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void showBagButton() {
        mToggleMenuButton.setIcon(R.drawable.paperbag_brown);
    }

    public void showPlusButton() {
        mToggleMenuButton.setIcon(android.R.drawable.ic_input_add);
    }

    private void showToast(int message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showPlaceOrderFragment() {
        Salad assembledSalad = mSaladBarFragment.getAssembledSalad();
        if (assembledSalad.isEmpty()){
            showToast(R.string.toast_empty_salad);
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit,
                            R.anim.slide_left_enter, R.anim.slide_right_exit)
                    .replace(R.id.fragment_container, mPlaceOrderFragment)
//                .addToBackStack(null)
                    .commit();
            mOrder.addSalad(assembledSalad);
            showPlusButton();
        }
    }

    private void showSaladBarFragment(boolean animation) {
        if (animation) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_right_exit,
                            R.anim.slide_right_enter, R.anim.slide_left_exit)
                    .replace(R.id.fragment_container, mSaladBarFragment)
//                .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, mSaladBarFragment)
//                .addToBackStack(null)
                    .commit();
        }
        showBagButton();
        mSaladBarFragment.assembleNewSalad();
        mOrder = new Order();
        // TODO: also reset views state
    }


    public void showProgressDialog(int resId) {
        mProgressDialog.setMessage(getResources().getString(resId));
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
    }

    public void placeOrder() {
        showProgressDialog(R.string.progress_message);
        int processDelay = 3000;    // after 3 sec.
        int cookDelay = 5000;       // after 3 + 5 sec.
        OrderProcessor.placeOrder(mOrder, this, processDelay, cookDelay);
    }

    public void hideProgressBar() {
        mProgressDialog.dismiss();
    }

    public void openConfirmationActivity(OrderConfirmation orderConfirmation) {
        Intent intent = new Intent(this, OrderConfirmationActivity.class);
        intent.putExtra(Intent.EXTRA_INTENT, orderConfirmation);
        startActivity(intent);
    }

    @Override
    public void onOnOrderConfirmation(OrderConfirmation orderConfirmation) {
        hideProgressBar();
        mOrder.setConfirmed(true);
        openConfirmationActivity(orderConfirmation);
    }

    @Override
    public void onOrderReady(OrderConfirmation orderConfirmation) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(500);

        //Send notification to notification area
        NotificationManager notificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        CharSequence ticker = getTitle() + " - Order is ready";
        CharSequence title = getTitle();
        CharSequence text = "Order #: " + orderConfirmation.getOrderNum();
        Notification.Builder orderReadyNotification = new Notification.Builder(this)
                .setTicker(ticker)
                .setContentText(text)
                .setContentTitle(title)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.green2)
                .setOngoing(true)
                .setAutoCancel(true);
        PendingIntent mContentIntent = PendingIntent.getActivity(this, 0, new Intent(), 0);
        orderReadyNotification.setContentIntent(mContentIntent);
        notificationManager.notify(orderConfirmation.getOrderNum(), orderReadyNotification.build());
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
        if (mOrder.isConfirmed()) {
            // reset to show SaladBarFragment
            showSaladBarFragment(false);
        }
        super.onPause();
    }
}

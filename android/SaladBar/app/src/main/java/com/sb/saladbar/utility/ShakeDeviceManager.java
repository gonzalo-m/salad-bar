package com.sb.saladbar.utility;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by AVillardo on 11/15/2015.
 */

// Manages device shake detection. Implement this class on an activity to use.
/*
 * In the activity where this interface is used:
 * 1. Make a new Instance of ShakeDeviceManager
 * 2. setOnShakeListener on that ShakeDeviceManager object. in onCreate() in the activity.
 * 3. registerListener for the object in onResume() in the activity.
 * 4. unRegisterListener for the object in onPause() in the activity.
 *
 */
public class ShakeDeviceManager implements SensorEventListener{

    private static final float GRAVITY_MAX_SHAKE_LIM = 2.7F;
    private static final int SHAKE_SLOP_TIME = 500;
    private static final int SHAKE_COUNT_TIME_RESET = 3000;
    private OnShakeListener mListener;
    private long deviceShakeTime;
    private int deviceShakeCount;

    public  void setOnShakeListener(OnShakeListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(mListener != null) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            //Earth's gravity SI units
            float gravX = x / SensorManager.GRAVITY_EARTH;
            float gravY = y / SensorManager.GRAVITY_EARTH;
            float gravZ = z / SensorManager.GRAVITY_EARTH;

            float gravForce = (float) Math.sqrt(gravX * gravX + gravY * gravY + gravZ * gravZ);

            if(GRAVITY_MAX_SHAKE_LIM < gravForce) {
                final long firstMoveTime =  System.currentTimeMillis();
                // Ignore small shakes movements
                if(deviceShakeTime + SHAKE_SLOP_TIME > firstMoveTime) {
                    return;
                }

                // Reset shake counter if no shakes detected
                if(deviceShakeTime + SHAKE_COUNT_TIME_RESET < firstMoveTime) {
                    deviceShakeCount = 0;
                }

                deviceShakeTime = firstMoveTime;
                deviceShakeCount++;

                mListener.onShake(deviceShakeCount);
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public interface OnShakeListener {
        void onShake(int count);
    }

}

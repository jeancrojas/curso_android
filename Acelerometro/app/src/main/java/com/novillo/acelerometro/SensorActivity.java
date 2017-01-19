package com.novillo.acelerometro;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by cice on 23/12/16.
 */

public class SensorActivity extends Activity implements SensorEventListener {

   private final SensorManager sensorManager;
   private final Sensor mAccelerometer;


   public SensorActivity() {

      sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

      mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

      sensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
   }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

package com.novillo.acelerometro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor mAccelerometer;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

       float x = sensorEvent.values[0];
       float y = sensorEvent.values[1];
       float z = sensorEvent.values[2];
        Log.d("X", String.valueOf(x));
        //Log.d("Y", String.valueOf(y));
        //Log.d("Z", String.valueOf(z));

        if (x < -2 || x > 2){
            relativeLayout = (RelativeLayout)findViewById(R.id.activity_main);
            relativeLayout.setBackgroundResource(R.color.colorPrimary);
        }

        if (x > -2 && x < 2){
            relativeLayout = (RelativeLayout)findViewById(R.id.activity_main);
            relativeLayout.setBackgroundResource(R.color.colorAccent);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

package com.magicdate.accelerometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager ;

    Sensor accelerometer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Initializing Sensor Services") ;

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(MainActivity.this , accelerometer , SensorManager.SENSOR_DELAY_NORMAL) ;

        Log.d("MainActivity" , "OnCreate :  Registered accelerometer listener") ;

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //if((event.values[0] != event.values[0]) || event.values[1] != event.values[1] || event.values[2] != event.values[2])
        Log.d("MainActivity" , "onSensorChanged: X : " + event.values[0] + " Y : " + event.values[1] + " Z : " + event.values[2]) ;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

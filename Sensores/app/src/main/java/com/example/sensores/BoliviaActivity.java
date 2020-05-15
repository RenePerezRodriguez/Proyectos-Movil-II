package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BoliviaActivity extends AppCompatActivity implements  SensorEventListener {

    SensorManager sensorm = null;
    Sensor sensorgiroscopio;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolivia);

        sensorm =  (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorgiroscopio = sensorm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorm.registerListener((SensorEventListener) this,sensorgiroscopio,SensorManager.SENSOR_DELAY_NORMAL);
        imagen = (ImageView) findViewById(R.id.imgbolvia);

    }

   /* public void onResume() {
        super.onResume();


    }*/
    protected void onStop() {
        super.onStop();
        sensorm.unregisterListener(this, sensorm.getDefaultSensor(Sensor.TYPE_GYROSCOPE));

    }



    @Override
    public void onSensorChanged(SensorEvent event) {

        //Drawable image = getResources().getDrawable(R.mipmap.bol1);

        switch (event.sensor.getType()) {
            case Sensor.TYPE_GYROSCOPE:

                if(event.values[2] > 0.5f) { // antihora

                    imagen.getResources().getDrawable(R.mipmap.bol2);


                } else if(event.values[2] < -0.5f) { // hora

                    imagen.getResources().getDrawable(R.mipmap.bol3);

                }
                break;

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

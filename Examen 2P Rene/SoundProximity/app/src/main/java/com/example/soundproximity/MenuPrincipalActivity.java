package com.example.soundproximity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MenuPrincipalActivity extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    Button pausa;
    SoundPool soundPool;
    int chicken,cow,sheep,car,bus;
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);

        chicken=soundPool.load(this, R.raw.chicken, 1);
        cow=soundPool.load(this, R.raw.cow, 1);
        sheep=soundPool.load(this, R.raw.sheep, 1);
        car=soundPool.load(this, R.raw.car, 1);
        bus=soundPool.load(this, R.raw.bus, 1);



        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (sensor==null)
            finish();
    }
    public void start(){
        sensorManager.registerListener(sensorEventListener,sensor,2000*1000);
    }
    public void stop() {
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }

    public void all(View view){

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0]<sensor.getMaximumRange())
                {
                    int[] sonidos = new int[]{chicken,cow,sheep,car,bus};
                    int sonidoAleatorio = sonidos[random.nextInt(sonidos.length)];
                    soundPool.play(sonidoAleatorio, 1,1, 1, 1, 0);
                }else {
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        start();

    }
    public void animales(View view){

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0]<sensor.getMaximumRange())
                {
                    int[] sonidos = new int[]{chicken,cow,sheep};
                    int sonidoAleatorioAnimales = sonidos[random.nextInt(sonidos.length)];
                    soundPool.play(sonidoAleatorioAnimales, 1,1, 1, 1, 0);                }else {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        start();
    }
    public void vehiculos(View view){

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0]<sensor.getMaximumRange())
                {
                    int[] sonidos = new int[]{car,bus};
                    int sonidoAleatorioVehiculos = sonidos[random.nextInt(sonidos.length)];
                    soundPool.play(sonidoAleatorioVehiculos, 1,1, 1, 1, 0);                }else {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        start();
    }
}

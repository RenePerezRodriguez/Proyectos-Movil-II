package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bolivia(View view){

        Intent intent = new Intent(MainActivity.this, BoliviaActivity.class);
        startActivity(intent);
    }
    public void argentina(View view){

        Intent intent = new Intent(MainActivity.this, ArgentinaActivity.class);
        startActivity(intent);
    }
    public void peru(View view){

        Intent intent = new Intent(MainActivity.this, PeruActivity.class);
        startActivity(intent);
    }
}

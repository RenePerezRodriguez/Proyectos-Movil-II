package com.example.aplicacionbase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bhoraEntrada, bhoraSalida;
    private EditText horaEntrada,horaSalida;
    private RadioButton particular,publico,oficial;
    private int horas,minutos;

    Handler handler = new Handler();

    private final int TIEMPO = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        particular=findViewById(R.id.rbtParticular);
        publico=findViewById(R.id.rbtPublico);
        oficial=findViewById(R.id.rbtOficial);

        bhoraEntrada=findViewById(R.id.btnHoraEntrada);
        bhoraSalida=findViewById(R.id.btnHoraSalida);

        horaEntrada=findViewById(R.id.txtHoraEntrada);
        horaSalida=findViewById(R.id.txtHoraSalida);

        bhoraEntrada.setOnClickListener(this);
        bhoraSalida.setOnClickListener(this);
    }

    public void onMapReady() {

        ejecutarTarea();

    }

    public void ejecutarTarea() {
        handler.postDelayed(new Runnable() {
            public void run() {


                //VALIDACION Y OPERACIONES
                if ()
                handler.postDelayed(this, TIEMPO);
            }

        }, TIEMPO);

    }

    @Override
    public void onClick(View v) {
        if (v==bhoraEntrada)
        {
            final Calendar calendar = Calendar.getInstance();
            horas=calendar.get(Calendar.HOUR_OF_DAY);
            minutos=calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    horaEntrada.setText(hourOfDay+":"+minute);
                }
            },horas,minutos,false);
            timePickerDialog.show();
        }
        if (v==bhoraSalida)
        {
            final Calendar calendar = Calendar.getInstance();
            horas=calendar.get(Calendar.HOUR_OF_DAY);
            minutos=calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    horaSalida.setText(hourOfDay+":"+minute);
                }
            },horas,minutos,false);
            timePickerDialog.show();
        }
    }
}

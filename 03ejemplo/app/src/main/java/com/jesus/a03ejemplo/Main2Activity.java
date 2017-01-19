package com.jesus.a03ejemplo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class Main2Activity extends AppCompatActivity {

    Context context = this;
    DatePickerDialog fechaActual;
    TimePickerDialog horaActual;
    AlertDialog.Builder alertDialogBuilder;


    DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        }
    };

    TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonVolver         = (Button)findViewById(R.id.buttonVolver);
        Button buttonMostrarFecha   = (Button)findViewById(R.id.buttonMostrarFecha);
        Button buttonMostrarHora    = (Button)findViewById(R.id.buttonMostrarHora);
        Button buttonSalir          = (Button)findViewById(R.id.buttonSalir);



        buttonVolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(context, MainActivity.class));
                finish();
            }
        });

        buttonMostrarFecha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                fechaActual = new DatePickerDialog (context,datePickerListener, 2016, 11, 07);
                fechaActual.show();
            }
        });

        buttonMostrarHora.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                horaActual = new TimePickerDialog(context, timePickerListener, 20, 15, true);
                horaActual.show();
            }
        });

        buttonSalir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setTitle("Ejemplo AlertDialog");

                alertDialogBuilder
                        .setMessage("Pulsa aqui para salir")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener(){
                            public void  onClick(DialogInterface dialog, int d){
                                Main2Activity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int d) {
                               dialog.cancel();
                           }
                        })
                        .setNeutralButton("Mostrar hora", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int d) {
                                horaActual = new TimePickerDialog(context, timePickerListener, 20, 15, true);
                                horaActual.show();
                            }
                        })

                        ;
                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();

            }
        });




    }

    //para boton de atras del movil que muestre tambien dialogo de confirmacion
    @Override
    public void onBackPressed() {
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start2", "Start2");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stop2", "Stop2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroy2", "Destroy2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pause2", "Pause2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume2", "Resume2");
    }
}

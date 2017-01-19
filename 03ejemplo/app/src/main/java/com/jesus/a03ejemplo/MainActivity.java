package com.jesus.a03ejemplo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Creado", "Creado");

        Button buttonIr   = (Button)findViewById(R.id.buttonIr);

        buttonIr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               startActivity(new Intent(context, Main2Activity.class));
            }
        });

        Toast.makeText(getApplicationContext(), "PULSA BOTON IR PARA CAMBIAR DE PANTALLA", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start", "Start");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stop", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroy", "Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pause", "Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume", "Resume");
    }


}

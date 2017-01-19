package com.jesus.aplicacion02login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlotaMotos fMotos = new FlotaMotos();
        FlotaFurgonetas fFurgonetas = new FlotaFurgonetas();
    }

        public static void seleccionar(Iterador<Vehiculo> iterador){
            while(iterador.hasNext()){
                Log.d("Modelo", iterador.next().getModelo())
            }
        }




}
